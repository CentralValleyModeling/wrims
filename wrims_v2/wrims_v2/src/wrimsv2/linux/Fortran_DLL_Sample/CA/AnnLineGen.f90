! Last change: RW Feb 8,2003 and Shengjun 2/22/2005

! Function provides access to the ANN code and returns the slope and intercept of the export-
! Sac location in the Delta given a history of flow values.

! LOCATION KEY:
!   1 = Jersey Point
!   2 = Contra Costa (Rock Slough)
!   3 = Emmaton
!   4 = Antiock
!   5 = Collinsville
!   6 = Mallard (Chipps Island)

! VARIABLE KEY:
!   1 = Slope
!   2 = Intercept (Qsac=0)

! DXC KEY:
!   CALSIM uses CLOSED=0,OPEN=nonzero(number of days open)
!   ANN internal functions use daily data CLOSED=1,OPEN=0

! AVE_TYPE KEY:
!   1 = monthly average
!   2 = first day of month value
!   3 = last day of month value
!   4 = maximum daily value
!   5 = minimum daily vlaue
!   6 = maximum 14-day value
!
! ForceOption:
!   1 = first Linearization, if not intersect with the Ectarget contour then return slope =0 and intercept =999999.0
!   2 = second Linearization, if not intersect with the Ectarget contour then return slope =0 and intercept =999999.0
!   3 = third Linearization, if not intersect with the Ectarget contour then return slope =0 and intercept =999999.0
!         if there is no feasible linearization exists within the specified export range (linear1 and linear 2) then slope 0 and intercept =999998.0
!   4 = always return the third linearization at by extending the specified export rangeif the specified export range does not 
!         intersect with the Ectarget contour. this condition only occurs in non-cone condition.
!  
!   the specified export range for linearization is not used if a cone exists in the solution zone

FUNCTION AnnLineGen(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,&
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,&
     Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_fut, &
     DXC_prv0,DXC_prv1,DXC_prv2,DXC_prv3,DXC_fut,&
     DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_fut,& !shengjun add 2/24/2005     
     Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_fut,&
     Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_fut,&
     VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_fut,&
     mon0,mon1,mon2,mon3,mon4,&
     ECTARGET,linear1,linear2,location,variable,ave_type,&
     currMonth,currYear,ForceOption) RESULT(value)!shengjun 2/15/2005 and 5/11/2005: ForceOption=1: force to create a linear relationship even the designated points in export do not intercept with ECtarget contour
     
  use SFtideModule !shengjun 2/14/2005
     
  IMPLICIT NONE
  
  interface 
    function ConservativeSpline(monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5, &
                              daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5) result (smoothedOutput)
      implicit none
	    integer,INTENT(IN) ::  daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5
	    REAL,INTENT(IN)    ::  monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5
	    real, allocatable  ::  smoothedOutput(:)	  
    end function 	ConservativeSpline
            
  end interface
  
  REAL    ::  ANN_Month
  integer :: initall
  integer :: getSFtideArrayEndIndex !2/14/2005
  REAL   :: ECMAX,ECMIN,TOL,DIFF,Qmin,Qmax,Qmid,ECmid,x1,x2,y1,y2,slope,intercept,value,point
  REAL    :: ECSacMaxExpMin,ECSacMinExpMin,ECSacMaxExpMax,ECSacMinExpMax,ECtest1,ECtest2 !,Qsac1k
  Real    QExpMinEnforced, QSacMinimum, QExpMaximum, QSacMaximum ! the minimum export of Calsim model and minimum sac flow used in ANN training,  solution zone for linearization 5/12/2005 
  real    QexpMinECQsacMax,QexpMaxECQsacMin,QexpMaxECQsacMax,QexpMinECQsacMin, QiterStep,tempEC,MinECQsacMin,MinECQsacMax, &
          ConeLineSlope, ConeLineIntercept,QSacECtargetConeHead,QExpECtargetConeHead, &
          QSacECtargetConeBC,tempQsac,tempQexp,ECtempQsacMinExp,MinECtempQsac!5/12/2005  
          
  CHARACTER(LEN=50) LinearizationMethod !shengjun: finally the linearization method used
  
  logical :: debugCode = .false.
  !dimension flow variables for 148 days
  REAL,DIMENSION(148) :: Qsac,Qexp,Qsjr,DXC,QsacMin,QsacMax,QexpMin,QexpMax,Qsac_oth,Qexp_oth,currSFtide,DICU,VernEC !shengjun & Hao 9/2008 

  INTEGER,INTENT(IN) :: location,variable,mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,ForceOption !Shengjun 2/15/2005
  INTEGER            :: i,tim0,tim1,tim2,tim3,tim4,tim5, tryNo
  INTEGER            SFtideStartIndex,SFtideEndIndex
  
  REAL,INTENT(IN)    :: Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,&
       Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_fut, &
       Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_fut,&
       Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_fut,&
       DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_fut,& !shengjun add 2/24/2005
       VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_fut,& !Hao add 9/2008
       DXC_prv0,DXC_prv1,DXC_prv2,DXC_prv3,DXC_fut,ECTARGET,linear1,linear2
  
  real, allocatable :: smoothedFlow(:) !4/1/2005  
  real ECtolerance,QSacTolerance,QExpTolerance !4/14/2006: minimum values considerd to be significant
    
  QExpMinEnforced=900.0; QSacMinimum=5000.0 ! 4826 cfs is the minimum sac flow in training ANN: make sure the solution space with ANN training range
  QExpMaximum=14000.0; QSacMaximum=25000.0 ! 89434 cfs is the maximum sac flow in training ANN
  LinearizationMethod=''
  
  if(ForceOption .ne.1 .and. ForceOption .ne. 2 .and. ForceOption .ne. 3 .and. ForceOption .ne. 4) then ! shengjun: 5/10/2005
    print *, "Wrong option is selected for ForceOption in AnnLineGen()."
    stop
  end if
  
! shengjun comment because it is checked in ANNEC () 3/27/2006
! if(Qsac_prv3 < QSacMinimum) then!shengjun add 2/22/2005
 !   open(17,file="ANN_Info.txt",status="unknown",position="append") !3/27/2006
  !  write (*,*) 'Minimum Sacramento flow of last month is outside of ANN training range(ANN may not perform well):', Qsac_prv3
   ! QSacMinimum=Qsac_prv3 !shengjun 7/11/2005
!    close(17)
    !stop
 ! end if

  if(linear1 < QExpMinEnforced .or. linear2 > QExpMaximum) then!shengjun add 5/10/2005
    write (*,*) 'one of the specified two points at export axis is outside of ANNLineGen range. Low export and high export:', linear1, linear2
    stop
  end if
  
  i=initall()
  
  tim5=148          ! last day of current month
  tim4=tim5-mon4+1  ! first day of current month
  tim3=tim4-mon3    ! first day of 1 month ago
  tim2=tim3-mon2    ! first day of 2 months ago
  tim1=tim2-mon1    ! first day of 3 months ago
  tim0=1            ! first day of second half of 4 months ago 

  ! 118 values daily are needed to estimate one daily value of EC
  ! this function builds the first set of input arrays representing
  ! dxc position and river inflow.
  !
  ! The arrays have the following structure
  ! tim0         tim1         tim2         tim3           tim4         tim5
  ! --------------------------------------------------------------------
  ! |this month-4|this month-3|this month-2| this month-1 | this month |
  ! --------------------------------------------------------------------

  if(.not. allocated(smoothedFlow)) then !shengjun 4/25/2005
    allocate (smoothedFlow(mon0+mon1+mon2+mon3+mon4))
  endif

  !Qsac(tim0:(tim1-1))=Qsac_prv0 shengjun comment to use the smoothed flow 5/18/2005
  !Qsac(tim1:(tim2-1))=Qsac_prv1
  !Qsac(tim2:(tim3-1))=Qsac_prv2
  !Qsac(tim3:(tim4-1))=Qsac_prv3

  Qexp(tim0:(tim1-1))=Qexp_prv0
  Qexp(tim1:(tim2-1))=Qexp_prv1
  Qexp(tim2:(tim3-1))=Qexp_prv2
  Qexp(tim3:(tim4-1))=Qexp_prv3

!  Qsjr(tim0:(tim1-1))=Qsjr_prv0!shengjun comment to use smoothed input 4/25/2005
 ! Qsjr(tim1:(tim2-1))=Qsjr_prv1
  !Qsjr(tim2:(tim3-1))=Qsjr_prv2
  !Qsjr(tim3:(tim4-1))=Qsjr_prv3
!  Qsjr(tim4:tim5)=Qsjr_fut

  !start of add by shengjun 4/25/2005
  smoothedFlow = ConservativeSpline(Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_fut, mon0,mon1,mon2,mon3,mon4)
  Qsjr(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)
  !end of add

  Qsac_oth(tim0:(tim1-1))=Qsac_oth_prv0
  Qsac_oth(tim1:(tim2-1))=Qsac_oth_prv1
  Qsac_oth(tim2:(tim3-1))=Qsac_oth_prv2
  Qsac_oth(tim3:(tim4-1))=Qsac_oth_prv3
  Qsac_oth(tim4:tim5)=Qsac_oth_fut

  Qexp_oth(tim0:(tim1-1))=Qexp_oth_prv0
  Qexp_oth(tim1:(tim2-1))=Qexp_oth_prv1
  Qexp_oth(tim2:(tim3-1))=Qexp_oth_prv2
  Qexp_oth(tim3:(tim4-1))=Qexp_oth_prv3
  Qexp_oth(tim4:tim5)=Qexp_oth_fut
  
  !start of add by shengjun 2/24/2005
  DICU(tim0:(tim1-1))=DICU_prv0
  DICU(tim1:(tim2-1))=DICU_prv1
  DICU(tim2:(tim3-1))=DICU_prv2
  DICU(tim3:(tim4-1))=DICU_prv3
  DICU(tim4:tim5)=DICU_fut
  !end of add  

  !start of add by shengjun 2/15/2005
  SFtideEndIndex= getSFtideArrayEndIndex(mon4,currMonth,currYear)
  SFtideStartIndex= SFtideEndIndex - tim5 + 1
  currSFtide(tim0:tim5)=SFtide(SFtideStartIndex:SFtideEndIndex)  
  !end of add
 
  do i=tim0,(tim1-1)              ! last portion of 4th previous month
    if (i < (DXC_prv0-(mon0-tim1))) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  end do
  do i=tim1,(tim2-1)              ! 3rd previous month
    if (i-tim1 < DXC_prv1) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  end do
  do i=tim2,(tim3-1)              ! 2nd previous month
    if (i-tim2 < DXC_prv2) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  end do
  do i=tim3,(tim4-1)              ! previous month
    if (i-tim3 < DXC_prv3) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  end do
  do i=tim4,tim5                  ! current month
    if (i-tim4 < DXC_fut) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  end do
  
  !start of add by Hao 9/2008
  VernEC(tim0:(tim1-1))=VernEC_prv0
  VernEC(tim1:(tim2-1))=VernEC_prv1
  VernEC(tim2:(tim3-1))=VernEC_prv2
  VernEC(tim3:(tim4-1))=VernEC_prv3
  VernEC(tim4:tim5)=VernEC_fut
  !end of add  

  !---------------------------------------------------------------------------------------
  !implementation method:
  !(1) first check if a EC cone exist in the solution space: export 0-QExpMaximum and sac from QSacMinimum -QSacMaximum
  !(2) if no cone in the solution space, check no feasible or always feasible situation
  !      if the solution space is in the upper part of cone, calculate regular slope and intercept
  !      else, make exception: slope 0 and intercept 999996 (always feasible)
  !      if the desired linearization between linear1 and linear2 does not exist, then slope 0 and intercept 99998 will be given, unless forceOption==4 is set
  !(3) if cone exist, find the solution space is located at which part of the EC contour cone: left or right
  !      if the solution space is on the right, then make exception: slope 0 and intercept 999997 (inverse gradient always feasible)
  !      else, compute regularly 
  !--------------------------------------------------------------------------------------

  Qsac(tim4:tim5)=QSacMinimum    ! current month: initialize with minimum Qsac
  Qexp(tim4:tim5)=QExpMinEnforced    ! current month: initialize with minimum export

  QexpMax=Qexp
  QexpMax(tim4:tim5)=QExpMaximum

  !QsacMax=Qsac shengjun comment to use smoothed flow
  !QsacMax(tim4:tim5)=QSacMaximum shengjun comment to use smoothed flow

  !start of add by shengjun 4/25/2005
  smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,QSacMaximum, mon0,mon1,mon2,mon3,mon4)
  QsacMax(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
  !end of add

  QexpMin=Qexp
  QexpMin(tim4:tim5)=QExpMinEnforced !shengjun changed from 0 to ExportMin 2/22/2005 to account for minimum export specified in Calsim

  !QsacMin=Qsac shengjun comment to use smoothed flow 5/18/2005
  !QsacMin(tim4:tim5)=QSacMinimum !shengjun changed from 0 to MinSac 2/22/2005 to account the ANN training range
  
  !start of add by shengjun 4/25/2005
  smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,QSacMinimum,mon0,mon1,mon2,mon3,mon4)
  QsacMin(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
  !end of add          
  
  ECSacMinExpMax=ANN_Month(QsacMin+Qsac_oth,QexpMax+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type) ! shengjun 12/16/2004 & Hao 9/2008         
  ECSacMaxExpMin=ANN_Month(QsacMax+Qsac_oth,QexpMin+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type) !  shengjun 12/16/2004 & Hao 9/2008  
  ECSacMinExpMin=ANN_Month(QsacMin+Qsac_oth,QexpMin+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type) ! !shengjun 12/16/2004 & Hao 9/2008 
  ECSacMaxExpMax=ANN_Month(QsacMax+Qsac_oth,QexpMax+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type) !  !shengjun 12/16/2004 & Hao 9/2008   
        
  !print *, "step1"
  TOL=0.01 ! changed from 1.0 to 0.1 7/30/07
  ECtolerance=0.01 !1.0 !4/14/2006:  ! changed from 1.0 to 0.1 for testing 7/30/07
  QSacTolerance =1.0  ! changed from 1000.0 to 1 for testing 7/30/07
  QExpTolerance=1.0  ! changed from 200.0 to 1 for testing 7/30/07
          
  !(1) find the minimum EC when Qsac=QSacMaximum: at error of <40 at export
  MinECQsacMax=ECSacMaxExpMin
  QexpMinECQsacMax=QExpMinEnforced !Exp when minimum EC occurs with Qsac Max 3/25/2006: only a initialization and it will be overwritten
  QiterStep=1000.0  
  tempEC= LocateMinECSequentially(QSacMaximum,QExpMinEnforced,QExpMaximum,QiterStep,QexpMinECQsacMax)  
  if(tempEC >= MinECQsacMax) then
    if(debugCode) print *,"No smaller EC found."    
    goto 10
  else
    MinECQsacMax=tempEC
    if(debugCode) print *, "MinEC found at QsacMax:",MinECQsacMax,QexpMinECQsacMax
    
    !find the minimum EC more accurately  
    tempEC = LocateMinECSequentially(QSacMaximum,max(QexpMinECQsacMax-QiterStep,QExpMinEnforced),min(QexpMinECQsacMax+QiterStep,QExpMaximum),200.0,QexpMinECQsacMax) 
    if(tempEC >= MinECQsacMax) then
      if(debugCode) print *,"No smaller EC found."
    else
      MinECQsacMax=tempEC
      if(debugCode) print *, "MinEC found at QsacMax:",MinECQsacMax,QexpMinECQsacMax    
    
      QiterStep=200.  
      tempEC = LocateMinECSequentially(QSacMaximum,max(QexpMinECQsacMax-QiterStep,QExpMinEnforced),min(QexpMinECQsacMax+QiterStep,QExpMaximum),20.0,QexpMinECQsacMax)    
      if(tempEC >= MinECQsacMax) then
        if(debugCode) print *,"No smaller EC found."
      else  
        MinECQsacMax=tempEC
        if(debugCode) print *, "MinEC found at QsacMax:",MinECQsacMax,QexpMinECQsacMax
      end if
    end if
  
  end if  
  !end of add
     
  !x=Sac
  !y=export
10 x1=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005
   y1=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
   x2=QSacMaximum
   y2=QExpMaximum  
      
  if(MinECQsacMax < ECSacMaxExpMin - TOL .and. MinECQsacMax < ECSacMaxExpMax-TOL) then !9/28/2005
  !**vallley cone of EC surface exist in the study area, use the cone contour line directly to 
    if(debugCode)  print*," *** Valley Cone exist."
  
    !start of add by shengjun 9/28/2005
    IF (ECSacMaxExpMax < ECSacMinExpMax-ECtolerance) THEN !9/29/2005: more sac flow, less EC
      !cone head and the feasible solution space is in the left of the study area
      if(debugCode)  print*," *** Valley cone head is in the left of maximum sac flow line."
      IF (MinECQsacMax > ECTARGET) THEN !shengjun add for revisition 9/28/2005
        if(debugCode)  LinearizationMethod='---always infeasible' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=0.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" 
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
        
        deallocate (smoothedFlow) !4/25/2005
        return      
      
      else if(ECSacMinExpMax <= ECTARGET) then
      
        if(debugCode) LinearizationMethod='---always feasible' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=999999.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" !value=0.0
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
        
        deallocate (smoothedFlow) !4/25/2005    
        return    
                 
      END IF  
    
    else if(ECSacMaxExpMax < ECSacMaxExpMin) then!inverse gradient: more export less EC: 4/16/2006
      if(debugCode)  print*," *** inverse gradient."
      
      if(debugCode) call ErrMessage("**!!** Inverse gradient in a valley cone.",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)      
      
      IF (ECSacMaxExpMin <= ECTARGET) THEN !shengjun add for revisition 9/28/2005            
        if(debugCode) LinearizationMethod='---always feasible, inverse gradient in the cone.' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=999997.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" !value=0.0
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
        
        deallocate (smoothedFlow) !4/25/2005    
        return    
      else if(ECSacMaxExpMax > ECTARGET) THEN !shengjun add for revisition 9/28/2005
        if(debugCode)  LinearizationMethod='---always infeasible' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=0.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" 
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
        
        deallocate (smoothedFlow) !4/25/2005
        return      
    
      end if
    
    else
      if (debugCode) print *," *** EC is the same between Sac Min and Max when export at maximum."
    
    end if  
    !end of add
    
    !start of add by Shengjun 5/13/2005
    !(2) find the minimum EC when Qsac=QSacMinimum
    !print *, "step2"    
    MinECQsacMin=ECSacMinExpMin
    QexpMinECQsacMin=QExpMinEnforced !Exp when minimum EC occurs with Qsac Min: only a initialization and will be overwritten below
    QiterStep=1000.0
    tempEC= LocateMinECSequentially(QSacMinimum,QExpMinEnforced,QExpMaximum,QiterStep,QexpMinECQsacMin)
    
    !check to see if a mountain on the min Sac flow
    if(tempEC > ECSacMinExpMin .and. tempEC > ECSacMinExpMax .and. debugCode) call ErrMessage("**!!** Mountain in a valley cone at Min Sac flow.",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption) 
    
    if(tempEC >= MinECQsacMin) then
      if(debugCode) print *,"No smaller EC found."
      goto 20 !cone does not hit min Sac flow line
    else
      MinECQsacMin=tempEC  
      if(debugCode) print *, "MinEC found at QsacMin:",MinECQsacMin,QexpMinECQsacMin  
      
      tempEC= LocateMinECSequentially(QSacMinimum,max(QexpMinECQsacMin-QiterStep,QExpMinEnforced),min(QexpMinECQsacMin+QiterStep,QExpMaximum),200.0,QexpMinECQsacMin)  
      if(tempEC >= MinECQsacMin) then
        if(debugCode) print *,"No smaller EC found."
        goto 20 !cone does not hit min Sac flow line
      else
        MinECQsacMin=tempEC
        if(debugCode) print *, "MinEC found at QsacMin:",MinECQsacMin,QexpMinECQsacMin  
        
        QiterStep=200.0  
        tempEC= LocateMinECSequentially(QSacMinimum,max(QexpMinECQsacMin-QiterStep,QExpMinEnforced),min(QexpMinECQsacMin+QiterStep,QExpMaximum),20.0,QexpMinECQsacMin)  
        if(tempEC >= MinECQsacMin) then
          if(debugCode) print *,"No smaller EC found."
          goto 20 !cone does not hit min Sac flow line
        else
          MinECQsacMin=tempEC        
          if(debugCode) print *, "MinEC found at QsacMin:",MinECQsacMin,QexpMinECQsacMin  
        end if
      end if
            
    end if  
      
    if(MinECQsacMin > ECtarget-ECtolerance .and. MinECQsacMax > ECtarget-ECtolerance) then !4/16/2006
      if(debugCode)  LinearizationMethod='---always infeasible' !shengjun
      IF (variable==1) value=0.0
      IF (variable==2) value=0.0
      IF (variable==3) then !shengjun 5/11/2005
        print *, "Wrong option" 
        deallocate (smoothedFlow) !4/25/2005
        stop
      end if
      
      deallocate (smoothedFlow) !4/25/2005
      return      

    end if
  
      
    !determine cone parameters: slope of centerline and intercept, ECtarget cone head location        
    if(MinECQsacMin > ECSacMinExpMin .and. MinECQsacMin > ECSacMinExpMax) then !4/12/2006
      if(debugCode) call ErrMessage("**!!** Mountain in a valley cone at Min Sac flow. this should not happen here.",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption) 
      goto 20
      
    else if(MinECQsacMin < ECSacMinExpMin .and. MinECQsacMin < ECSacMinExpMax) then !cone hit Sac at minimum flow line
     !--assume valley cone exist 4/7/2006
      !analyze the cone parameters    
      ConeLineSlope=(QexpMinECQsacMax-QexpMinECQsacMin)/(QSacMaximum-QSacMinimum) !4/7/2006:this cone slope and intercept is not the centerline of the cone. 
                                                                                  !some off dependent on the direction of cone (horizontal is ideal) 
                                                                                  !However, this is only a fix to previous linear assumption case. could be improved later
      ConeLineIntercept=QexpMinECQsacMin-ConeLineSlope*QSacMinimum !9/29/2005
       
      !print *, "step3"
      if(debugCode .and. ConeLineSlope < 0.0) print *, "negative cone slope." !9/29/2005
        
      if(debugCode) print *, "Cone slope, intercept:",ConeLineSlope,ConeLineIntercept  !9/29/2005
          
      !find the head point of ECtarget cone, or the point where the ECtarget contour crosses Minimum Sac flow line                 
      if(MinECQsacMin < ECtarget) then!EC target cone head at the left of Min Sac flow line
        !find the crossing point of EC target contour with Higher export, the crossing point of EC target contour with Less export is ignored becasue of negative slope        	       	        
        Qsac(1:tim5)= QsacMin !assign the smoothed sac flow with curr month minimum flow
	      
	      Qmin=QexpMinECQsacMin
	      Qmax=QExpMaximum 
	      DIFF=TOL+1.
	      do while (DIFF > TOL)
	        DIFF=ABS(Qmax-Qmin)
	        Qmid=0.5*(Qmin+Qmax)
	        Qexp(tim4:tim5)=Qmid
	        
	        ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008 
	        
	        if(abs(ECtarget-ECmid) < ECtolerance) exit !4/10/2006
	        
	        if(Qmid > QexpMinECQsacMin) then !4/7/2006	   
	          if(ECmid > ECtarget)then 
	            Qmax=Qmid
	          else
	            Qmin=Qmid
	          end if
	        else
	          if(ECmid < ECtarget)then !4/7/2006
	            Qmax=Qmid
	          else
	            Qmin=Qmid
	          end if
          end if	        
	      end do
	      
   	    if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
          if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in finding contour parameters.", &
            location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	  end if
	      
	      QSacECtargetConeHead=QSacMinimum
	      QExpECtargetConeHead=Qmid
      
      elseif(MinECQsacMin > ECtarget) then !head of ECtarget cone is to the right of study area
      
        !find the crossing point of EC target contour along the EC contour cone center line
	      Qmin=QSacMinimum 
	      Qmax=QSacMaximum
	      DIFF=TOL+1.
	      tryNo=1 !record number of tries in searching crossing point x1 or x2 4/11/2006
	      
	      do while (DIFF > TOL)
	        DIFF=ABS(Qmax-Qmin)
	        Qmid=0.5*(Qmin+Qmax)
	        !Qsac(tim4:tim5)=Qmid shengjun
          !start of add by shengjun 5/18/2005
          smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
          Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
          !end of add
	        
	        Qexp(tim4:tim5)=Qmid*ConeLineSlope+ConeLineIntercept
	        ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008 
	        
	        if(tryNo ==1)then!double check
	          if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then  !9/2008
              if(debugCode) call ErrMessage("**!!** this should not happen: Assumption violated because of inverse gradient. ", &
                  location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
              stop
            end if     
          end if
          
	        if(abs(ECtarget-ECmid) < ECtolerance) exit !4/10/2006
	        
	        if(ECmid > ECtarget) then !assume this is a valley cone
	          Qmin=Qmid
	        else
	          Qmax=Qmid
	        end if
	      end do	      
	      
   	    if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
          if(debugCode) call ErrMessage("!* more than 5% off from EC target contour with the head of ECtarget cone is to the right minimum Sacflow line (finding cone parameters)", &
                location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	  end if
	      
	      !check for Qmid to see if the cone head of EC target cone is too close to the boundary 
	      !of the study area: assuming cone not opening to the left 4/16/2006
	      if((QsacMaximum-Qmid) < QSacTolerance) then	      
  	      if(location ==1 .and. debugCode) print *, "ECtarget is not in the cone for JP." 
          if(location ==3 .and. debugCode) print *, "ECtarget is not in the cone at EMM."
          if(location ==5 .and. debugCode) print *, "ECtarget is not in the cone at Collinsville."
	            
          if(debugCode) call ErrMessage("-- No cone procedure used because of too small cone. ", &
                  location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
                  
	        goto 30 !use no cone procedure                  
	        
	      end if
	      
	      QSacECtargetConeHead=Qmid
	      QExpECtargetConeHead=Qmid*ConeLineSlope+ConeLineIntercept      
	      
      else !just touch
	      QSacECtargetConeHead=QSacMinimum
	      QExpECtargetConeHead=QexpMinECQsacMin    
      end if                                                                   
     
    else !uniform slope at min sac flow line
         !if the cone head does not hit the minimum sac flow line, it must be to the right or below 
         !the minimum export line
         
      !print *, "step4"         
20    if(ECSacMinExpMax >= ECtarget .and. ECSacMinExpMin <= ECtarget) then !4/17/2006
        !the ECtarget contour hit the minimum sac flow line: use non-cone procedure         
        if(debugCode) LinearizationMethod='---EC target contour is to the left of the cone and hit minimum Sac flow line.'
        goto 30
      end if                             

      if(ECSacMinExpMin > ECtarget .and. ECSacMaxExpMin > ECtarget .and. &
         ECSacMinExpMax > ECtarget .and. ECSacMaxExpMax > ECtarget .and. &
         MinECQSacMin > ECtarget .and. MinECQSacMax > ECtarget) then
        !the ECtarget contour is inside the study area (within min and max of sac and export flows)
!          if(debugCode) call ErrMessage("-- the whole cone is inside the study area. ", &
 !                 location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
                
        if(debugCode)  LinearizationMethod='---always infeasible:inside-cone, min EC at Max Sac and Min Sac > EC target.' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=0.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" 
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
                      
        deallocate (smoothedFlow) !4/25/2005
        return 
        
      end if                             
                        
      !find at least a point on one cone contour by search the minimum EC along the sacramento flow 
      !(starting from 1/4 th of (QsacMaximum-QsacMinimum)      
      tempQsac= QsacMinimum+(QsacMaximum-QsacMinimum)*0.25 !search the first 1/4 part 
      tempEC=ECtempQsacMinExp !start the first loop
      
      do while (tempEC >= ECtempQsacMinExp)
      
        smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,tempQsac,mon0,mon1,mon2,mon3,mon4)
        Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
        
        Qexp(tim4:tim5)=QExpMaximum !QExpMinEnforced 4/14/2006
	      ECtempQsacMinExp=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type) !9/2008
	      
	      MinECtempQsac =  ECtempQsacMinExp !minimum EC at line of tempQsac: initialization 4/14/2006
        tempQexp = QExpMinEnforced!Exp when minimum EC occurs with Qsac Min, initialization and will be overwritten by the following function
      
        QiterStep=1000.0
        tempEC= LocateMinECSequentially(tempQsac,QExpMinEnforced,QExpMaximum,QiterStep,tempQexp)
        
        if(tempEC >= MinECtempQsac) then
          if(debugCode) print *,"No smaller EC found."
          tempQsac= (tempQsac+QsacMaximum)*0.5
          
          if(tempQsac > (QsacMaximum-QSacTolerance)) then !4/14/2006
            goto 30
          else
            cycle
          end if
        else
          MinECtempQsac=tempEC
          if(debugCode) print *, "MinEC found at tempQsac:",MinECtempQsac,tempQexp
          
          tempEC= LocateMinECSequentially(tempQsac,max(tempQexp-QiterStep,QExpMinEnforced),min(tempQexp+QiterStep,QExpMaximum),200.0,tempQexp)  
          if(tempEC >= MinECtempQsac) then
            if(debugCode) print *,"No smaller EC found."
            exit
          else
            MinECtempQsac=tempEC
            if(debugCode) print *, "MinEC found at tempQsac:",MinECtempQsac,tempQexp
            
            QiterStep=200.0  
            tempEC= LocateMinECSequentially(tempQsac,max(tempQexp-QiterStep,QExpMinEnforced),min(tempQexp+QiterStep,QExpMaximum),20.0,tempQexp)  
            if(tempEC >= MinECtempQsac) then
              if(debugCode) print *,"No smaller EC found."
              exit
            else
              MinECtempQsac=tempEC        
              if(debugCode) print *, "MinEC found at tempQsac:",MinECtempQsac,tempQexp
            end if
          end if
        end if  
                
      end do

      if(abs(QExpMinEnforced-tempQexp)< 400.0 .or. abs(QExpMaximum-tempQexp)< 400.0 .or. &
         abs(QSacMaximum-tempQsac) < 2000.) then !4/12/2006
      !!** if the cone head is below the minimum export line: exception or cone is too small in the study area
!        if(debugCode) call ErrMessage("**!! too small EC target cone or cone head is below the minimum export line. use non-cone procedure.", &
 !            location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
        goto 30        
      end if

      !4/7/2006:tempQexp is the export flow corresponding to the minimum EC along tempQsac line
      ConeLineSlope=(QexpMinECQsacMax-tempQexp)/(QSacMaximum-tempQsac)
      ConeLineIntercept=tempQexp-ConeLineSlope*tempQsac
      
      if(ConeLineSlope < 0.0 .and. debugCode) print *, "negative cone slope occurs when cone head is to the right of min sac flow and below the min export flow line."
      
      if(debugCode) print *, "Cone slope, intercept:",ConeLineSlope,ConeLineIntercept

      !**find the crossing point of EC target contour with cone center line
	    Qmin=QSacMinimum 
	    Qmax=QSacMaximum
	    
	    DIFF=TOL+1.
	    tryNo=1 !record number of tries in searching crossing point x1 or x2 4/11/2006
	    
	    do while (DIFF > TOL)
	      DIFF=ABS(Qmax-Qmin)
	      Qmid=0.5*(Qmin+Qmax)
	      !Qsac(tim4:tim5)=Qmid
        
        !shengjun 3/27/2006: if searching goes out of solution space then stop
        if( (0.9*QExpMaximum) < (Qmid*ConeLineSlope+ConeLineIntercept) .or. &
            (1.1*QExpMinEnforced) > (Qmid*ConeLineSlope+ConeLineIntercept)) then

            if (debugCode) print *, "EC target contour cone head is not in the study area."
            
!            if(debugCode) call ErrMessage("**!!** EC target contour does not cross with cone center line (uniform slope at min sac flow line).",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)      
            
            goto 30 !4/12/2006
            
        end if
        
        smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
        Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  	      
	      Qexp(tim4:tim5)=Qmid*ConeLineSlope+ConeLineIntercept	      	      
	      
	      ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008 
	      
	      if(tryNo ==1)then!check for possible inverse gradient
	        if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then  !9/2008
            if(debugCode) call ErrMessage("**!!** Inverse gradient in a valley cone (uniform slope at min sac flow line).",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)      
          end if     
        end if
	      
	      !assuming valley cone: the following will not work if a mountain contour exists
	      if(ECmid > ECtarget) then 
	        Qmin=Qmid !more sac flow
	      else
	        Qmax=Qmid
	      end if

	    end do	              

	    !check for Qmid to see if it hit ECtarget contour: only considering cone open to right, up or down, no left
	    if((abs(QsacMaximum-Qmid) < 2000.0) .or. &
	       (abs(Qmid*ConeLineSlope+ConeLineIntercept - QExpMinEnforced) < QExpTolerance) .or. &
	       (abs(Qmid*ConeLineSlope+ConeLineIntercept - QExpMaximum) < QExpTolerance)) then !too close to the boundary of study area

	      if(location ==1 .and. debugCode) print *, "ECtarget is not in the cone at JP." !show special case for EMM, Collinsville
        if(location ==3 .and. debugCode) print *, "ECtarget is not in the cone at EMM."
        if(location ==5 .and. debugCode) print *, "ECtarget is not in the cone at Collinsville."

!        if(debugCode) call ErrMessage("**!! too small EC target cone or cone head is below the minimum export line. use non-cone procedure.", &
 !            location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
	      
	      goto 30
	    end if

   	  if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
   	  
        if(debugCode) call ErrMessage("!* more than 5% off from EC target contour with the head of ECtarget cone is to the right of minimum Sacflow line (uniform slope along min sac flow line).", &
                location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
                
        if(debugCode) call ErrMessage("-------- ECmid is ", location, currYear,currMonth,ECmid,linear1,linear2,ForceOption)
                
    	end if

	    QSacECtargetConeHead=Qmid
	    QExpECtargetConeHead=Qmid*ConeLineSlope+ConeLineIntercept      	    	    	              
    end if
    
    if(location ==1 .and. debugCode) print *, "cone precedure used for JP for month and water year:",currMonth,currYear
    if(location ==3 .and. debugCode) print *, "cone precedure used for EM for month and water year:",currMonth,currYear
    if(location ==5 .and. debugCode) print *, "cone precedure used for CO for month and water year:",currMonth,currYear
                            
    !print *, "step5"      
    !(3) *** start to do piece lineariation using cone procedure: divided the sac flow ECtarget contour range into 9 parts. 
    !   first piece is the linear part of the first part. the second linear piece takes 3 parts of 9 parts.
    !   the third piece use the last 5 parts.
    !--- only the top half of the cone is considered because CalSim can not deal with bottom part    
    !--  the following routine assume valley cone 
    if(ECSacMaxExpMax > ECSacMinExpMax) then!inverse gradient 4/10/2006: double check
        if(debugCode) call ErrMessage("**!!** Inverse gradient should not happen here.", &
             location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    else
    
      if(ECSacMaxExpMax < ECtarget) then !EC target contour hits maximum export line 
        !print *, "step5.1"                
        
        if(debugCode == .true.) LinearizationMethod='---EC target contour hit maximum export'  !shengjun
        
        !find x2 range:
        Qexp(tim4:tim5)=QExpMaximum            
	      Qmin=QSacMinimum 
	      Qmax=QSacMaximum
	      DIFF=TOL+1.
	      tryNo=1 !record number of tries in searching crossing point x1 or x2
    	  
	      do while (DIFF > TOL)
	        DIFF=ABS(Qmax-Qmin)
	        Qmid=0.5*(Qmin+Qmax)
          smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
          Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
          
	        ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008 
	        
	        if(tryNo ==1)then!check for possible inverse gradient
	          if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then
              if(debugCode) call ErrMessage("**!!** Inverse gradient should not happen here.", &
                     location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
            end if     
	          
	        end if
        
	        if(ECmid > ECtarget) then
	          Qmin=Qmid
	        else
	          Qmax=Qmid
	        end if
	      end do	              

   	    if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
          if(debugCode) call ErrMessage("!* more than 5% off from EC target contour with EC target contour hits maximum export line (linearization step).", &
                location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	  end if

        QSacECtargetConeBC=Qmid
            
        if(ForceOption ==1) then !first linearization, the linearization with the first 1/4 of feasible export range                              
          x1=QSacECtargetConeHead
          x2=x1+(QSacECtargetConeBC-QSacECtargetConeHead)*0.1111        
          
        elseif(ForceOption ==2) then !second linearization, the linearization with the 1/4 and 1/2 of feasible export range                                        
          x1=QSacECtargetConeHead+(QSacECtargetConeBC-QSacECtargetConeHead)*0.1111
          x2=x1+(QSacECtargetConeBC-QSacECtargetConeHead)*0.4444
                  
        else !third linearization, the linearization with the last 1/2 of feasible export range                              
          x1=QSacECtargetConeHead+(QSacECtargetConeBC-QSacECtargetConeHead)*0.4444
          x2=QSacECtargetConeBC
        end if
          
        !determine export coordinate (y)                         
        if(ForceOption ==1) then 
        !only need to find out y2
          y1= QExpECtargetConeHead        
          
          smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,x2,mon0,mon1,mon2,mon3,mon4)
          Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
    	    
!	        if(ConeLineSlope >= 0.0) then!4/13/2006
 ! 	        Qmin=y1 	                
	!          Qmax=QExpMaximum
	 !       else
  	        Qmin= y1+	ConeLineSlope*(x2-x1)
	          Qmax=QExpMaximum
!          end if	        
    	    	        
	        DIFF=TOL+1.	  
    	    
	        if(Qmin < Qmax) then !shengjun 3/27/2006  
	          do while (DIFF > TOL)
	            DIFF=ABS(Qmax-Qmin)
	            Qmid=0.5*(Qmin+Qmax)
	            Qexp(tim4:tim5)=Qmid
	            ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008 
	            
	            if(abs(ECtarget-ECmid) < TOL) exit !4/10/2006
	            
	            if(ECmid > ECtarget)then !assume valley cone and only top of the cone
	              Qmax=Qmid
	            else
	              Qmin=Qmid
	            end if
	          end do
    	    
    	      if(abs(ECmid -ECtarget)> 0.05*ECtarget) then
              if(debugCode) call ErrMessage("!* more than 5% off from EC target contour with EC target contour hits maximum export line.", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	      end if
    	      
	          y2= Qmid 
          else       !shengjun 3/27/2006  
            if(debugCode) print *, "minimum export used."
            y2= Qmin !shengjun 3/27/2006 
          end if
          
          !print *, "step5.1 completed" 
          
        else if(ForceOption ==2) then          
          
          !print *, "step5.2" 
          
          do i=1, 2        
            if(i==1) then
            
              smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,x1,mon0,mon1,mon2,mon3,mon4)
              Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)      	       
	            
  	          Qmin=QExpECtargetConeHead +	ConeLineSlope*(x1-QSacECtargetConeHead) !4/13/2006 	          
	            
	          else
	          	          	          
              smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,x2,mon0,mon1,mon2,mon3,mon4)
              Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
    	        
  	          Qmin=QExpECtargetConeHead +	ConeLineSlope*(x2-QSacECtargetConeHead) !4/13/2006 	          
	          end if
    	      
	          !Qmin=QexpMinECQsacMin shengjun comment to make narrower range for searching
	          if(Qmin < QExpMinEnforced)  then
	            Qmin = QExpMinEnforced !3/27/2006	        
	            if(debugCode) print *, "minimum export used."
	          end if
    	      
	          Qmax=QExpMaximum	        
	          DIFF=TOL+1.	        
	          do while (DIFF > TOL)
	            DIFF=ABS(Qmax-Qmin)
	            Qmid=0.5*(Qmin+Qmax)
	            Qexp(tim4:tim5)=Qmid
	            ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008 
	            
	            if(abs(ECtarget-ECmid) < TOL) exit !4/10/2006
	            
	            if(ECmid > ECtarget)then!assume valley cone and only top of the cone
	              Qmax=Qmid
	            else
	              Qmin=Qmid
	            end if
	          end do
            
    	      if(abs(ECmid -ECtarget)> 0.05*ECtarget) then
              if(debugCode) call ErrMessage("!* more than 5% off from EC target contour with EC target contour hits maximum export line.", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	      end if
            
            if(i==1) then
	            y1= Qmid
	          else
	            y2= Qmid
	          end if
    	      	      
	        end do
          
          !print *, "step5.2 completed"   

        else !for third piece (ForceOption ==3 and 4): 
          !only need to find out y1

          !print *, "step6"
          
          smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,x1,mon0,mon1,mon2,mon3,mon4)
          Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
    	        	    
	        Qmin = QExpECtargetConeHead + (x1-QSacECtargetConeHead)*ConeLineSlope !4/12/2006
    	        	    
	        Qmax=QExpMaximum
	        
	        DIFF=TOL+1.	    
	            
	        do while (DIFF > TOL)
	          DIFF=ABS(Qmax-Qmin)
	          Qmid=0.5*(Qmin+Qmax)
	          Qexp(tim4:tim5)=Qmid
	          ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008 
	          
	          if(abs(ECtarget-ECmid) < TOL) exit !4/10/2006
	          
	          if(ECmid > ECtarget)then
	            Qmax=Qmid
	          else
	            Qmin=Qmid
	          end if
	        end do
          
    	    if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
            if(debugCode) call ErrMessage("!* more than 5% off from EC target contour with the !EC target contour hits maximum export line (third piece).", &
                  location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	    end if
          
          y1=Qmid
          y2=QExpMaximum                    
        end if
        
      else!the upper ECtarget cone contour line hits maximum Sac flow line
        if(debugCode == .true.) LinearizationMethod='---Cone contour hit maximum Sac flow'  
        !print *, "step7"
        
        QSacECtargetConeBC=QSacMaximum
        
        !QExpECtargetConeBC=QExpMaximum        
            
        if(ForceOption ==1) then !first linearization, the linearization with the first 1/4 of feasible export range
          x1=QSacECtargetConeHead
          x2=x1+(QSacECtargetConeBC-QSacECtargetConeHead)*0.1111       
          
        elseif(ForceOption ==2) then !second linearization, the linearization with the 1/4 and 1/2 of feasible export range                                        
          x1=QSacECtargetConeHead+(QSacECtargetConeBC-QSacECtargetConeHead)*0.1111
          x2=x1+(QSacECtargetConeBC-QSacECtargetConeHead)*0.4444
                  
        else !third linearization, the linearization with the last 1/2 of feasible export range                              
          x1=QSacECtargetConeHead+(QSacECtargetConeBC-QSacECtargetConeHead)*0.4444
          x2=QSacMaximum
          
          if(abs(x2- QSacECtargetConeBC) > TOL) then
            if(debugCode) call ErrMessage("!* Error occurs in calculating QSacECtargetConeBC when EC contour line hit maximum sac flow line.", &
                    location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
          end if                  
        end if
          
        !determine export coordinate (y)                         
        if(ForceOption ==1) then !shengjun 4/10/2006: the first part near cone head
        !only need to find y2
          y1= QExpECtargetConeHead        
          
	        !Qsac(tim4:tim5)=x2 shengjun comment
          smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,x2,mon0,mon1,mon2,mon3,mon4)
          Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
    	    
	        !Qmin=QexpMinECQsacMin shengjun comment 4/10/2006\
	        	        
!	        if(ConeLineSlope >= 0.0) then!4/13/2006
 ! 	        Qmin=y1 	                
	!          Qmax=QExpMaximum
	 !       else
  	        Qmin= y1+	ConeLineSlope*(x2-x1) !4/13/2006          
	          Qmax=QExpMaximum
    !      end if	        
	        
	        DIFF=TOL+1.	   
    	          
	        do while (DIFF > TOL)
	          DIFF=ABS(Qmax-Qmin)
	          Qmid=0.5*(Qmin+Qmax)
	          Qexp(tim4:tim5)=Qmid
	          ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008 
	          
	          if(abs(ECtarget-ECmid) < TOL) exit !4/10/2006
	          
	          if(ECmid > ECtarget)then
	            Qmax=Qmid
	          else
	            Qmin=Qmid
	          end if
	        end do
          
    	    if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
            if(debugCode) call ErrMessage("!* more than 5% off from EC target contour with the upper ECtarget cone contour line hits maximum Sac flow line.", &
                    location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	    end if
          
          y2= Qmid
        
        else !if(ForceOption ==2,3 and 4)
          !find y1 and y2
          !print *, "step8"  
          
          do i=1, 2        
            if(i==1) then
	            !Qsac(tim4:tim5)=x1 
              smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,x1,mon0,mon1,mon2,mon3,mon4)
              Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
  	          
  	          Qmin=QExpECtargetConeHead +	ConeLineSlope*(x1-QSacECtargetConeHead)!4/13/2006
    	        
	          else
	            !Qsac(tim4:tim5)=x2	            
              smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,x2,mon0,mon1,mon2,mon3,mon4)
              Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  

  	          Qmin=QExpECtargetConeHead +	ConeLineSlope*(x2-QSacECtargetConeHead)!4/13/2006    	        
  	          
	          end if
    	          
	          Qmax=QExpMaximum
    	          	      
	          DIFF=TOL+1.
	          	        
	          do while (DIFF > TOL)
	            DIFF=ABS(Qmax-Qmin)
	            Qmid=0.5*(Qmin+Qmax)
	            Qexp(tim4:tim5)=Qmid
	            ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	            
	            if(abs(ECtarget-ECmid) < TOL) exit !4/10/2006
	            
	            if(ECmid > ECtarget)then
	              Qmax=Qmid
	            else
	              Qmin=Qmid
	            end if
	          end do
            
    	      if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
              if(debugCode) call ErrMessage("!* more than 5% off from EC target contour with the upper ECtarget cone contour line hits maximum Sac flow line.", &
                    location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	      end if
            
            if(i==1) then
	            y1= Qmid
	          else
	            y2= Qmid
	          end if
          end do
         	                  
        end if
            	  
      end if                                
    end if !end of finding coordinates for 3 pieces when specified linear1 is at the cone head
    
  else !if no valley cone:
  !end of add
        
    !check roughly if mountain contour exists : 4/17/2006 
    QexpMaxECQsacMax= QExpMaximum
    QiterStep=1000.0
    tempEC=LocateMaxECSequentially(QSacMaximum,QExpMinEnforced,QExpMaximum,QiterStep,QexpMaxECQsacMax)  
    
    if(tempEC >= ECSacMaxExpMax .and. tempEC >= ECSacMaxExpMin) then!Mountain along Maximum Sac flow line
      if(debugCode) print *, "There is a mountain in the EC contour along maximum sac flow with export:",QexpMaxECQsacMax
        
      if(tempEC < ECTARGET+ECtolerance) then!feasible along maximum sac flow: check to see if also feasible along min sac flow
      
        !check ROUGHLY maximum EC at minimum sac flow        
        QexpMaxECQsacMin=QExpMaximum
        tempEC=LocateMaxECSequentially(QSacMinimum,QExpMinEnforced,QExpMaximum,QiterStep,QexpMaxECQsacMin)

        !check to see if a mountain on the min Sac flow
        if(tempEC <= ECSacMinExpMin+ECtolerance .and. tempEC <= ECSacMinExpMax+ECtolerance) then!mountain along minimum sac flow
          if(debugCode) call ErrMessage("**!!** Mountain along Max Sac flow but valley along Min Sac flow.", &
                  location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)         
          if(debugCode) print *, "Mountain along Max Sac flow but valley along Min Sac flow with export at:",QexpMaxECQsacMin         
        end if
          
        if(tempEC < ECTARGET+ECtolerance) then
          if(debugCode) LinearizationMethod='---always feasible.' !shengjun
          IF (variable==1) value=0.0
          IF (variable==2) value=999993.0
          IF (variable==3) then
            print *, "Wrong option"
            deallocate (smoothedFlow)
            stop
          end if
          
          deallocate (smoothedFlow)
          return 
        
        else 

          if(debugCode) LinearizationMethod='---usually feasible.' !shengjun: assume solution space is usualy to 
                                                                   !higher sac flow therefore usually feasible
          IF (variable==1) value=0.0
          IF (variable==2) value=999993.5
          IF (variable==3) then
            print *, "Wrong option"
            deallocate (smoothedFlow)
            stop
          end if
          
          deallocate (smoothedFlow)
          return 
                                
        end if
      
      else IF (ECSacMinExpMax > ECTARGET-ECtolerance .and. ECSacMinExpMin > ECTARGET-ECtolerance .and. & 
            ECSacMaxExpMax > ECTARGET-ECtolerance .and. ECSacMaxExpMin > ECTARGET-ECtolerance) THEN
            
        if(debugCode)  LinearizationMethod='---always infeasible:Mountain but 4 BC points > EC target.' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=0.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" 
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
                      
        deallocate (smoothedFlow) !4/25/2005
        return 
        
      else!infeasible along Max sac line and mountain along max sac flow line
      
        !roughly check min EC along min sac flow
        MinECQsacMin=ECSacMinExpMin
        QexpMinECQsacMin=QExpMinEnforced 
        QiterStep=1000.0  
        tempEC= LocateMinECSequentially(QSacMinimum,QExpMinEnforced,QExpMaximum,QiterStep,QexpMinECQsacMin)
  
        if(tempEC > ECTARGET-ECtolerance) then!for sure infeasible along maximum sac flow: 
          if(debugCode)  LinearizationMethod='---always infeasible'
          IF (variable==1) value=0.0
          IF (variable==2) value=0.0
          IF (variable==3) then 
            print *, "Wrong option" 
            deallocate (smoothedFlow) 
            stop
          end if
          
          deallocate (smoothedFlow)
          return             
          
        end if      
                  
        !***for all the other complex conditions: no single cone or one slope along min sac flow line
        if(debugCode) call ErrMessage("**!!** usually infeasible with Mountain along maximum Sac flow line.", &
              location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)         
                
        if(debugCode)  LinearizationMethod='---usually infeasible:Mountain along Max Sac flow line.'
        IF (variable==1) value=0.0
        IF (variable==2) value=0.0
        IF (variable==3) then 
          print *, "Wrong option" 
          deallocate (smoothedFlow) 
          stop
        end if          
    
        deallocate (smoothedFlow)
        return                                                   
      end if  
       
    end if      
    !end of add  
  
    !********* get linearization when no cone of EC surface exist  
  ! 30 TOL=1.0     shengjun commment 7/30/2007
30 if(debugCode == .true.) print *, "---No contour cone or ECtarget is not in the cone."
    
    !start of add by shengjun: 9/28/2005
    !if (variable==1 .or. variable==2) then
    IF (ECSacMinExpMax <= ECTARGET+ECtolerance .and. ECSacMinExpMin <= ECTARGET+ECtolerance .and. &
        ECSacMaxExpMax <= ECTARGET+ECtolerance .and. ECSacMaxExpMin <= ECTARGET+ECtolerance) THEN
      
      if(debugCode) LinearizationMethod='---always feasible: :no cone but 4 BC points < EC target.' !shengjun
      IF (variable==1) value=0.0
      IF (variable==2) value=999999.0
      IF (variable==3) then !shengjun 5/11/2005
        print *, "Wrong option" !value=0.0
        deallocate (smoothedFlow) !4/25/2005
        stop
      end if
      deallocate (smoothedFlow) !4/25/2005    
      return

    else IF (ECSacMinExpMax > ECTARGET+ECtolerance .and. ECSacMinExpMin > ECTARGET+ECtolerance .and. & !shengjun 4/17/2006
             ECSacMaxExpMax > ECTARGET+ECtolerance .and. ECSacMaxExpMin > ECTARGET+ECtolerance) THEN
      
      if(debugCode)  LinearizationMethod='---always infeasible:no cone but 4 BC points > EC target.' !shengjun
      IF (variable==1) value=0.0
      IF (variable==2) value=0.0
      IF (variable==3) then !shengjun 5/11/2005
        print *, "Wrong option" 
        deallocate (smoothedFlow) !4/25/2005
        stop
      end if
                    
      deallocate (smoothedFlow) !4/25/2005
      return 
      
    else if (ECSacMinExpMax < ECSacMinExpMin .and. ECSacMaxExpMax < ECSacMaxExpMin) THEN !inverse gradient: along both min sac flow and maximum sac flow
    
      if(debugCode)  print*," *** inverse gradient."
      
      if(ECSacMaxExpMax > ECTARGET-ECtolerance .and. ECSacMinExpMax > ECTARGET-ECtolerance) then
        if(debugCode)  LinearizationMethod='---always infeasible' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=0.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" 
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
                      
        deallocate (smoothedFlow) !4/25/2005
        return 

      else if(ECSacMaxExpMin < ECTARGET .and. ECSacMinExpMin < ECTARGET) then
        if(debugCode) LinearizationMethod='---always feasible' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=999996.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" !value=0.0
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
        
        deallocate (smoothedFlow) !4/25/2005    
        return    
                     
      else !usually make feasible because CalSim can not handle this kind of constraints
      
        if(debugCode) call ErrMessage("**!!** usually considered feasible because of inverse gradient.", &
                    location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
      
        if(debugCode) LinearizationMethod='-*- usually considered feasible.' !shengjun
        IF (variable==1) value=0.0
        IF (variable==2) value=999995.0
        IF (variable==3) then !shengjun 5/11/2005
          print *, "Wrong option" !value=0.0
          deallocate (smoothedFlow) !4/25/2005
          stop
        end if
        
        deallocate (smoothedFlow) !4/25/2005    
        return    
      end if    
    END IF      
        
    !---------------------------------------------------------------------------------------
    ! GET POINTS ON LINE
    !
    ! Four possibilies exist for the line intersections on the chart
    ! (sac:0-25,000; export:0-15,000)
    ! A: left and top
    ! B: left and right
    ! C: bottom and top
    ! D: bottom and right
    !---------------------------------------------------------------------------------------
    !print *, "step9"
    do i=1,2
      if(i==1) then
        point=linear1
      else if(i==2) then
        point=linear2
      end if
          
      !-------------------------------------------------------------------------
      ! A or B
      !--------------------------------------------------------------------
      if(ECtarget <= ECSacMinExpMax .AND. ECtarget >= ECSacMinExpMin) then
        !-------------------------------------------------------------------------
        ! A
        !--------------------------------------------------------------------
        if(ECtarget <= ECSacMinExpMax .AND. ECtarget >= ECSacMaxExpMax) then
          if(debugCode == .true.) LinearizationMethod='---Linear A situation'  !shengjun
          Qexp(tim4:tim5)=point
          !Qsac(tim4:tim5)=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005 and comment
          Qsac(1:tim5)= QsacMin !shengjun add

          ECtest1=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
          !normal conditions------------------------
          if(ECtest1 >= ECtarget) then
            !find Sac given export=point (for both point1 and point2)
            Qexp(tim4:tim5)=point
	          Qmin=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005  
	          Qmax=QSacMaximum
	          DIFF=TOL+1.
            tryNo=1 !record number of tries in searching crossing point x1 or x2
        	          
	          do while (DIFF > TOL)
	            DIFF=ABS(Qmax-Qmin)
	            Qmid=0.5*(Qmin+Qmax)
	            !Qsac(tim4:tim5)=Qmid shengjun comment 
	            
              !start of add by shengjun 5/18/2005
              smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
              Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
              !end of add

	            ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	            
	            if(tryNo ==1)then!check for possible inverse gradient
	              if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then !9/2008
                  if(debugCode) call ErrMessage("**!!** Inverse gradient in a valley cone (type A:normal conditions).",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)      
                end if     
    	          
	            end if
    	            
	            if(ECmid > ECtarget) then
	              Qmin=Qmid
	            else
	              Qmax=Qmid
	            end if
            end do
              
    	      if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
               if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type A:normal conditions).", &
                    location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	      end if
                          
            if(i==1)then
	            x1=Qmid
              y1=point
	          else if(i==2)then
	            x2=Qmid
              y2=point
            end if
          !below intercept--------------------------
          else if(ECtest1 < ECtarget) then
            !point1---------------------------------
            if(i==1)then
              !find export given Sac=0 (for point1)
              !Qsac(tim4:tim5)=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005 and comment
              Qsac(1:tim5)= QsacMin !shengjun
              
	            Qmin=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
	            Qmax=QExpMaximum
	            DIFF=TOL+1.
	            do while (DIFF > TOL)
	                DIFF=ABS(Qmax-Qmin)
	                Qmid=0.5*(Qmin+Qmax)
	                Qexp(tim4:tim5)=Qmid
	                ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	                if(ECmid > ECtarget)then
	                    Qmax=Qmid
	                else
	                    Qmin=Qmid
	                end if
              end do
              
    	        if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type A:below intercept).", &
                    location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	        end if
              
              x1=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005	    
              y1=Qmid
            !point2---------------------------------
            else if(i==2)then
              !start of add by shengjun 5/11/2005
              if(ForceOption .NE. 4 .and. x1== QSacMinimum) then
                !if point1 also missed interception then toss out this line
                IF (variable==1) value=0.0
                IF (variable==2) value=999998.0
                deallocate (smoothedFlow) !4/25/2005
                return
              else
              !end of add
                !find Sac given export=15000 (for point2)
                Qexp(tim4:tim5)=QExpMaximum            
	              Qmin=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005	    
	              Qmax=QSacMaximum
	              DIFF=TOL+1.
	              
                tryNo=1 !record number of tries in searching crossing point x1 or x2	              
                
	              do while (DIFF > TOL)
	                DIFF=ABS(Qmax-Qmin)
	                Qmid=0.5*(Qmin+Qmax)
	                !Qsac(tim4:tim5)=Qmid shengjun comment
                  !start of add by shengjun 5/18/2005
                  smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
                  Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
                  !end of add	                
	                
	                ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	                
	                if(tryNo ==1)then!check for possible inverse gradient
	                  if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then  !9/2008
                      if(debugCode) call ErrMessage("**!!** Inverse gradient (type A).", &
                          location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
                    end if     
        	          
	                end if	                
	                if(ECmid > ECtarget) then
	                  Qmin=Qmid
	                else
	                  Qmax=Qmid
	                end if
	              end do
	              
    	          if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                   if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type A:below intercept, point 2).", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	          end if
	              
                x2=Qmid
                y2=QExpMaximum
              end if!shengjun 5/11/2005
            end if
          end if
        !-------------------------------------------------------------------------
        ! B
        !-------------------------------------------------------------------------
        else if(ECtarget <= ECSacMaxExpMax .AND. ECtarget >= ECSacMaxExpMin) then
          if(debugCode == .true.) LinearizationMethod='---Linear B situation'  !shengjun
          
          Qexp(tim4:tim5)=point
          !Qsac(tim4:tim5)=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005 and comment          
          Qsac(1:tim5)= QsacMin !shengjun add
          
          ECtest1=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
          !below intercept--------------------------
          if(ECtest1 <= ECtarget) then
            !find export given Sac=0 (for point1)------
            if(i==1)then
              !Qsac(tim4:tim5)=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005 and comment 
              Qsac(1:tim5)= QsacMin
              
	            Qmin=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
	            Qmax=QExpMaximum
	            DIFF=TOL+1.
	            do while (DIFF > TOL)
	              DIFF=ABS(Qmax-Qmin)
	              Qmid=0.5*(Qmin+Qmax)
	              Qexp(tim4:tim5)=Qmid
	              ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	              if(ECmid > ECtarget)then
	                Qmax=Qmid
	              else
	                Qmin=Qmid
	              end if
              end do

    	        if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                 if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type B:below intercept, point 1.", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	        end if
              
              x1=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005
              y1=Qmid
              !find export given Sac=25000 (for point2)------
            else if(i==2)then
            
              !start of add by shengjun 5/11/2005
              if(ForceOption .NE. 4 .and. x1== QSacMinimum) then
                !if point1 also missed interception then toss out this line
                IF (variable==1) value=0.0
                IF (variable==2) value=999998.0
                deallocate (smoothedFlow) !4/25/2005
                return
              else
              !end of add
            
                Qsac(1:tim5)=QsacMax !shengjun add

	              Qmin=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
	              Qmax=QExpMaximum
	              DIFF=TOL+1.
	              do while (DIFF > TOL)
	                DIFF=ABS(Qmax-Qmin)
	                Qmid=0.5*(Qmin+Qmax)
	                Qexp(tim4:tim5)=Qmid
	                ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	                if(ECmid > ECtarget)then
	                  Qmax=Qmid
	                else
	                  Qmin=Qmid
	                end if
                end do
                
    	          if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                   if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type B:below intercept, point 2.", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	          end if
                
                x2=QSacMaximum
                y2=Qmid
              end if !shengjun 5/11/2005
            end if

          !above intercept--------------------------
          else if(ECtest1 > ECtarget) then
            Qexp(tim4:tim5)=point
            Qsac(1:tim5)=QSacMax !shengjun
            ECtest2=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
            !below right intercept--------------------------
            if(ECtest2 <= ECtarget) then
              Qexp(tim4:tim5)=point
	            Qmin=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005
	            Qmax=QSacMaximum
	            DIFF=TOL+1.
              tryNo=1 !record number of tries in searching crossing point x1 or x2
        	            
	            do while (DIFF > TOL)
	              DIFF=ABS(Qmax-Qmin)
	              Qmid=0.5*(Qmin+Qmax)
	              !Qsac(tim4:tim5)=Qmid shengjun 
                !start of add by shengjun 5/18/2005
                smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
                Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
                !end of add
	              
	              ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	              
	              if(tryNo ==1)then!check for possible inverse gradient 4/11/2006
	                if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then  !9/2008
                    if(debugCode) call ErrMessage("**!!** Inverse gradient(type B).",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)      
                  end if     
              	  
	              end if	  
  	                        
	              if(ECmid > ECtarget) then
	                  Qmin=Qmid
	                else
	                  Qmax=Qmid
	                end if
	            end do
  	            
    	        if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                 if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type B: above intercept.", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	        end if
  	            
	            if(i==1)then
	              x1=Qmid
	              y1=point
	            else if(i==2)then
	              x2=Qmid
	              y2=point
              end if
            !above right intercept--------------------------
            else if(ECtest2 > ECtarget) then
              !point1---------------------------------
	            if(i==1)then
	              !find export given Sac=0 (for point1)
	              !Qsac(tim4:tim5)=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005
	              Qsac(1:tim5)=QsacMin !shengjun 5/18/2005
	              Qmin=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
	              Qmax=QExpMaximum
	              DIFF=TOL+1.
	              do while (DIFF > TOL)
	                DIFF=ABS(Qmax-Qmin)
	                Qmid=0.5*(Qmin+Qmax)
	                Qexp(tim4:tim5)=Qmid
	                ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	                if(ECmid > ECtarget)then
	                  Qmax=Qmid
	                else
	                  Qmin=Qmid
	                end if
	              end do
	              
    	          if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                  if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type B: above right intercept, point 1", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	          end if
	              
	              x1=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005
	              y1=Qmid
	            !point2---------------------------------
	            else if(i==2)then
  	          	          
                !start of add by shengjun 5/11/2005
                if(ForceOption .NE. 4 .and. x1== QSacMinimum) then
                  !if point1 also missed interception then toss out this line
                  IF (variable==1) value=0.0
                  IF (variable==2) value=999998.0
                  deallocate (smoothedFlow) !4/25/2005
                  return
                else
                !end of add	        
	                !find export given Sac=25000 (for point2)
	                Qsac(1:tim5)=QSacMax !shengjun
	                Qmin=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
	                Qmax=QExpMaximum
	                DIFF=TOL+1.
	                do while (DIFF > TOL)
	                  DIFF=ABS(Qmax-Qmin)
	                  Qmid=0.5*(Qmin+Qmax)
	                  Qexp(tim4:tim5)=Qmid
	                  ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	                  if(ECmid > ECtarget)then
	                      Qmax=Qmid
	                  else
	                      Qmin=Qmid
	                  end if
	                end do

    	            if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                    if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type B: above right intercept, point 2.", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	            end if
	                
	                x2=QSacMaximum
	                y2=Qmid
	              end if!shengjun 5/11/2005
	            end if

            end if
          end if
        end if
      !-------------------------------------------------------------------------
      ! C or D
      !------------------------------------------------------------------------
      else if(ECtarget <= ECSacMinExpMin .AND. ECtarget >= ECSacMaxExpMin)then
        !-------------------------------------------------------------------------
        ! C
        !------------------------------------------------------------------------
        !All conditions may use the following:
        if(ECtarget <= ECSacMinExpMax .AND. ECtarget >= ECSacMaxExpMax) then
          if(debugCode == .true.) LinearizationMethod='---Linear C situation'  !shengjun
          
          Qexp(tim4:tim5)=point
          Qmin=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005
          Qmax=QSacMaximum
          DIFF=TOL+1.
          tryNo=1 !record number of tries in searching crossing point x1 or x2  4/11/2006
          
          do while (DIFF > TOL)
	          DIFF=ABS(Qmax-Qmin)
	          Qmid=0.5*(Qmin+Qmax)
	          !Qsac(tim4:tim5)=Qmid shengjun
            !start of add by shengjun 5/18/2005
            smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
            Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
            !end of add
	          
	          ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	          
	          if(tryNo ==1)then!check for possible inverse gradient 4/11/2006
	            if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then  !9/2008
                  if(debugCode) call ErrMessage("**!!** Inverse gradient (type C).",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)      
              end if     
              
	          end if	  
	          
	          
	          if(ECmid > ECtarget) then
	            Qmin=Qmid
	          else
	            Qmax=Qmid
	          end if	          
          end do
          
   	      if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
             if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type C)", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	    end if
          
          if(i==1)then
	          x1=Qmid
	          y1=point
          else if(i==2)then
	          x2=Qmid
	          y2=point
          end if
        !-------------------------------------------------------------------------
        ! D
        !-------------------------------------------------------------------------
        else if(ECtarget <= ECSacMaxExpMax .AND. ECtarget >= ECSacMaxExpMin) then
          if(debugCode == .true.) LinearizationMethod='---Linear D situation'  !shengjun
                   
          Qexp(tim4:tim5)=point 
          Qsac(1:tim5)=QSacMax !shengjun
          ECtest1=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
          !normal conditions------------------------
          if(ECtest1 <= ECtarget) then
	          !find Sac given export=point (for both point1 and point2)
	          Qexp(tim4:tim5)=point
	          Qmin=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005
	          Qmax=QSacMaximum
	          DIFF=TOL+1.	          
	          tryNo=1 !record number of tries in searching crossing point x1 or x2  4/11/2006
	          
	          do while (DIFF > TOL)
	            DIFF=ABS(Qmax-Qmin)
	            Qmid=0.5*(Qmin+Qmax)
	            !Qsac(tim4:tim5)=Qmid shengjun
              !start of add by shengjun 5/18/2005
              smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
              Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
              !end of add
	            
	            ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	            
	            if(tryNo ==1)then!check for possible inverse gradient 4/11/2006
	              if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then  !9/2008
                  if(debugCode) call ErrMessage("**!!** Inverse gradient (type D: normal condition).",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)      
                end if     
              	
	            end if	  
	            
	            if(ECmid > ECtarget) then
	              Qmin=Qmid
	            else
	              Qmax=Qmid
	            end if
	          end do	      
   	        if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type D: normal condition).", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	      end if
  	        
	          if(i==1)then
	            x1=Qmid
	            y1=point
	          else if(i==2)then
	            x2=Qmid
	            y2=point
	          end if
          !above intercept--------------------------
	        else if(ECtest1 > ECtarget) then
	          !point1---------------------------------
	          if(i==1)then
	            !find Sac given export=0 (for point1)
	            Qexp(tim4:tim5)=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
	            Qmin=QSacMinimum ! shengjun changed from 0. to QSacMinimum 2/22/2005
	            Qmax=QSacMaximum
	            DIFF=TOL+1.
	            tryNo=1 !record number of tries in searching crossing point x1 or x2  4/11/2006
	            
	            do while (DIFF > TOL)
	              DIFF=ABS(Qmax-Qmin)
	              Qmid=0.5*(Qmin+Qmax)
	              !Qsac(tim4:tim5)=Qmid shengjun
                !start of add by shengjun 5/18/2005
                smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qmid,mon0,mon1,mon2,mon3,mon4)
                Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
                !end of add
	              
	              ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	              
	              if(tryNo ==1)then!check for possible inverse gradient 4/11/2006
	                if(ECmid > ANN_Month(QsacMin+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)) then  !9/2008
                      if(debugCode) call ErrMessage("**!!** Inverse gradient (type D:above intercept).",location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)      
                  end if     
                	
	              end if	  
	              
	              if(ECmid > ECtarget) then
	                Qmin=Qmid
	              else
	                Qmax=Qmid
	              end if
	            end do
	            
   	          if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                  if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type D: above intercept, point 1.", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	        end if
	            
	            x1=Qmid
	            y1=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
	          !point2---------------------------------
	          else if(i==2)then
              !start of add by shengjun 5/11/2005
              if(ForceOption .NE. 4 .and. y1== QExpMinEnforced) then
                !if point1 also missed interception then toss out this line
                IF (variable==1) value=0.0
                IF (variable==2) value=999998.0
                deallocate (smoothedFlow) !4/25/2005
                return
              else
              !end of add
  	        
	              !find export given Sac=25000 (for point2)
	              Qsac(1:tim5)=QSacMax !shengjun add 5/18/2005
	              Qmin=QExpMinEnforced ! shengjun changed from 0. to QExpMinEnforced 2/22/2005
	              Qmax=QExpMaximum
	              DIFF=TOL+1.
	              do while (DIFF > TOL)
	                DIFF=ABS(Qmax-Qmin)
	                Qmid=0.5*(Qmin+Qmax)
	                Qexp(tim4:tim5)=Qmid
	                ECmid=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)!shengjun 12/16/2004 & Hao 9/2008
	                if(ECmid > ECtarget)then
	                  Qmax=Qmid
	                else
	                  Qmin=Qmid
	                end if
	              end do
	              
   	            if(abs(ECmid -ECtarget)> 0.05*ECtarget) then !4/11/2006
                  if(debugCode) call ErrMessage("!* more than 5% off from EC target contour in no cone procedure (type D: above intercept, point 2.", &
                        location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
    	          end if
	              
	              x2=QSacMaximum
	              y2=Qmid
	            end if!shengjun 5/11/2005
	          end if
          end if
        end if
      
      else !shengjun 5/12/2005
        if (debugCode) print *,"**!!** Considered infeasible. special case in No cone situation (not A,B,C or D)"
        IF (variable==1) value=0.0
        IF (variable==2) value=0.0
        IF (variable==3) then 
          print *, "Wrong option" 
          stop
        end if
        
        if(debugCode) call ErrMessage("**!!** Considered infeasible. special case in No cone situation (not A,B,C or D).", &
                    location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption)
                    
        if (debugCode) print *,"The ECtarget contour in in the top of  Month, Year:", currMonth,currYear                          
        if (debugCode) print *,"ECSacMinExpMin,ECSacMaxExpMin,ECSacMinExpMax,ECSacMaxExpMax with EC target:",ECSacMinExpMin,ECSacMaxExpMin,ECSacMinExpMax,ECSacMaxExpMax, ECtarget
        if (debugCode) print *,"MinECQsacMin,MinECQsacMax:",MinECQsacMin,MinECQsacMax
        deallocate (smoothedFlow) !4/25/2005                  
        return
      
      end if
    end do
  end if !shengjun 5/13/2005
  
  if(abs(x2-x1) .lt. TOL) then !shengjun add 2/23/2005         
    slope =1.0e10 !shengjun add 2/23/2005
    
    if(debugCode) print *,"Vertical contour at Month, Year: EC target", currMonth,currYear,ECtarget
    if(debugCode) print *,"x1,y1,x2,y2",x1,y1,x2,y2
    if(debugCode) write(*,*) 'ECSacMaxExpMin=',ECSacMaxExpMin, ' ECSacMinExpMax=',ECSacMinExpMax, ' ECSacMinExpMin=',ECSacMinExpMin,' ECSacMaxExpMax=',ECSacMaxExpMax !shengjun add 9/29/2005  
  else
    slope=(y2-y1)/(x2-x1)
  end if
  
  intercept=y1-slope*x1 !shengjun add 2/22/2005

!  WRITE(*,*) 'water year=',currYear, ' month=',currMonth, ' slope=',slope, ' intercept=',intercept, ' ECtarget=', ECtarget, ' location=',location !shengjun add 2/22/2005
 ! write(*,*) 'ECSacMaxExpMin=',ECSacMaxExpMin, ' ECSacMinExpMax=',ECSacMinExpMax, ' ECSacMinExpMin=',ECSacMinExpMin,' ECSacMaxExpMax=',ECSacMaxExpMax !shengjun add 2/22/2005  
  !WRITE(*,*) 'X=',x1,';',x2, '  Y=',y1,';',y2!shengjun add 2/22/2005  
  
  if(debugCode == .true.) print *, "Linearization method used:", LinearizationMethod !shengjun
  
  IF (variable==1) value=slope
  IF (variable==2) value=intercept
  IF (variable==3) then
    !value=Qsac1k
    WRITE(*,*) 'this option is not implemented. '
    stop  !shengjun add
  end if
  !CLOSE(8)
  
  !start of add By shengjun 5/13/2005
  contains
  
    subroutine ErrMessage(MessageText,location, currYear,currMonth,ECTARGET,linear1,linear2,ForceOption) !4/10/2006
	    ! write message to ANN_info.txt
	    !     
        character (len = *),INTENT(IN) :: MessageText
        real, INTENT(IN) :: ECTARGET,linear1,linear2
        integer, INTENT(IN) :: location, currYear,currMonth,ForceOption
        
        open(17,file="ANN_Info.txt",status="unknown",position="append")        
        write(17,'(1x,a)') MessageText
        write(17,'(1x,a,3i6, g12.4)') "  at location (water year,month) and EC target:", location, currYear,currMonth,ECTARGET
        write(17,'(1x,a,2f9.1,i6)') "   piecewise informaton linear1,linear2,ForceOption:",linear1,linear2,ForceOption
        close(17)
                        
	     return
	     
!	     print *, "error occurs in opening ANN_info.txt."
	    
    end subroutine ErrMessage
       
    real function LocateMinECSequentially(QSacFlow,QMinExp,QMaxExp,StepSize,QExpMinEC) result (MinEC)
    !this function search the minimum EC along a constant Sac Flow (QsacFlow) by sequential method using a defined "stepSize"    
    !it return MinEC found and the QExpMinEC by reference
    !this function return min EC at a given SacFlow and Export range. measured by a certain StepSize
    !this funciton does not search the EC at MinExp rather starting from MinExp+stepSize
    !QMinExp,QMaxExp: minimum and maximum of export to be searched along QSacFlow line
    !QExpMinEC: the export found cause the minimum EC
    
        real,INTENT(IN) :: QSacFlow,QMinExp,QMaxExp,StepSize
        real tempFlow, tempEC,QExpMinEC
        
        MinEC=1.0E10            
        !Qsac(tim4:tim5)=QSacFlow shengjun comment
        
        !start of add by shengjun 4/25/2005
        smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,QSacFlow,mon0,mon1,mon2,mon3,mon4)
        Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
        !end of add
        
  	    do tempFlow = QMinExp+StepSize,QMaxExp, StepSize
	        Qexp(tim4:tim5)= tempFlow
	        tempEC=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)  !9/2008

	        if(tempEC > 1.0E10) then
            if(debugCode) call ErrMessage("!!!! ANN EC is not reasonable when running LocateMinECSequentially () at (location, currYear,currMonth) with EC (and QSacFlow,Export,ForceOption): ", &
                      location, currYear,currMonth,tempEC,QSacFlow,tempFlow,ForceOption)	        
	        elseif(tempEC < MinEC) then
	          MinEC=tempEC
	          QExpMinEC=tempFlow
	        end if
        end do
       
    end function LocateMinECSequentially
    
    real function LocateMaxECSequentially(QSacFlow,QMinExp,QMaxExp,StepSize,QExpMaxEC) result (MaxEC) !4/17/2006
    !this function search the maximum EC along a constant Sac Flow (QsacFlow) by sequential method using a defined "stepSize"    
    !it return MinEC found and the QExpMinEC by reference
    !this function return min EC at a given SacFlow and Export range. measured by a certain StepSize
    !this funciton does not search the EC at MinExp rather starting from MinExp+stepSize
    !QMinExp,QMaxExp: minimum and maximum of export to be searched along QSacFlow line
    !QExpMaxEC: the export found cause the maximum EC
    
        real,INTENT(IN) :: QSacFlow,QMinExp,QMaxExp,StepSize
        real tempFlow, tempEC,QExpMaxEC
        
        MaxEC=0.0 !4/17/2006
        !Qsac(tim4:tim5)=QSacFlow shengjun comment
        
        !start of add by shengjun 4/25/2005
        smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,QSacFlow,mon0,mon1,mon2,mon3,mon4)
        Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
        !end of add
        
  	    do tempFlow = QMinExp+StepSize,QMaxExp, StepSize
	        Qexp(tim4:tim5)= tempFlow
	        tempEC=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type)  !9/2008
	        
	        if(tempEC > 1.0E10) then
            if(debugCode) call ErrMessage("!!!! ANN EC is not reasonable when running LocateMaxECSequentially () at (location, currYear,currMonth) with EC (and QSacFlow,Export,ForceOption): ", &
                      location, currYear,currMonth,tempEC,QSacFlow,tempFlow,ForceOption)
	        else if(tempEC > MaxEC) then !4/17/2006
	          MaxEC=tempEC
	          QExpMaxEC=tempFlow	        
	        end if
        end do
       
    end function LocateMaxECSequentially
    
   !end of add
END FUNCTION AnnLineGen
