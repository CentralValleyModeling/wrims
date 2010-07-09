      PROGRAM DSS_IO
      
      !use MatData
      use dss_utility

      IMPLICIT NONE

! test Kevin
      integer*4 nvals_to_read
      real*4    values_dss(9000) ! data values
      character date_begin*10, time_begin*10
      character*32 Ap,Bp,Cp,Ep,Fp
      
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
         read(1, *) date_begin, time_begin
         read(1, *)
         read(1, *) nvals_to_read
         read(1, *) 
         read(1, *) file_out
         
         open(unit = 2, file = file_out)  
                                  


 
       

          
       call dss_read(values_dss,                        
     &                infilenames_dss, Ap,Bp,Cp,Ep,Fp,   
     &                date_begin, time_begin, nvals_to_read)

       
     
       !call matwrite(trim(file_out)//".mat",trim(file_out),values_dss(1:nvals_to_read),'w') 
       
       write(2,"(f8.4)") values_dss(1:nvals_to_read)
       
       write(*,"(f8.4)") values_dss(1:nvals_to_read)
       
       call dss_write(date_begin, time_begin, nvals_to_read, values_dss)

       pause
      END

