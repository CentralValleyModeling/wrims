subroutine dss_read_hourly_specify_nvals_                         &
                           (values_k,                             &
                            infilenames_dss,                      &
                            Ap,Bp,Cp,Ep,Fp,                       & 
                            date_begin, time_begin, nvals_to_read)
    
  use string_utility
  use misc
  use parameters
  
  implicit none  

  character(130), dimension(1), intent(in) :: infilenames_dss
  character(32), intent(in) ::  Ap,Bp,Cp,Ep,Fp 
  integer, intent(in)  ::      nvals_to_read
  character(10), intent(in) :: date_begin, time_begin

  real(4), dimension(nvals_to_read), intent(out) :: values_k     ! data values
  
  integer, dimension(nvals_to_read)              :: data_flags   ! 32-bit data flags
  
  character(10) :: per_type         ! type of DSS data: PER-AVER or INST-VAL [OUTPUT]

  character(8) :: cunits

  logical ::  lflags  &            ! true if data flags should be retrieved
             ,lfread               ! true if data flags were retrieved

  integer :: kheadu  &            ! number of headers to retrieve
            ,nheadu  &            ! number of headers actually retrieved
            ,iofset  &            ! time offset in minutes
            ,icomp   &            ! compression method
            ,istat


  real(4) :: headu               ! data headers

  data   lflags /.true./  &    ! get data flags
        ,kheadu /0/      &     ! don't get data headers
        ,icomp /-1/            ! no compression


  integer :: jule, IYMDJL
  character(10) :: normaldate
  integer(8)    :: dummy_val,begin_ind,end_ind ,i_count, &
                   number_data_retrive
  
  integer, dimension(600) :: ifltab_in_dss           ! DSS table for each input file
  integer :: IYR, IMON, IDAY, IERR
  integer :: nloop 
  
  character(80)             :: pathnames_dss 

  pathnames_dss = "/"//trim(Ap)//"/"//trim(Bp)//"/"//trim(Cp)//"//"//trim(Ep)//"/"//trim(Fp)//"/"  
  


              
!       LOGICAL LEXTND, LSELCA, LCDCAT, LTONLY, LERR
 
!       LEXTND = .true.
!       LSELCA= .true.
!       LCDCAT= .true.



         !infilenames_dss(1) = '..\..\files\historical.dss'

  call zopen (ifltab_in_dss, infilenames_dss(1), istat)

         !pathnames_dss = '/HYDRO8.0B6/RSAN007/STAGE//1HOUR/HISTORICAL/'


         
!         call zchkpn(trim(pathnames_dss),
!     &         len_trim(pathnames_dss),istat)

         !print *, pathnames_dss, len(pathnames_dss)         


         
    call DATYMD (date_begin, IYR, IMON, IDAY, IERR) ! returns  IYR, IMON, IDAY
    JULE = IYMDJL(IYR, IMON, IDAY) 
       


!    if (nvals_to_read < READS_PER_LOOP) then
!             
!        call JULDAT( JULE, 4, normaldate, dummy_val) 
!          
!        begin_ind = 1
!        end_ind   = nvals_to_read
!         
!        istat = -1
!        number_data_retrive = nvals_to_read
!        
!        call zrrtsx(ifltab_in_dss,pathnames_dss,                                 &
!                    normaldate, time_begin, number_data_retrive,                 &
!                    values_k(begin_ind:end_ind), data_flags(begin_ind:end_ind),  & 
!                    lflags, lfread, &
!                    cunits, per_type, headu, &
!                    kheadu, nheadu, iofset, icomp, istat)
!        if (istat > 0) then
!          write(*,*) "zrrtsx error, istat = ", istat
!          pause
!          call exit()
!        end if
          


    !else
      nloop = ceiling(real(nvals_to_read)/READS_PER_LOOP)
      do i_count =1, nloop
         
        call JULDAT( JULE, 4, normaldate, dummy_val) 
          
        begin_ind = 1+(i_count-1)*reads_per_loop
        end_ind   = min(i_count*READS_PER_LOOP,nvals_to_read) 
                 
         
        istat = -1
        number_data_retrive = READS_PER_LOOP
        
        call zrrtsx(ifltab_in_dss,pathnames_dss,                                 &
                    normaldate, time_begin, number_data_retrive,                 &
                    values_k(begin_ind:end_ind), data_flags(begin_ind:end_ind),  & 
                    lflags, lfread, &
                    cunits, per_type, headu, &
                    kheadu, nheadu, iofset, icomp, istat)
        if (istat > 0) then
          write(*,*) "zrrtsx error, istat = ", istat
          pause
          call exit()
        end if
       
        jule = jule + READS_PER_LOOP/HOURS_PER_DAY
       
      enddo
    
    !end if
    
    continue


end subroutine













