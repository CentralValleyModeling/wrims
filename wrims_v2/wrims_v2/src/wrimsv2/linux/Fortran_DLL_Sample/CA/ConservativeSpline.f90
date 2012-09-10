!========= Splines are adapted from routines in Spath (1995) 
!===========One Dimensional Spline Interpolation Algorithms
!**** converted by Shengjun Wu from Eli's ConservativeSpline() used in DSM2

function ConservativeSpline(monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5, &
                              daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5) result (smoothedOutput)
! smooth 5 monthly input to daily
    implicit none
	  integer n, NoOfDays
	  integer,INTENT(IN) ::  daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5
	  REAL,INTENT(IN)    ::  monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5
	  parameter (n = 6)!make 1 more dimention so that the most recent month can be smoothed with
	  real*8 x(n),y(n),y1(n),p(n),q(n),a(n),b(n),c(n),d(n),e(n)
	  real*8 eps,y0, rh2val
	  real*8, allocatable :: xnew(:),ynew(:)
	  real, allocatable :: smoothedOutput(:)	  
	  integer i,iflag  
    
    NoOfDays=daysInMonth1+daysInMonth2+daysInMonth3+daysInMonth4+daysInMonth5    

    allocate (xnew(NoOfDays),ynew(NoOfDays), smoothedOutput(NoOfDays))
        
    x(1)=1
    x(2)=daysInMonth1+x(1)-1
    x(3)=daysInMonth2+x(2)
    x(4)=daysInMonth3+x(3)
    x(5)=daysInMonth4+x(4)
    x(6)=daysInMonth5+x(5)
    
    y(1)=monthlyInput1
    y(2)=monthlyInput2
    y(3)=monthlyInput3
    y(4)=monthlyInput4
    y(5)=monthlyInput5
        
    p=20
	  !p(2)=40 !shengjun comment because it is not used
	  
	  q=p
	  eps = 1.D-10

  	y1(1)= y(1) !shengjun add to make y1= the first of y 3/21/2005 to match the Java code used in DSM2
  	    
    y1(n)= y(n) !shengjun add to make y1(n) = the last of y 3/21/2005: to match Java in DSM2
    
!    write(*,*) 'y1(1), y1(n)=',y1(1), y1(n) 
	  
	  call RatHistSplineBound(n,x,y,p,q,a,b,c,d,y1,e,eps,iflag,50.D0,1.D-3) 

    do i=1,NoOfDays
	    xnew(i)=dble(i)
	    ynew(i)=rh2val(n,x,p,q,a,b,c,xnew(i),iflag)
	    smoothedOutput(i)= ynew(i)
	  end do

!    open(17,file="D:\Wu\CART\ANN-FORTRAN\ANN test\ANNtest_6Input_smooth\bin\Debug\out.txt")
!    do i=1,NoOfDays
!	     write(17,'(2f15.3)')xnew(i),ynew(i)
!    end do
!    close(17)
    
    deallocate (xnew, ynew)
    
  end function ConservativeSpline

function ConservativeSpline7Months(monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5,monthlyInput6,monthlyInput7, &
         daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5,daysInMonth6,daysInMonth7) result (smoothedOutput)
    ! smooth 7 monthly input to daily
    implicit none
	  integer n, NoOfDays
	  integer,INTENT(IN) ::  daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5,daysInMonth6,daysInMonth7
	  REAL,INTENT(IN)    ::  monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5,monthlyInput6,monthlyInput7
	  parameter (n = 8)!make 1 more dimention so that the most recent month can be smoothed with
	  real*8 x(n),y(n),y1(n),p(n),q(n),a(n),b(n),c(n),d(n),e(n)
	  real*8 eps,y0, rh2val
	  real*8, allocatable :: xnew(:),ynew(:)
	  real, allocatable :: smoothedOutput(:)	  
	  integer i,iflag         
    
    NoOfDays=daysInMonth1+daysInMonth2+daysInMonth3+daysInMonth4+daysInMonth5+daysInMonth6+daysInMonth7
   
!    print*,"days in months:",daysInMonth1,daysInMonth2,daysInMonth3,daysInMonth4,daysInMonth5,daysInMonth6,daysInMonth7
 !   print*,"monthly inputs:", monthlyInput1,monthlyInput2,monthlyInput3,monthlyInput4,monthlyInput5,monthlyInput6,monthlyInput7
  !  print*,"NoOfDays:",NoOfDays
    
    allocate (xnew(NoOfDays),ynew(NoOfDays), smoothedOutput(NoOfDays))
        
    x(1)=1
    x(2)=daysInMonth1+x(1)-1
    x(3)=daysInMonth2+x(2)
    x(4)=daysInMonth3+x(3)
    x(5)=daysInMonth4+x(4)
    x(6)=daysInMonth5+x(5)
    x(7)=daysInMonth6+x(6)
    x(8)=daysInMonth7+x(7)
    
    y(1)=monthlyInput1
    y(2)=monthlyInput2
    y(3)=monthlyInput3
    y(4)=monthlyInput4
    y(5)=monthlyInput5
    y(6)=monthlyInput6
    y(7)=monthlyInput7
        
    p=20
	  !p(2)=40 !shengjun comment because it is not used
	  
	  q=p
	  eps = 1.D-10

  	y1(1)= y(1) !shengjun add to make y1= the first of y 3/21/2005 to match the Java code used in DSM2  	    
    y1(n)= y(n) !shengjun add to make y1(n) = the last of y 3/21/2005: to match Java in DSM2
    
!   write(*,*) 'y1(1), y1(n)=',y1(1), y1(n) 

	  call RatHistSplineBound(n,x,y,p,q,a,b,c,d,y1,e,eps,iflag,50.D0,1.D-3) 

    do i=1,NoOfDays
	    xnew(i)=dble(i)
	    ynew(i)=rh2val(n,x,p,q,a,b,c,xnew(i),iflag)
	    smoothedOutput(i)= ynew(i)
	  end do
    
!    open(17,file="D:\Wu\CART\ANN-FORTRAN\ANN\ANN2020DICU_6inp_smooth\AnnCalsim\bin\Debug\out.txt")
 !   do i=1,NoOfDays
	!     write(17,'(2f15.3)')xnew(i),ynew(i)
   ! end do
    !close(17)
    
    deallocate (xnew, ynew)    
    
  end function ConservativeSpline7Months
  
	subroutine RationHistSpline2(n,x,y,p,q,a,b,c,d,y1,e,eps,iflag)
      implicit none
	    integer n             ! dimension of data
	    real*8 x(n)           ! abscissas x1 < x2 <... <xn
	    real*8 y(n)           ! aggregated data
	    real*8 y1(n)
	    real*8 p(n),q(n)      ! parameters > -1
      real*8 a(n),b(n),c(n) ! coefficients of rational histospline
      real*8 d(n),e(n)      ! workspace 
	    real*8 eps            ! accuracy test criterion
	    integer iflag         ! return status
	                          ! =0: normal
	                          ! =1: n>=3 required
	                          ! =2: Error in solving the linear system (TRIDIU)
	                          ! =3: Bounds violation
	                          ! =12: p(k) > -1 violated

      integer k,k1,n1
      real*8 h
	    
	    iflag=0
	    
	    if (n.lt.3) then
	      iflag=1
	      return
	    endif

	    e(1) = 0    	
    	
	    do k=1,(n-1)
	      k1=k+1
	      e(k1)=e(k)+(x(k1)-x(k))*y(k)
	    end do

	    call RationalSpline1(n,x,e,p,q,a,b,c,d,y1,eps,iflag)
    	
	    if (iflag .ne. 0) return

	    do k=1,(n-1)
	      h=1./(x(k+1)-x(k))
	      a(k)= h*(b(k)-a(k))
	      b(k)= h*c(k)
	      c(k)=-h*d(k)
	    end do

      return 
	end subroutine

!     RatHistSplineBound
!     this is a wrapper around RHistSpline2 where the data has a 
!     lower bound. In piecewise intervals the data are treated
!     as follows: 
!     1. If the input data lie above lbound for the interval,
!      the spline will be forced (using parameters p and q)
!      to lie above the bound
!     2. If the input data lie along lbound (within a distance 
!     tolbound), the spline will be a flat line on lbound.
!     3. If the input data lie more than a distance tolbound below
!      lbound, an error occurs and the routine aborts.

	subroutine RatHistSplineBound(n,x,y,p,q,a,b,c,d,y1,e,eps,iflag,lbound,tolbound)
    implicit none
	  integer n             ! dimension of data
	  real*8 x(n)           ! abscissas x1 < x2 <... <xn
	  real*8 y(n)           ! aggregated data
	  real*8 y1(n)
	  real*8 p(n),q(n)      ! parameters > -1
    real*8 a(n),b(n),c(n) ! coefficients of rational histospline
    real*8 d(n),e(n)      ! workspace 
	  real*8 eps            ! accuracy test criterion
	  integer iflag         ! return status
	                        ! =0: normal
	                        ! =1: n>=3 required
	                        ! =2: Error in solving the linear system (TRIDIU)
                 	        ! =3: Bounds violation
	                        ! =12: p(k) > -1 violated
	  real*8 lbound
	  real*8 :: tolbound

  ! locals
    logical acceptSpline
 	  integer mm,nn
	  real*8 y0,yn
  	     
    mm=0
	  y0=y(1)
	  yn=y(n)

    do while (mm .lt. (n-1))
	    mm = mm+1
      if ( (lbound - y(mm)) .gt. tolbound) then
	        ! data violates user bounds
	        iflag = 3
	        return
	    end if
      
      if ( abs(y(mm) - lbound) .lt. tolbound) then
	    ! data lies on user bounds, only solution 
	    ! is a flat line
          a(mm) = lbound
          b(mm) = 0.D0
          c(mm) = 0.D0
	        y0 = lbound
      else
        nn = mm

	    ! delineate the interval where data is above bounds

        do while ( y(nn) .gt. (lbound+tolbound) .and. nn .le. (n-1))
			    nn=nn+1
	      end do
	      
	      nn=nn-1

	      if(nn .eq. (n-1) .and. y(n-1) .gt. (lbound + tolbound))then
	        yn = y(n-1)
	      else
	        yn = lbound
	      end if
	      
	      !print *,nn, y(n-1) shengjun comment 4/13/2005
	      ! apply spline
	      
	      acceptSpline=.false.

	      y1(mm)= y0
	      y1(nn+1)=yn
!	      print*,nn,mm,nn-mm+2 shengjun comment 4/13/2005
!	      print*,"x(mm):", x(mm)," y1(nn): ",yn shengjun comment 4/13/2005
        do while (.not. acceptSpline)
	        call RationHistSpline2(nn-mm+2,x(mm),y(mm),p(mm),q(mm),a(mm),b(mm),c(mm),d,y1(mm),e,eps,iflag)
	        !call checkSpline(nn-mm+2,x(mm),y(mm),p(mm),q(mm),a(mm),b(mm),c(mm),d,y1(mm),e,eps,acceptSpline) shengjun comment out 4/13/2005: not used in DSM2 used Java version of conversertiveSpline()
	        acceptSpline=.true.!shengjun add for testing 3/21/2005
	      end do
	      mm=nn
	    end if    
	  end do
    return
	end subroutine


! RationalSpline1
! based on routine RATSP1 in Spath (1995)
  subroutine RationalSpline1(n,x,y,p,q,a,b,c,d,y1,eps,iflag)
	    implicit none
	    integer n,n1,n2,k,kp1,km1,k1
      real*8 x(n),y(n),a(n),b(n),c(n),y1(n),eps,p(n),q(n),d(n)
	    real*8 e1,y11,y1N,pk2,pk21,pk22,pk,qk2,qk,p22,p21,h,q22,g2,r2,g1,r1,qk1,z,p2,q2
	    integer iflag

	    if (n .lt. 3) then 
	      iflag = 1
        return
	    end if
	    e1=eps-1.D0

	    n1=n-1
	    n2=n-2

	    y11=y1(1)
	    y1N=y1(N)

      do k=1,n1
	      kp1=k+1
	      km1=k-1
	      pk=p(k)
	      qk=q(k)
	      if (pk .lt. e1 .or. qk .lt. e1) then
	        iflag=12
	        return
	      end if
	      pk2=pk*(pk+3.)+3.
	      qk2=qk*(qk+3.)+3.
	      p22=2.+pk
	      q22=2.+qk
            
        h= 1.D0/(X(kp1) - x(k))
	      a(k)=1./(p22*q22-1.)
	      g2=h*a(k)

	      r2=h*g2*(y(kp1)-y(k))
	      if (k .ne. 1) then
          b(km1)=qk2*g2
	        c(km1)=qk1*p21*g1 + pk2*q22*g2
	        d(km1)=pk2*g2

	        y1(km1)=r1*qk1*(1.+p21) + r2*pk2*(1.+q22)

	        if (k .eq. 2)  y1(km1) = y1(km1) - qk1*g1*y11
	        if (k .eq. n1) y1(km1)=  y1(km1) - pk2*g2*y1N
	      end if
	      
10      p21=p22
	      qk1=qk2
	      g1=g2
	      r1=r2
20    end do
          
      call tridiu(n2,b,c,d,y1,eps,iflag)

	    do k=N2,1,-1
	      y1(k+1)=y1(k)
	    end do

      y1(1)=y11
	    y1(n)=y1n
	    
	    do k=1,n1
	      k1=k+1
	      h=a(k)*(y(k1)-y(k))
	      z=a(k)*(x(k1)-x(k))
	      p2=2.+p(k)
	      q2=2.+q(k)
	      d(k)=-(1.+p2)*h+z*(p2*y1(k1)+y1(k))
	      c(k)=(1.+q2)*h-z*(y1(k1)+q2*y1(k))
	      b(k)=y(k1)-d(k)
	      a(k)=y(k)-c(k)
	    end do
	    
      return
	end subroutine

  subroutine tridiu(n,a,b,c,d,eps,iflag)
	  implicit none
	  integer n,k
	  real*8 a(n),b(n),c(n),d(n)
	  real*8 h1,h2,h3,z,eps
	  integer iflag
	  h1=0.
	  h2=0.
	  h3=0.
	  do k=1,n
      z=b(k)-h3*h1
	    if(abs(z).lt.eps)then
	      iflag=2
	      return
	    end if
	    h1=c(k)/z
	    c(k)=h1
	    h2=(d(k)-h3*h2)/z
	    b(k)=h2
	    h3=a(k)
	  end do
    d(n)=b(n)
	  
	  do k=n-1,1,-1
	    d(k)=b(k)-c(k)*d(k+1)
	  end do
    return
	end subroutine


  real*8 function rh2val(n,x,p,q,a,b,c,v,iflag)
    implicit none
	  integer n,iflag
	  real*8 x(n),p(n),q(n),a(n),b(n),c(n)
	  real*8 v,t,u,h1,h2
    integer :: i=1
	  save i
	  iflag=0
	  if (n .lt. 3) then 
	    iflag=1
	    rh2Val=1.e38 !shengjun add 3/17/2005 for exception
	    return
	  end if
	  call intone(x,n,v,i,iflag)
	  if (iflag .ne. 0) return
	  t= (v-x(i)) / (x(i+1) - x(i))
	  u=1.- t
	  h1=p(i)*t+1.
	  h2=q(i)*u+1.
	  rh2val= a(i) + b(i)*u*u*(2*p(i)*u-3.*(1.+p(i)))/(h1*h1) + c(i)*t*t*(2.*q(i)*t-3.*(1.+q(i)))/(h2*h2)
	
  end function

  subroutine intone(x,n,v,i,iflag)
	  implicit none
	  integer iflag,i,n, l,k
	  real*8 x(n),v
        
	  if (i .ge. n) i=1

	  if (v .lt. x(1) .or. v.gt. x(n)) then
	    iflag=3
	    return
    end if
        
	  if (v .ge. x(i)) then
      if (v .le. x(i+1) ) return   ! changed from lt
	    l=n
	  else
	    l=i
	    i=1
	  end if

	  do while (l .gt. i+1)
      k=(i+l)/2
	    if (v.lt.x(k))then
	      l=k
	    else
	      i=k
	    end if
	  end do

	  return
  end

