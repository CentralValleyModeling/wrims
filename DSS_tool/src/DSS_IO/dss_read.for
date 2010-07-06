! read dss files
      subroutine dss_read(istat, CDATE, CTIME, nvals_dss, 
     &       values_k,infilenames_dss,pathnames_dss)



      implicit none

!kevin test
!=====================================================
      character per_type*10         ! type of DSS data: PER-AVER or INST-VAL [OUTPUT]

      character
     &     cunits*8

      logical
     &     lflags               ! true if data flags should be retrieved
     &     ,lfread              ! true if data flags were retrieved

      integer
     &      kheadu              ! number of headers to retrieve
     &     ,nheadu              ! number of headers actually retrieved
     &     ,iofset              ! time offset in minutes
     &     ,icomp               ! compression method

      integer*4
     &     flags(999)   ! 32-bit data flags

      real*4 headu               ! data headers

      data lflags /.true./      ! get data flags
     &     ,kheadu /0/          ! don't get data headers
     &     ,icomp /-1/          ! no compression



      !!!Kevin test
      character,intent(in):: CDATE*10, CTIME*10
!      character*20 Ap,Bp,Cp,Ep,Fp
      real*4, dimension(9000), intent(out) :: values_k ! data values

      character*130,dimension(1) :: infilenames_dss
      character*80,intent(IN) :: pathnames_dss 
      integer,intent(in)::     nvals_dss
            integer*4 jule,IYMDJL
      character*10 normaldate
      integer dummy,begin_ind,end_ind ,i_count,nvals_s
      integer*4,dimension(600) :: ifltab_in_dss           ! DSS table for each input file

      integer*4 IYR, IMON, IDAY, IERR,istat
              
!       LOGICAL LEXTND, LSELCA, LCDCAT, LTONLY, LERR
 
!       LEXTND = .true.
!       LSELCA= .true.
!       LCDCAT= .true.

 !==================================================
! test Kevin
         !infilenames_dss(1) = '..\..\files\historical.dss'

         call zopen (ifltab_in_dss, infilenames_dss(1), istat)
!kevin test
         !pathnames_dss = '/HYDRO8.0B6/RSAN007/STAGE//1HOUR/HISTORICAL/'


         
!         call zchkpn(trim(pathnames_dss),
!     &         len_trim(pathnames_dss),istat)

         !print *, pathnames_dss, len(pathnames_dss)         


         
       call DATYMD (CDATE, IYR, IMON, IDAY, IERR)
       JULE = IYMDJL(IYR, IMON, IDAY) 
       
       nvals_s = 24

       do i_count =1, nvals_dss/nvals_s
         
       call JULDAT( JULE, 4, normaldate, dummy) 
          
       begin_ind = 1+(i_count-1)*nvals_s
       end_ind   = i_count*nvals_s
                 
         
         istat = -1
         call zrrtsx(ifltab_in_dss,pathnames_dss, normaldate 
     &    , ctime,
     &        nvals_s, values_k(begin_ind:end_ind), flags, lflags, lfread, 
     &        cunits, per_type, headu,
     &        kheadu, nheadu, iofset, icomp, istat)

       
       jule = jule + nvals_s/24
       
       enddo   
     
     
         continue
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


      end













