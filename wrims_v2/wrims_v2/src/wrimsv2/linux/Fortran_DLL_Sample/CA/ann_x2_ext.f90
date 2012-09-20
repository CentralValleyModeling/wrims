! Last change: HX Nov, 2008
function ANN_X2_Month(Qsac,Qexp,currSFtide,location,days,ave_type,BeginDay, EndDay) result(outval)
!
! ANN_X2_Month provides interaction between the monthly data and the daily data
! through various averaging techniques (monthly averag, 14-day average, daily max, etc.).
! ave_type = 1: monthly average
!            2: first day of month value
!            3: last day of month value
!            4: maximum daily value
!            5: minimum daily vlaue
!            6: maximum 14-day value
!            7: average for first 15 days
!            8: average for last 15 days
!           10: average between specified range (BeginDay- EndDay, counting from the beginning of the month) 7/11/2007!
! BeginDay, EndDay: Day ID counting from the beginning of the month
!
  use ann
  implicit none
  !dll_export ANN_X2_Month
  real, dimension(148), intent(inout) :: Qsac,Qexp, currSFtide
  integer, intent(inout)  :: location,days,ave_type
  real :: sum,num
  real, dimension(31) :: day
  real :: outval
  integer :: i,base, offset, j 
  integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10    
  
! also to adjust for the number of days in a month
  base = 148-days

!  to adjust for the number of days in a month
  offset = 31-days   

! attempting to pass into calcx2daily 118 previous values from each day in the month.

  sum = 0.0
  num = 0.0
  
  !shengjun comment 4/22/2005
!  do i=1+offset,days+offset      
 !   sum = calcx2daily(Qsac(i:i+base-offset),Qsjr(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),DICU(i:i+base-offset),DXC(i:i+base-offset),location)!shengjun 12/16/2004
  !end do
  
  !3/23/2006:initialize to record montly input range status
  currMonthInputStatus=inputStatus(.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.,.FALSE.)     
  
  if(ave_type == 1) then
    ! monthly average
    sum = 0.
    do i=1+offset,days+offset
      !sum = sum
      sum = sum + calcx2daily(Qsac(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),location)!shengjun 12/16/2004
      
!      if(location .eq. 2) then for debuging
 !       write(*,*) 'day ID and EC',i, calcx2daily(Qsac(i:i+base-offset),Qsjr(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),DICU(i:i+base-offset),DXC(i:i+base-offset),location)
  !    end if
      
    end do
    sum = sum/real(days)
  
  else if(ave_type == 2) then
    ! first day value
    sum = 0.
    sum = calcx2daily(Qsac(1+offset:1+base),Qexp(1+offset:1+base),currSFtide(1+offset:1+base),location) !12/15/2004
  
  else if(ave_type == 3) then
    ! last day value
    sum = 0.
    sum = calcx2daily(Qsac(31:148),Qexp(31:148),currSFtide(31:148),location)!shengjun 12/16/2004
  
  else if(ave_type == 4) then
    ! maximum daily value   
    sum = 0.
    do i=1+offset,days+offset
      !lkfjgldjflsakjfllk
      num = calcx2daily(Qsac(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),location)
      sum = max(sum,num)
    end do
  
  else if(ave_type == 5) then
    ! minimum daily value
    sum = 99999.9
    do i=1+offset,days+offset
      !lkfjgldjflsakjfllk
      num = calcx2daily(Qsac(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),location)!shengjun 12/16/2004
      sum = min(sum,num)
    end do
  
  else if(ave_type == 6) then
    ! max 14-day average
    sum = 0.
    j = 0
    do i=1+offset,days+offset
      j = j + 1
      day(j) = calcx2daily(Qsac(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),location)!shengjun 12/16/2004
    end do
    do i=1,j-13
      num = (day(i)+day(i+1)+day(i+2)+day(i+3)+day(i+4)+day(i+5)+day(i+6)+&
             day(i+7)+day(i+8)+day(i+9)+day(i+10)+day(i+11)+day(i+12)+day(i+13))/14.
      sum = max(sum,num)
    end do
  
  else if(ave_type == 7) then
    ! average for first 15 days
    sum = 0.
    j = 0
    do i=1+offset,15+offset
      !sum = sum
      j = j+1
      num = calcx2daily(Qsac(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),location)!shengjun 12/16/2004
      sum = sum + num
      !WRITE(*,*) 'j=',j,' day=',num
    end do
    sum = sum/15.0
    !WRITE(*,*) 'sum=',sum
  
  else if(ave_type == 8) then
    ! average for last 15 days
    sum = 0.
    j = 0
    do i=days-14+offset,days+offset
      !sum = sum
      j = j + 1
      num = calcx2daily(Qsac(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),location)!shengjun 12/16/2004
      sum = sum + num
      !WRITE(*,*) 'j=',j,' day=',num
    end do
    sum = sum/15.0
    !WRITE(*,*) 'sum=',sum

  else if(ave_type == 10) then !shengjun 7/11/07
    ! average between BeginDay, EndDay
    if (BeginDay<1 .or. BeginDay >31 .or. BeginDay> EndDay .or. EndDay > 31 .or. Endday <1) then
        print *, "wrong begining and ending days in the month are specified. BeginDay and EndDay:", BeginDay,Endday
        stop
    end if    
      
    sum = 0.
    j = 0
    do i=BeginDay+offset,EndDay+offset      
        
      !sum = sum
      j = j + 1
      num = calcx2daily(Qsac(i:i+base-offset),Qexp(i:i+base-offset),currSFtide(i:i+base-offset),location)!shengjun 12/16/2004
      
      !print *, "day#,x2:", j, num !4/27/08
      sum = sum + num
      !WRITE(*,*) 'j=',j,' day=',num
    end do
    
    sum = sum/(EndDay-BeginDay+1)
    !WRITE(*,*) 'sum=',sum
    !print *, "average x2 between defined period:", sum !4/27/08
  
  end if
  
  outval = sum
      
!  if(currMonthInputStatus.OutOfBound) then
 !   open(17,file="ANN_Info.txt",status="unknown",position="append") !3/23/2006
  !  write(17,'(1x,a,2i6)') "input range out of ANN training range at location and days in a month:",location, days
    
!    write(17,'(1x,6(a,a6))')  "Range violation at DXC:",merge(" True", "False", currMonthInputStatus.DXCscaled), &
 !                             ",Export:",merge(" True", "False", currMonthInputStatus.ExportScaled), &
  !                            ",Northern flow:",merge(" True", "False", currMonthInputStatus.NorthScaled), &
   !                           ",SJR:",merge(" True", "False", currMonthInputStatus.SouthScaled), &
    !                          ",SF tide:",merge(" True", "False", currMonthInputStatus.SFtideScaled), &
     !                         ",DICU:",merge(" True", "False", currMonthInputStatus.DICUscaled)
      !                        ",Vernalis EC:",merge(" True", "False", currMonthInputStatus.VernECscaled)
!    close(17)
 ! end if
  
end function ANN_X2_Month

