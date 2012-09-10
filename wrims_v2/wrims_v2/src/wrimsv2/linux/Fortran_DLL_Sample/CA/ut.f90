module unittype
  type UT
     real :: act
     real :: bias
     integer :: no_of_sources
     integer, pointer, dimension(:) :: sources
     real, pointer, dimension(:) :: weights
  end type UT
contains
function act_logistic(s,b)
  real :: act_logistic
  real, intent(in) :: s
  real, intent(in) :: b
  if ( (s+b) < 10000.0 ) then
     act_logistic = 1.0/(1.0+exp(-s-b))
  else
     act_logistic = 0.0
  end if
end function act_logistic
end module unittype