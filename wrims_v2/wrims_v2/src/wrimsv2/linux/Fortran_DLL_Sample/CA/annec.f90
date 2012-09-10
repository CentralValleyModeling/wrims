! Last change: RW Feb 8,2003
! Last change: SWU 7/1/2007
! Last change: Hao Xie 9/2008

! Function provides access to the ANN code and returns the salinity at a specific
! location in the Delta given a history of flow values.

! LOCATION KEY:
!   1 = Jersey Point
!   2 = Contra Costa - Rock Slough
!   3 = Emmaton
!   4 = Antiock
!   5 = Collins
!   6 = Mallard - Chipps Island
!   7 = LosVaqueros
!   8 = Middle River intake
!   9 = Victoria intake
!  10= CVP intake
!  11= CCFB
!  12= CCFB intake
!  13= X2

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
!   7 =  average for first 15 days
!   8 = average for last 15 days
!  10: average between specified range (BeginDay- EndDay, counting from the beginning of the month) 7/11/2007!

FUNCTION ANNEC( &
     Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,&
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,&
     Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_prv4,&
     DXC_prv0,DXC_prv1,DXC_prv2,DXC_prv3,DXC_prv4,&     
     DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4,&  !shengjun add 2/24/2005          
     Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4,&
     Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4,&
     VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4,&     
     mon0,mon1,mon2,mon3,mon4,location,ave_type,currMonth,currYear,BeginDay, EndDay)  RESULT (outputEC) !shengjun 2/14/2005
  !use ann_ext
       
  use SFtideModule !shengjun 2/14/2005

  IMPLICIT NONE
  !ANNEC with non-smoothed Sac and SJR
  !use ann
    
  interface 
    function ConservativeSpline(monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5, &
                              daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5) result (smoothedOutput)
      implicit none
	    integer,INTENT(IN) ::  daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5
	    REAL,INTENT(IN)    ::  monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5
	    real, allocatable  ::  smoothedOutput(:)	  
    end function 	ConservativeSpline
            
  end interface
  
  REAL ::  ANN_Month
  integer :: initall
  ! input and output of the function
  ! DXC=0,CLOSED  DXC=1,OPEN
  REAL,INTENT(IN)    :: &
       Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,&
       Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,&
       Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_prv4,&
       DXC_prv0,DXC_prv1, DXC_prv2, DXC_prv3,DXC_prv4,&
       Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4,&
       Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4, &
       DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4, &  !shengjun add 2/24/2005 
       VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4    !Hao add 9/2008
  
  integer, INTENT(IN) :: currMonth, currYear !shengjun 2/14/2005
  integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
  
  INTEGER :: location,mon0,mon1,mon2,mon3,mon4,ave_type
  REAL    :: outputEC
  integer :: tim0,tim1,tim2,tim3,tim4,tim5
  REAL,DIMENSION(148) :: Qsac,Qexp,Qsjr,DXC,Qsac_oth,Qexp_oth,currSFtide,DICU, VernEC !2/14/2005 and 2/24/2005 and 9/2008
  INTEGER             :: i,SFtideStartIndex,SFtideEndIndex !2/14/2005  
  integer :: getSFtideArrayEndIndex !2/14/2005
  real, allocatable :: smoothedFlow(:) !4/1/2005  
  integer debugFlag ; debugFlag =0
        
  i = initall()

  tim5=148          ! last day of current month
  tim4=tim5-mon4+1  ! first day of current month
  tim3=tim4-mon3    ! first day of 1 month ago
  tim2=tim3-mon2    ! first day of 2 months ago
  tim1=tim2-mon1    ! first day of 3 months ago
  tim0=1            ! first day of 118 days before the last day of the current month

  allocate (smoothedFlow(mon0+mon1+mon2+mon3+mon4))

  ! 118 values daily are needed to estimate one daily value of EC
  ! this function builds the first set of input arrays representing
  ! dxc position and river inflow.
  !
  ! The arrays have the following structure
  ! tim0         tim1         tim2         tim3           tim4         tim5
  ! --------------------------------------------------------------------
  ! |this month-4|this month-3|this month-2| this month-1 | this month |
  ! --------------------------------------------------------------------

  Qsac(tim0:(tim1-1))=Qsac_prv0 !shengjun comment to make smooth input 4/4/2005
  Qsac(tim1:(tim2-1))=Qsac_prv1
  Qsac(tim2:(tim3-1))=Qsac_prv2
  Qsac(tim3:(tim4-1))=Qsac_prv3
  Qsac(tim4:tim5)=Qsac_prv4    

!  smoothedFlow = ConservativeSpline(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4, mon0,mon1,mon2,mon3,mon4)                          
 ! Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)  
  
  Qexp(tim0:(tim1-1))=Qexp_prv0
  Qexp(tim1:(tim2-1))=Qexp_prv1
  Qexp(tim2:(tim3-1))=Qexp_prv2
  Qexp(tim3:(tim4-1))=Qexp_prv3
  Qexp(tim4:tim5)=Qexp_prv4

  Qsjr(tim0:(tim1-1))=Qsjr_prv0 !shengjun comment to make smooth input 4/4/2005
  Qsjr(tim1:(tim2-1))=Qsjr_prv1
  Qsjr(tim2:(tim3-1))=Qsjr_prv2
  Qsjr(tim3:(tim4-1))=Qsjr_prv3
  Qsjr(tim4:tim5)=Qsjr_prv4

  !smoothedFlow = ConservativeSpline(Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_prv4, mon0,mon1,mon2,mon3,mon4)
  !Qsjr(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4-tim5+1:mon0+mon1+mon2+mon3+mon4)

  Qsac_oth(tim0:(tim1-1))=Qsac_oth_prv0
  Qsac_oth(tim1:(tim2-1))=Qsac_oth_prv1
  Qsac_oth(tim2:(tim3-1))=Qsac_oth_prv2
  Qsac_oth(tim3:(tim4-1))=Qsac_oth_prv3
  Qsac_oth(tim4:tim5)=Qsac_oth_prv4

  Qexp_oth(tim0:(tim1-1))=Qexp_oth_prv0
  Qexp_oth(tim1:(tim2-1))=Qexp_oth_prv1
  Qexp_oth(tim2:(tim3-1))=Qexp_oth_prv2
  Qexp_oth(tim3:(tim4-1))=Qexp_oth_prv3
  Qexp_oth(tim4:tim5)=Qexp_oth_prv4
  
  !start of add by shengjun 2/24/2005
  DICU(tim0:(tim1-1))=DICU_prv0
  DICU(tim1:(tim2-1))=DICU_prv1
  DICU(tim2:(tim3-1))=DICU_prv2
  DICU(tim3:(tim4-1))=DICU_prv3
  DICU(tim4:tim5)=DICU_prv4
  !end of add
  
  !start of add by shengjun 2/15/2005
  SFtideEndIndex= getSFtideArrayEndIndex(mon4,currMonth,currYear)
  SFtideStartIndex= SFtideEndIndex - tim5 + 1
  currSFtide(tim0:tim5)=SFtide(SFtideStartIndex:SFtideEndIndex)  
  !end of add
  
  deallocate (smoothedFlow) !4/1/2005
    
  do i=tim0,(tim1-1)              ! last portion of 4th previous month
    if ( i < (dxc_prv0-(mon0-tim1))) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  end do
  DO i=tim1,(tim2-1)              ! 3rd previous month
    if ( i-tim1 < dxc_prv1) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  DO i=tim2,(tim3-1)              ! 2nd previous month
    if ( i-tim2 < dxc_prv2) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  DO i=tim3,(tim4-1)              ! previous month
    if ( i-tim3 < dxc_prv3) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  DO i=tim4,tim5                  ! current month
    if ( i-tim4 < dxc_prv4) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  
  !start of add by Hao 9/2008
  VernEC(tim0:(tim1-1))=VernEC_prv0
  VernEC(tim1:(tim2-1))=VernEC_prv1
  VernEC(tim2:(tim3-1))=VernEC_prv2
  VernEC(tim3:(tim4-1))=VernEC_prv3
  VernEC(tim4:tim5)=VernEC_prv4
  !end of add
            
  outputEC=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type,BeginDay, EndDay)!shengjun revised 12/16/2004     
    
  if(debugFlag == 1 .and. location==2 .and. ave_type==1) then  
    print*,"Information in ANNEC():"
    print*,"month, water year:",currMonth,currYear            
    print*,"Qsac_smooth=",Qsac(1:tim5)  !4/13/2005
    print*,"Qsjr_smooth=",Qsjr(1:tim5)  !4/13/2005
    print*,"dxc=",dxc(1:tim5)  !4/21/2005
    print*,"Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4:",Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4
    print*,"Qsac0,Qsac1,Qsac2,Qsac3,Qsac4:",Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4    
    print*,"Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4:",Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4
    print*,"Qexp0,Qexp1,Qexp2,Qexp3,Qexp4:",Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4
    print*,"SFtideStartIndex,SFtideEndIndex:",SFtideStartIndex,SFtideEndIndex
    print*,"SFtide=",currSFtide(1:tim5)  !4/13/2005   
    print*,"DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4:",DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4
    print*,"VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4:",VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4
    print*,"outputEC at ORRSL: ",outputEC
    
  end if
    
END function ANNEC


!************* start of add by Shengjun Wu 4/13/08: new ANNEC_curMonInpSplit
!this function calculates averaged monthly EC but allows the input for current month
!splitted up to 3 pieces.
FUNCTION ANNEC_curMonInpSplit( &
     Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,Qsac_prv4_1,Qsac_prv4_2, &
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,Qexp_prv4_1,Qexp_prv4_2, &
     Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_prv4,Qsjr_prv4_1,Qsjr_prv4_2, &
     DXC_prv0,DXC_prv1,DXC_prv2,DXC_prv3,DXC_prv4,DXC_prv4_1,DXC_prv4_2, &     
     DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4,DICU_prv4_1,DICU_prv4_2, & 
     Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4,Qsac_oth_prv4_1,Qsac_oth_prv4_2, &
     Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4,Qexp_oth_prv4_1,Qexp_oth_prv4_2, &
     VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4,VernEC_prv4_1,VernEC_prv4_2, &     
     mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,location,ave_type,currMonth,currYear,BeginDay, EndDay) RESULT (outputEC) 
  !mon4_1 and mon4_2 are the number of days in mon4 which the input of Qsac_prv4_1,Qsac_prv4_2 
  ! are applicable to these two periods respectively. It holds true for all input: Qexp_prv4_1,Qexp_prv4_2, etc,..
  ! condition: mon4_1+mon4_2 <=mon4
       
  use SFtideModule

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
  
  REAL ::  ANN_Month
  integer :: initall
  ! input and output of the function
  ! DXC=0,CLOSED  DXC=1,OPEN
  REAL,INTENT(IN)    ::  &
     Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,Qsac_prv4_1,Qsac_prv4_2, &
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,Qexp_prv4_1,Qexp_prv4_2, &
     Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_prv4,Qsjr_prv4_1,Qsjr_prv4_2, &
     DXC_prv0,DXC_prv1,DXC_prv2,DXC_prv3,DXC_prv4,DXC_prv4_1,DXC_prv4_2, &     
     DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4,DICU_prv4_1,DICU_prv4_2, & 
     Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4,Qsac_oth_prv4_1,Qsac_oth_prv4_2, &
     Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4,Qexp_oth_prv4_1,Qexp_oth_prv4_2, &
     VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4,VernEC_prv4_1,VernEC_prv4_2     !9/2008
  
  integer, INTENT(IN) :: currMonth, currYear !shengjun 2/14/2005
  integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
  
  INTEGER,INTENT(IN) :: location,mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type
  REAL    :: outputEC
  integer :: tim0,tim1,tim2,tim3,tim4,tim5
  REAL,DIMENSION(148) :: Qsac,Qexp,Qsjr,DXC,Qsac_oth,Qexp_oth,currSFtide,DICU, VernEC !2/14/2005 and 2/24/2005 and 9/2008
  INTEGER             :: i,SFtideStartIndex,SFtideEndIndex !2/14/2005  
  integer :: getSFtideArrayEndIndex !2/14/2005
  real, allocatable :: smoothedFlow(:) !4/1/2005  
  integer debugFlag ; debugFlag =0

  if (mon4_1+mon4_2 > mon4) then
  
    print*,"error: mon4_1+mon4_2 > mon4 at Location: ", location
    print*,"       mon4_1 and mon4_2 at water year and water month:",mon4_1, mon4_2, currYear,currMonth
  
	stop    

  end if
    
  if (mon4_1 < 0. .or. mon4_2 <0.) then
  	
    print*,"error: negative mon4_1 or mon4_2.Location, mon4_1 and mon4_2, at water year and water month:", &
         location, mon4_1,mon4_2, currYear,currMonth
         
    stop         
  end if
        
  i = initall()

  tim5=148          ! last day of current month
  tim4=tim5-mon4+1  ! first day of current month
  tim3=tim4-mon3    ! first day of 1 month ago
  tim2=tim3-mon2    ! first day of 2 months ago
  tim1=tim2-mon1    ! first day of 3 months ago
  tim0=1            ! first day of 118 days before the last day of the current month

  allocate (smoothedFlow(mon0+mon1+mon2+mon3+mon4))

  ! 118 values daily are needed to estimate one daily value of EC
  ! this function builds the first set of input arrays representing
  ! dxc position and river inflow.
  !
  ! The arrays have the following structure
  ! tim0         tim1         tim2         tim3           tim4         tim5
  ! --------------------------------------------------------------------
  ! |this month-4|this month-3|this month-2| this month-1 | this month |
  ! --------------------------------------------------------------------

  Qsac(tim0:(tim1-1))=Qsac_prv0 
  Qsac(tim1:(tim2-1))=Qsac_prv1
  Qsac(tim2:(tim3-1))=Qsac_prv2
  Qsac(tim3:(tim4-1))=Qsac_prv3
  Qsac(tim4:tim5)=Qsac_prv4      
  if(mon4_1 > 0) Qsac(tim4:(tim4+mon4_1-1))=Qsac_prv4_1    
  if(mon4_2 > 0) Qsac(tim4+mon4_1:(tim4+mon4_1+mon4_2-1))=Qsac_prv4_2
  
  Qexp(tim0:(tim1-1))=Qexp_prv0
  Qexp(tim1:(tim2-1))=Qexp_prv1
  Qexp(tim2:(tim3-1))=Qexp_prv2
  Qexp(tim3:(tim4-1))=Qexp_prv3
  Qexp(tim4:tim5)=Qexp_prv4
  if(mon4_1 > 0) Qexp(tim4:(tim4+mon4_1-1))=Qexp_prv4_1    
  if(mon4_2 > 0) Qexp(tim4+mon4_1:(tim4+mon4_1+mon4_2-1))=Qexp_prv4_2

  Qsjr(tim0:(tim1-1))=Qsjr_prv0 !shengjun comment to make smooth input 4/4/2005
  Qsjr(tim1:(tim2-1))=Qsjr_prv1
  Qsjr(tim2:(tim3-1))=Qsjr_prv2
  Qsjr(tim3:(tim4-1))=Qsjr_prv3
  Qsjr(tim4:tim5)=Qsjr_prv4
  if(mon4_1 > 0) Qsjr(tim4:(tim4+mon4_1-1))=Qsjr_prv4_1    
  if(mon4_2 > 0) Qsjr(tim4+mon4_1:(tim4+mon4_1+mon4_2-1))=Qsjr_prv4_2

  Qsac_oth(tim0:(tim1-1))=Qsac_oth_prv0
  Qsac_oth(tim1:(tim2-1))=Qsac_oth_prv1
  Qsac_oth(tim2:(tim3-1))=Qsac_oth_prv2
  Qsac_oth(tim3:(tim4-1))=Qsac_oth_prv3
  Qsac_oth(tim4:tim5)=Qsac_oth_prv4
  if(mon4_1 > 0) Qsac_oth(tim4:(tim4+mon4_1-1))=Qsac_oth_prv4_1    
  if(mon4_2 > 0) Qsac_oth(tim4+mon4_1:(tim4+mon4_1+mon4_2-1))=Qsac_oth_prv4_2

  Qexp_oth(tim0:(tim1-1))=Qexp_oth_prv0
  Qexp_oth(tim1:(tim2-1))=Qexp_oth_prv1
  Qexp_oth(tim2:(tim3-1))=Qexp_oth_prv2
  Qexp_oth(tim3:(tim4-1))=Qexp_oth_prv3
  Qexp_oth(tim4:tim5)=Qexp_oth_prv4
  if(mon4_1 > 0) Qexp_oth(tim4:(tim4+mon4_1-1))=Qexp_oth_prv4_1    
  if(mon4_2 > 0) Qexp_oth(tim4+mon4_1:(tim4+mon4_1+mon4_2-1))=Qexp_oth_prv4_2
  
  DICU(tim0:(tim1-1))=DICU_prv0
  DICU(tim1:(tim2-1))=DICU_prv1
  DICU(tim2:(tim3-1))=DICU_prv2
  DICU(tim3:(tim4-1))=DICU_prv3
  DICU(tim4:tim5)=DICU_prv4
  if(mon4_1 > 0) DICU(tim4:(tim4+mon4_1-1))=DICU_prv4_1    
  if(mon4_2 > 0) DICU(tim4+mon4_1:(tim4+mon4_1+mon4_2-1))=DICU_prv4_2
  
  !start of add by shengjun 2/15/2005
  SFtideEndIndex= getSFtideArrayEndIndex(mon4,currMonth,currYear)
  SFtideStartIndex= SFtideEndIndex - tim5 + 1
  currSFtide(tim0:tim5)=SFtide(SFtideStartIndex:SFtideEndIndex)  
  !end of add
  
  deallocate (smoothedFlow) !4/1/2005
    
  do i=tim0,(tim1-1)              ! last portion of 4th previous month
    if ( i < (dxc_prv0-(mon0-tim1))) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  end do
  DO i=tim1,(tim2-1)              ! 3rd previous month
    if ( i-tim1 < dxc_prv1) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  DO i=tim2,(tim3-1)              ! 2nd previous month
    if ( i-tim2 < dxc_prv2) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  DO i=tim3,(tim4-1)              ! previous month
    if ( i-tim3 < dxc_prv3) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  DO i=tim4,tim5                  ! current month
    if ( i-tim4 < dxc_prv4) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  
  VernEC(tim0:(tim1-1))=VernEC_prv0
  VernEC(tim1:(tim2-1))=VernEC_prv1
  VernEC(tim2:(tim3-1))=VernEC_prv2
  VernEC(tim3:(tim4-1))=VernEC_prv3
  VernEC(tim4:tim5)=VernEC_prv4
  if(mon4_1 > 0) VernEC(tim4:(tim4+mon4_1-1))=VernEC_prv4_1    
  if(mon4_2 > 0) VernEC(tim4+mon4_1:(tim4+mon4_1+mon4_2-1))=VernEC_prv4_2   !Hao add 9/2008
            
  outputEC=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon4,ave_type,BeginDay, EndDay)!Hao revised 9/2008     
    
  if(debugFlag == 1 .and. location==2 .and. ave_type==1) then  
    print*,"Information in ANNEC():"
    print*,"month, water year:",currMonth,currYear            
    print*,"Qsac_smooth=",Qsac(1:tim5)  !4/13/2005
    print*,"Qsjr_smooth=",Qsjr(1:tim5)  !4/13/2005
    print*,"dxc=",dxc(1:tim5)  !4/21/2005
    print*,"Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4:",Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4
    print*,"Qsac0,Qsac1,Qsac2,Qsac3,Qsac4:",Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4    
    print*,"Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4:",Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4
    print*,"Qexp0,Qexp1,Qexp2,Qexp3,Qexp4:",Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4
    print*,"SFtideStartIndex,SFtideEndIndex:",SFtideStartIndex,SFtideEndIndex
    print*,"SFtide=",currSFtide(1:tim5)  !4/13/2005   
    print*,"DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4:",DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4
    print*,"VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4:",VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4  ! 9/2008
    print*,"outputEC at ORRSL: ",outputEC
    
  end if
    
END function ANNEC_curMonInpSplit

!************** end of add 4/13/08


FUNCTION AnnEC_matchDSM2(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,Qsac_prv5,Qsac_prv6,&
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,&
     Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_prv4,Qsjr_prv5,Qsjr_prv6, &
     DXC_prv0,DXC_prv1,DXC_prv2,DXC_prv3,DXC_prv4,&     
     DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4,&  !shengjun add 2/24/2005          
     Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4,&
     Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4,& 
     VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4,&   
     mon0,mon1,mon2,mon3,mon4,mon5,mon6,location,ave_type,currMonth,currYear,BeginDay, EndDay)  RESULT (outputEC) !shengjun 2/14/2005

  !**** this function uses one month earlier and one month later to smooth Sac flow and SJR flow (comparing with ANNEC() to make a complete smoothing like DSM2)
  !**** the only data used in ANN EC estimation does not include the first month and the last month (for Sac and SJR flows)
  !**** Qexp,Qexp_oth, Qsac_oth and DXC should be the data from Month 2 to Month 6 comparing with Sac flow and SJR flow data
  !**** for example: DXC_prv0,DXC_prv1,DXC_prv2,DXC_prv3 and DXC_prv4 match mon1,mon2,mon3,mon4 and mon5 respectively
     
  !use ann_ext
   
  use SFtideModule 
  use ann !3/24/2006

  IMPLICIT NONE
  
  !use ann
  interface 
      
    function ConservativeSpline7Months(monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5,monthlyInput6,monthlyInput7, &
         daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5,daysInMonth6,daysInMonth7) result (smoothedOutput)
      implicit none
  	  integer,INTENT(IN) ::  daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5,daysInMonth6,daysInMonth7
	    REAL,INTENT(IN)    ::  monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5,monthlyInput6,monthlyInput7
	    real, allocatable  ::  smoothedOutput(:)	  
    end function 	ConservativeSpline7Months
      
  end interface
  
  REAL ::  ANN_Month
    
  integer :: initall
  ! input and output of the function
  ! DXC=0,CLOSED  DXC=1,OPEN
  REAL,INTENT(IN)  :: Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,Qsac_prv5,Qsac_prv6, &
       Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,&
       Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_prv4,Qsjr_prv5,Qsjr_prv6, &
       DXC_prv0,DXC_prv1, DXC_prv2, DXC_prv3,DXC_prv4,&
       Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4,&
       Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4, &
       DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4, &  !shengjun add 2/24/2005 
       VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4     !9/2008  
  
  integer, INTENT(IN) :: currMonth, currYear !shengjun 2/14/2005
  integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
  
  INTEGER :: location,mon0,mon1,mon2,mon3,mon4,mon5,mon6,ave_type
  REAL    :: outputEC
  integer :: tim0,tim1,tim2,tim3,tim4,tim5
  REAL,DIMENSION(148) :: Qsac,Qexp,Qsjr,DXC,Qsac_oth,Qexp_oth,currSFtide,DICU, VernEC !2/14/2005 and 2/24/2005 and 9/2008 
  INTEGER             :: i,SFtideStartIndex,SFtideEndIndex !2/14/2005  
  integer :: getSFtideArrayEndIndex !2/14/2005
  real, allocatable :: smoothedFlow(:) !4/1/2005  
  integer debugFlag ; debugFlag =0
                
  i = initall()
  
  !shengjun modified the following to make sure Month 2 is the start month
  tim5=148          ! last day of current month
  tim4=tim5-mon5+1  ! first day of current month
  tim3=tim4-mon4    ! first day of 1 month ago
  tim2=tim3-mon3    ! first day of 2 months ago
  tim1=tim2-mon2    ! first day of 3 months ago
  tim0=1            ! first day of 118 days before the last day of the current month

  allocate (smoothedFlow(mon0+mon1+mon2+mon3+mon4+mon5+mon6)) !shengjun 4/17/2005

  ! 118 values daily are needed to estimate one daily value of EC
  ! this function builds the first set of input arrays representing
  ! dxc position and river inflow.
  !
  ! The arrays have the following structure
  ! tim0         tim1         tim2         tim3           tim4         tim5
  ! --------------------------------------------------------------------
  ! |this month-4|this month-3|this month-2| this month-1 | this month |
  ! --------------------------------------------------------------------  

!  Qsac(tim0:(tim1-1))=Qsac_prv1 !shengjun comment to make smooth input 4/4/2005
 ! Qsac(tim1:(tim2-1))=Qsac_prv2
  !Qsac(tim2:(tim3-1))=Qsac_prv3
!  Qsac(tim3:(tim4-1))=Qsac_prv4
 ! Qsac(tim4:tim5)=Qsac_prv5    

  smoothedFlow = ConservativeSpline7Months(Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,Qsac_prv5, &
                    Qsac_prv6,mon0,mon1,mon2,mon3,mon4,mon5,mon6)    
  !beware the first month and the last month data are not what wanted
  Qsac(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4+mon5-tim5+1:mon0+mon1+mon2+mon3+mon4+mon5)  !shengjun revised 4/18/2005
  
  Qexp(tim0:(tim1-1))=Qexp_prv0
  Qexp(tim1:(tim2-1))=Qexp_prv1
  Qexp(tim2:(tim3-1))=Qexp_prv2
  Qexp(tim3:(tim4-1))=Qexp_prv3
  Qexp(tim4:tim5)=Qexp_prv4
  
!  Qsjr(tim0:(tim1-1))=Qsjr_prv1 !shengjun comment to make smooth input 4/4/2005
!  Qsjr(tim1:(tim2-1))=Qsjr_prv2 
!  Qsjr(tim2:(tim3-1))=Qsjr_prv3
!  Qsjr(tim3:(tim4-1))=Qsjr_prv4
!  Qsjr(tim4:tim5)=Qsjr_prv5
    
  smoothedFlow = ConservativeSpline7Months(Qsjr_prv0,Qsjr_prv1,Qsjr_prv2,Qsjr_prv3,Qsjr_prv4,Qsjr_prv5,Qsjr_prv6, mon0,mon1,mon2,mon3,mon4,mon5,mon6)
  Qsjr(1:tim5)= smoothedFlow(mon0+mon1+mon2+mon3+mon4+mon5-tim5+1:mon0+mon1+mon2+mon3+mon4+mon5)  
  
  Qsac_oth(tim0:(tim1-1))=Qsac_oth_prv0
  Qsac_oth(tim1:(tim2-1))=Qsac_oth_prv1
  Qsac_oth(tim2:(tim3-1))=Qsac_oth_prv2
  Qsac_oth(tim3:(tim4-1))=Qsac_oth_prv3
  Qsac_oth(tim4:tim5) = Qsac_oth_prv4

  Qexp_oth(tim0:(tim1-1))=Qexp_oth_prv0
  Qexp_oth(tim1:(tim2-1))=Qexp_oth_prv1
  Qexp_oth(tim2:(tim3-1))=Qexp_oth_prv2
  Qexp_oth(tim3:(tim4-1))=Qexp_oth_prv3
  Qexp_oth(tim4:tim5)=Qexp_oth_prv4
  
  !start of add by shengjun 2/24/2005
  DICU(tim0:(tim1-1))=DICU_prv0
  DICU(tim1:(tim2-1))=DICU_prv1
  DICU(tim2:(tim3-1))=DICU_prv2
  DICU(tim3:(tim4-1))=DICU_prv3
  DICU(tim4:tim5)=DICU_prv4
  !end of add
  
  !start of add by shengjun 2/15/2005
  SFtideEndIndex= getSFtideArrayEndIndex(mon5,currMonth,currYear)!shengjun 4/17/2005 revised to change "mon4" to "mon5"
  SFtideStartIndex= SFtideEndIndex - tim5 + 1
  currSFtide(tim0:tim5)=SFtide(SFtideStartIndex:SFtideEndIndex)  
  !end of add

  deallocate (smoothedFlow) !4/1/2005
  
  do i=tim0,(tim1-1)              ! last portion of 4th previous month
    if ( i < (dxc_prv0-(mon1-tim1))) then !shengjun changed from "mon0" to "mon1". because mon0 is the first month used for smoothing only 4/17/2005
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  end do
  DO i=tim1,(tim2-1)              ! 3rd previous month
    if ( i-tim1 < dxc_prv1) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  DO i=tim2,(tim3-1)              ! 2nd previous month
    if ( i-tim2 < dxc_prv2) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  DO i=tim3,(tim4-1)              ! previous month
    if ( i-tim3 < dxc_prv3) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO

  DO i=tim4,tim5                  ! current month
    if ( i-tim4 < dxc_prv4) then
      dxc(i) = 1.0 !shengjun changed to make 1 as DXC open 8/2/2004
    else
      dxc(i) = 0.0 !shengjun changed to make 0 as DXC close 8/2/2004
    end if
  END DO
  
  !start of add by Hao 9/2008
  VernEC(tim0:(tim1-1))=VernEC_prv0
  VernEC(tim1:(tim2-1))=VernEC_prv1
  VernEC(tim2:(tim3-1))=VernEC_prv2
  VernEC(tim3:(tim4-1))=VernEC_prv3
  VernEC(tim4:tim5)=VernEC_prv4
  !end of add
    
  !3/23/2006:initialize to record montly input range status
  currMonthInputStatus=inputStatus(.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.)   !9/2008  
    
  outputEC=ANN_Month(Qsac+Qsac_oth,Qexp+Qexp_oth,Qsjr,currSFtide,DICU,DXC,VernEC,location,mon5,ave_type,BeginDay, EndDay)!shengjun revised 4/17/2005 to change "mon4" to "mon5" and Hao 9/2008
  
  if(debugFlag == 1 .and. location==2 .and. ave_type==1) then  
    print*,"Information in AnnEC_matchDSM2():"
    print*,"month, water year:",currMonth,currYear
    print*,"Qsac_smooth=",Qsac(1:tim5)  !4/13/2005
    print*,"Qsjr_smooth=",Qsjr(1:tim5)  !4/13/2005
    print*,"dxc=",dxc(1:tim5)  !4/21/2005
    print*,"Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4:",Qsac_oth_prv0,Qsac_oth_prv1,Qsac_oth_prv2,Qsac_oth_prv3,Qsac_oth_prv4
    print*,"Qsac0,Qsac1,Qsac2,Qsac3,Qsac4:",Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4    
    print*,"Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4:",Qexp_oth_prv0,Qexp_oth_prv1,Qexp_oth_prv2,Qexp_oth_prv3,Qexp_oth_prv4
    print*,"Qexp0,Qexp1,Qexp2,Qexp3,Qexp4:",Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4
    print*,"SFtideStartIndex,SFtideEndIndex:",SFtideStartIndex,SFtideEndIndex
    print*,"SFtide=",currSFtide(1:tim5)  !4/13/2005   
    print*,"DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4:",DICU_prv0,DICU_prv1,DICU_prv2,DICU_prv3,DICU_prv4
    print*,"VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4:",VernEC_prv0,VernEC_prv1,VernEC_prv2,VernEC_prv3,VernEC_prv4 !9/2008
    print*,"outputEC at ORRSL: ",outputEC
  end if
        
  if(currMonthInputStatus.OutOfBound) then
    open(17,file="ANN_Info.txt",status="unknown",position="append") !3/23/2006
    
    write(17,'(1x,a,2i6)') "*****input range out of bound at(water year,month):",currYear,currMonth
    
    write(17,'(1x,6(a,a6))')  "Range violation at DXC:",merge(" True", "False", currMonthInputStatus.DXCscaled), &
                              ",Export:",merge(" True", "False", currMonthInputStatus.ExportScaled), &
                              ",Northern flow:",merge(" True", "False", currMonthInputStatus.NorthScaled), &
                              ",SJR:",merge(" True", "False", currMonthInputStatus.SouthScaled), &
                              ",SF tide:",merge(" True", "False", currMonthInputStatus.SFtideScaled), &
                              ",DICU:",merge(" True", "False", currMonthInputStatus.DICUscaled), &
                              ",Vernalis EC:",merge(" True", "False", currMonthInputStatus.VernECscaled) !9/2008
    
    close(17)
    
  end if    
  
END function AnnEC_matchDSM2

!shengjun 8/23/2005:
function DailyEC(sac,sjr,export,currSFtide,DICU,dxc,VernEC,location) result (outputVal)
    use ann
    implicit none
    
    real, dimension(118), intent(in) :: sac,sjr,export,dxc,currSFtide,DICU,VernEC
    integer, intent(in) :: location
    real :: outputVal
        
    outputVal = calcdaily(sac,sjr,export,currSFtide,DICU,dxc,VernEC,location)
    
end function DailyEC

