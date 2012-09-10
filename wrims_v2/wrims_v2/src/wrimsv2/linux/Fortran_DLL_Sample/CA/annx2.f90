! Last change: HX Nov 4,2008

! Function provides access to the ANN code and returns X2 given a history of flow values.

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

FUNCTION AnnX2( &
     Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,&
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,&   
     mon0,mon1,mon2,mon3,mon4,location,ave_type,currMonth,currYear,BeginDay, EndDay)  RESULT (outputX2) ! 2/14/2005
  !use ann_ext
       
  use SFtideModule ! 2/14/2005

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
  
  REAL ::  ANN_X2_Month
  integer :: initall
  ! input and output of the function
  ! DXC=0,CLOSED  DXC=1,OPEN
  REAL,INTENT(IN)    :: &
       Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,&
       Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4       
  
  integer, INTENT(IN) :: currMonth, currYear ! 2/14/2005
  integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
  
  INTEGER :: location,mon0,mon1,mon2,mon3,mon4,ave_type
  REAL    :: outputX2
  integer :: tim0,tim1,tim2,tim3,tim4,tim5,det_day !Jan 2009
  REAL,DIMENSION(148) :: Qsac,Qexp,currSFtide !Nov 2008
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

  !!! 118 values daily are needed to estimate one daily value of X2
  !!! this function builds the first set of input arrays representing
  !!! dxc position and river inflow.
  !!!
  !!! The arrays have the following structure
  !!! tim0         tim1         tim2         tim3           tim4         tim5
  !!! --------------------------------------------------------------------
  !!! |this month-4|this month-3|this month-2| this month-1 | this month |
  !!! --------------------------------------------------------------------
  
  
  Qexp(tim0:(tim1-1))=Qexp_prv0
  Qexp(tim1:(tim2-1))=Qexp_prv1
  Qexp(tim2:(tim3-1))=Qexp_prv2
  Qexp(tim3:(tim4-1))=Qexp_prv3
  Qexp(tim4:tim5)=Qexp_prv4
  
  !!! The arrays have the following structure for X2(t-1), represented as Qsac 
  !!! tim0         tim1         tim2         tim3           tim4         tim5 current month     
  !!! ---------------------------------------------------------------------------------
  !!! |  mon neg1   |     mon 0   |    mon 1   |      mon 2   |    mon 3    |   mon 4  |
  !!! ---------------------------------------------------------------------------------
  
  det_day=31-mon4
  
  tim5=148                     ! the 31st day before the last day of current month
  tim4=tim5-(mon3-det_day)+1   ! first day of the month for tim5 
  tim3=tim4-mon2               ! 1 month ago from tim4
  tim2=tim3-mon1               ! 2 months ago from tim4
  tim1=tim2-mon0               ! 3 months ago from tim4
  tim0=1                       ! 147 day before tim5
  
  Qsac(tim0:(tim1-1))=Qsac_prv0
  Qsac(tim1:(tim2-1))=Qsac_prv1
  Qsac(tim2:(tim3-1))=Qsac_prv2
  Qsac(tim3:(tim4-1))=Qsac_prv3
  Qsac(tim4:tim5)=Qsac_prv4
  
  !start of add 2/15/2005
  SFtideEndIndex= getSFtideArrayEndIndex(mon4,currMonth,currYear)
  SFtideStartIndex= SFtideEndIndex - tim5 + 1
  currSFtide(tim0:tim5)=SFtide(SFtideStartIndex:SFtideEndIndex)  
  !end of add
  
  deallocate (smoothedFlow) !4/1/2005
               
  outputX2=ANN_X2_Month(Qsac,Qexp,currSFtide,location,mon4,ave_type,BeginDay, EndDay)! revised 12/16/2004     
    
END function AnnX2


!************* start of add by Hao Xie 11/4/2008: new ANNX2_curMonInpSplit
!this function calculates averaged monthly X2 but allows the input for current month
!splitted up to 3 pieces.
FUNCTION ANNX2_curMonInpSplit( &
     Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,&
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,Qexp_prv4_1,Qexp_prv4_2, &
     mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,location,ave_type,currMonth,currYear,BeginDay, EndDay) RESULT (outputX2) 
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
  
  REAL ::  ANN_X2_Month
  integer :: initall
  ! input and output of the function
  ! DXC=0,CLOSED  DXC=1,OPEN
  REAL,INTENT(IN)    ::  &
     Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,&
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,Qexp_prv4_1,Qexp_prv4_2
  
  integer, INTENT(IN) :: currMonth, currYear ! 2/14/2005
  integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
  
  INTEGER,INTENT(IN) :: location,mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type
  REAL    :: outputX2
  integer :: tim0,tim1,tim2,tim3,tim4,tim5,det_day !Jan 2009
  REAL,DIMENSION(148) :: Qsac,Qexp,currSFtide !Nov 2008
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

  ! 118 values daily are needed to estimate one daily value of X2
  ! this function builds the first set of input arrays representing
  ! dxc position and river inflow.
  !
  ! The arrays have the following structure
  ! tim0         tim1         tim2         tim3           tim4         tim5
  ! --------------------------------------------------------------------
  ! |this month-4|this month-3|this month-2| this month-1 | this month |
  ! --------------------------------------------------------------------
  
  Qexp(tim0:(tim1-1))=Qexp_prv0
  Qexp(tim1:(tim2-1))=Qexp_prv1
  Qexp(tim2:(tim3-1))=Qexp_prv2
  Qexp(tim3:(tim4-1))=Qexp_prv3
  Qexp(tim4:tim5)=Qexp_prv4
  if(mon4_1 > 0) Qexp(tim4:(tim4+mon4_1-1))=Qexp_prv4_1    
  if(mon4_2 > 0) Qexp(tim4+mon4_1:(tim4+mon4_1+mon4_2-1))=Qexp_prv4_2

  
  !!! The arrays have the following structure for X2(t-1), represented as Qsac 
  !!! tim0         tim1         tim2         tim3           tim4         tim5 current month     
  !!! ---------------------------------------------------------------------------------
  !!! |  mon neg1   |     mon 0   |    mon 1   |      mon 2   |    mon 3    |   mon 4  |
  !!! ---------------------------------------------------------------------------------
  
  det_day=31-mon4
  
  tim5=148                     ! the 31st day before the last day of current month
  tim4=tim5-(mon3-det_day)+1   ! first day of the month for tim5 
  tim3=tim4-mon2               ! 1 month ago from tim4
  tim2=tim3-mon1               ! 2 months ago from tim4
  tim1=tim2-mon0               ! 3 months ago from tim4
  tim0=1                       ! 147 day before tim5
  
  Qsac(tim0:(tim1-1))=Qsac_prv0
  Qsac(tim1:(tim2-1))=Qsac_prv1
  Qsac(tim2:(tim3-1))=Qsac_prv2
  Qsac(tim3:(tim4-1))=Qsac_prv3
  Qsac(tim4:tim5)=Qsac_prv4
    
  !start of add 2/15/2005
  SFtideEndIndex= getSFtideArrayEndIndex(mon4,currMonth,currYear)
  SFtideStartIndex= SFtideEndIndex - tim5 + 1
  currSFtide(tim0:tim5)=SFtide(SFtideStartIndex:SFtideEndIndex)  
  !end of add
  
  deallocate (smoothedFlow) !4/1/2005
               
  outputX2=ANN_X2_Month(Qsac,Qexp,currSFtide,location,mon4,ave_type,BeginDay, EndDay)! revised 12/16/2004     
    
END function ANNX2_curMonInpSplit

!************** end of add 4/13/08


FUNCTION AnnX2_matchDSM2(&
     Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,&
     Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4,&  
     mon0,mon1,mon2,mon3,mon4,mon5,mon6,location,ave_type,currMonth,currYear,BeginDay, EndDay)  RESULT (outputX2) ! 2/14/2005

  !**** this function uses one month earlier and one month later to smooth Sac flow and SJR flow (comparing with ANNX2() to make a complete smoothing like DSM2)
  !**** the only data used in ANN X2 estimation does not include the first month and the last month (for Sac and SJR flows)
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
  
  REAL ::  ANN_X2_Month
    
  integer :: initall
  ! input and output of the function
  ! DXC=0,CLOSED  DXC=1,OPEN
  REAL,INTENT(IN)  :: &
       Qsac_prv0,Qsac_prv1,Qsac_prv2,Qsac_prv3,Qsac_prv4,&
       Qexp_prv0,Qexp_prv1,Qexp_prv2,Qexp_prv3,Qexp_prv4      
  
  integer, INTENT(IN) :: currMonth, currYear ! 2/14/2005
  integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
  
  INTEGER :: location,mon0,mon1,mon2,mon3,mon4,mon5,mon6,ave_type
  REAL    :: outputX2
  integer :: tim0,tim1,tim2,tim3,tim4,tim5,det_day   !Jan, 2009
  REAL,DIMENSION(148) :: Qsac,Qexp,currSFtide !Nov, 2008
  INTEGER             :: i,SFtideStartIndex,SFtideEndIndex !2/14/2005  
  integer :: getSFtideArrayEndIndex !2/14/2005
  real, allocatable :: smoothedFlow(:) !4/1/2005  
  integer debugFlag ; debugFlag =0
                
  i = initall()
  
  ! modified the following to make sure Month 2 is the start month
  tim5=148          ! last day of current month
  tim4=tim5-mon5+1  ! first day of current month
  tim3=tim4-mon4    ! first day of 1 month ago
  tim2=tim3-mon3    ! first day of 2 months ago
  tim1=tim2-mon2    ! first day of 3 months ago
  tim0=1            ! first day of 118 days before the last day of the current month

  allocate (smoothedFlow(mon0+mon1+mon2+mon3+mon4+mon5+mon6)) ! 4/17/2005

  ! 118 values daily are needed to estimate one daily value of X2
  ! this function builds the first set of input arrays representing
  ! dxc position and river inflow.
  !
  ! The arrays have the following structure
  ! tim0         tim1         tim2         tim3           tim4         tim5
  ! --------------------------------------------------------------------
  ! |this month-4|this month-3|this month-2| this month-1 | this month |
  ! --------------------------------------------------------------------  

  
  Qexp(tim0:(tim1-1))=Qexp_prv0
  Qexp(tim1:(tim2-1))=Qexp_prv1
  Qexp(tim2:(tim3-1))=Qexp_prv2
  Qexp(tim3:(tim4-1))=Qexp_prv3
  Qexp(tim4:tim5)=Qexp_prv4
  
  !!! The arrays have the following structure for X2(t-1), represented as Qsac 
  !!! tim0         tim1         tim2         tim3           tim4         tim5 current month     
  !!! ---------------------------------------------------------------------------------
  !!! |  mon neg1   |     mon 0   |    mon 1   |      mon 2   |    mon 3    |   mon 4  |
  !!! ---------------------------------------------------------------------------------
  
  det_day=31-mon4
  
  tim5=148                     ! the 31st day before the last day of current month
  tim4=tim5-(mon3-det_day)+1   ! first day of the month for tim5 
  tim3=tim4-mon2               ! 1 month ago from tim4
  tim2=tim3-mon1               ! 2 months ago from tim4
  tim1=tim2-mon0               ! 3 months ago from tim4
  tim0=1                       ! 147 day before tim5
  
  Qsac(tim0:(tim1-1))=Qsac_prv0
  Qsac(tim1:(tim2-1))=Qsac_prv1
  Qsac(tim2:(tim3-1))=Qsac_prv2
  Qsac(tim3:(tim4-1))=Qsac_prv3
  Qsac(tim4:tim5)=Qsac_prv4  
  
  !start of add 2/15/2005
  SFtideEndIndex= getSFtideArrayEndIndex(mon5,currMonth,currYear)! 4/17/2005 revised to change "mon4" to "mon5"
  SFtideStartIndex= SFtideEndIndex - tim5 + 1
  currSFtide(tim0:tim5)=SFtide(SFtideStartIndex:SFtideEndIndex)  
  !end of add

  deallocate (smoothedFlow) !4/1/2005
    
  !3/23/2006:initialize to record montly input range status
  currMonthInputStatus=inputStatus(.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.)     
    
  outputX2=ANN_X2_Month(Qsac,Qexp,currSFtide,location,mon5,ave_type,BeginDay, EndDay)! revised 4/17/2005 to change "mon4" to "mon5"
        
  if(currMonthInputStatus.OutOfBound) then
    open(17,file="ANN_Info.txt",status="unknown",position="append") !3/23/2006
    
    write(17,'(1x,a,2i6)') "*****input range out of bound at(water year,month):",currYear,currMonth
    
    write(17,'(1x,6(a,a6))')  "Range violation at Export:",merge(" True", "False", currMonthInputStatus.ExportScaled), &
                              ",X2(t-1)",merge(" True", "False", currMonthInputStatus.NorthScaled), & 
                              ",SF tide:",merge(" True", "False", currMonthInputStatus.SFtideScaled)
    
    close(17)
    
  end if    
  
END function AnnX2_matchDSM2

! 8/23/2005:
function DailyX2(sac,export,currSFtide,location) result (outputVal)
    use ann
    implicit none
    
    real, dimension(118), intent(in) :: sac,export,currSFtide
    integer, intent(in) :: location
    real :: outputVal
        
    outputVal = calcx2daily(sac,export,currSFtide,location)
    
end function DailyX2

