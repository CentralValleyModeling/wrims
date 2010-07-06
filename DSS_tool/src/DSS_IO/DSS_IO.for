      PROGRAM DSS_IO
      
      !use MatData

      IMPLICIT NONE

! test Kevin
      integer*4 nvals_dss
      real*4    values_dss(9000) ! data values
      character CDATE*10, CTIME*10
      character*20 Ap,Bp,Cp,Ep,Fp
      
      character*130,dimension(1) :: infilenames_dss
      character*80 :: pathnames_dss, file_out
      


      integer*4 istat

!      real*8 ::  temp(10,1),threeD(10,10,10)
!
!      temp = 567.
!      threeD = 989
!
!      call matwrite('result2.mat','Temperature',temp,'w') 
!      call matwrite('3D2.mat','threeDimension',threeD,'w') 
      
      

         open(unit = 1, file = "input.txt")

         read(1, *)
         read(1, *) infilenames_dss(1)
         read(1, *)
         read(1, *) Ap,Bp,Cp,Ep,Fp
         read(1, *)
         read(1, *) cdate, ctime
         read(1, *)
         read(1, *) nvals_dss
         read(1, *) 
         read(1, *) file_out
         
         open(unit = 2, file = file_out)  
                                  
         pathnames_dss = "/"//trim(Ap)//"/"//trim(Bp)//"/"//
     &                     trim(Cp)//"//"//trim(Ep)//"/"//trim(Fp)//"/"

 
       

          
       call dss_read(istat, cdate, CTIME, nvals_dss
     &                ,values_dss,infilenames_dss,pathnames_dss)  
       
     
       !call matwrite(trim(file_out)//".mat",trim(file_out),values_dss(1:nvals_dss),'w') 
       
       write(2,"(f8.4)") values_dss(1:nvals_dss)
       
       
       
       call dss_write(CDATE, CTIME, nvals_dss, values_dss)


      END

