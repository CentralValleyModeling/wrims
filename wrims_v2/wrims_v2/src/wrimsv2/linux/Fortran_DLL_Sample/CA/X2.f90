!shengjun 7/7/07
FUNCTION ANN_x2(X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
     DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4, &       
     mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,BeginDay,EndDay)  RESULT (outputX2) 
    !flowFromSac: the northern flow but without Sac flow: Yolo-NB-Valleyjo
    !flow_inDelta: SJR+east+Calver
    !DO: delta outflow
                  
    REAL,INTENT(IN)    ::  X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, &
                           DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4

    integer, INTENT(IN) :: currMonth, currYear,mon0,mon1,mon2,mon3,mon4,ave_type
    integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
      
    REAL    :: outputX2 
    
    logical :: debugCode = .false.
  
    outputX2 =  Annx2(  X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, &
                        DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4, &  
                        mon0,mon1,mon2,mon3,mon4,13,ave_type,currMonth,currYear,BeginDay, EndDay) 

    if(debugCode == .TRUE.) then
        print*,"Information X2 function:"
        print*,"month, water year:",currMonth,currYear
        print*,"X2(t-1): ",X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4             
        print*,"DO: ",DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4    
        print*,"***calculated X2: ", outputX2
    end if

END function ANN_x2
!end of add 

FUNCTION getNDO_x2( X2, & 
     X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
     DO_prv0,DO_prv1,DO_prv2,DO_prv3, &  
     mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,BeginDay, EndDay)  RESULT (requiredNDO) 
    !** returning the required current monthly NDO to obtain a desired X2.
    !DO: delta outflow
                  
    REAL,INTENT(IN)    ::  X2, &
            X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
            DO_prv0,DO_prv1,DO_prv2,DO_prv3 

    integer, INTENT(IN) :: currMonth, currYear,mon0,mon1,mon2,mon3,mon4,ave_type
        
    integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
      
    REAL   :: requiredNDO
    
    !logical debugCode = .true.
    
    real InitialDO,tempDO, DO_lo, DO_high, DIFF, X2_TOL, DO_TOL, tempX2, BigDOstep  
    
    InitialDO=20000.0 
    tempDO=0.0 
    DO_lo=0.0
    DO_high=0.0
    DIFF = 0.0
    X2_TOL = 0.1
    DO_TOL= 0.5
    tempX2=0.
    BigDOstep = 10000.0 
     
    tempX2=ANN_x2(  X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
                    DO_prv0,DO_prv1,DO_prv2,DO_prv3,InitialDO , &  
					mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,BeginDay, EndDay) 
    
    !find DO range to have desired X2
    
    tempDO=initialDO
    
    !use big step to search first 
    if(tempX2 > X2) then
        do while (tempX2 > X2) 
            DO_lo= tempDO
!            tempDO = DO_lo+BigDOstep
            tempDO = tempDO+BigDOstep
            DO_high= tempDO
     
           if (DO_high> 99999.9) then  !shengjun add 10/19/07: 99999.9 is the maximum required DO can go
                requiredNDO =  99999.9
                return
           end if
                       
            tempX2=ANN_x2(X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
                    DO_prv0,DO_prv1,DO_prv2,DO_prv3,tempDO , &  
					mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,BeginDay, EndDay)                             
        end do
    else
        do while (tempX2 < X2) 
        
            DO_high= tempDO                        
!            tempDO = DO_high-BigDOstep!shengjun revise 10/19/07
            tempDO = tempDO-BigDOstep!shengjun revise 10/19/07            
            DO_lo= tempDO            

            if (DO_lo < 0.0) then !4/20/08
                tempDO =  0.0
            end if            
              
            tempX2=ANN_x2(  X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
                            DO_prv0,DO_prv1,DO_prv2,DO_prv3,tempDO , &  
                            mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,BeginDay, EndDay)                                   
                            
            if(tempX2 < X2 .and. tempDO<0.1) then !4/20/08
              requiredNDO = 0.
              return
            end if
           
                            
        end do
    end if
    
    !now try to find out correct DO
    DIFF=ABS(X2-tempX2)    
       
    do while(DIFF > X2_TOL .and. (DO_high-DO_lo) > DO_TOL) !shengjun10/19/07: may need to consider no DO can be found for certain X2
        
        tempDO=0.5*(DO_lo+DO_high)

        tempX2=ANN_x2(  X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
                        DO_prv0,DO_prv1,DO_prv2,DO_prv3,tempDO , &  
                        mon0,mon1,mon2,mon3,mon4,ave_type,currMonth,currYear,BeginDay, EndDay)                   
                                       	    	
    	if(tempX2 > X2) then
	        DO_lo= tempDO
	    else
	        DO_high= tempDO
	    end if
		
        DIFF=ABS(X2-tempX2)
    end do
    
    !print *, "DO diff", DO_high-DO_lo 
      
    requiredNDO =  tempDO
   
END function getNDO_x2
!end of add 


!********* start of add by shengjun 4/13/08: 
!this function calculates average monthly X2 but allows the NDO input for the current month
!splitted up to 3 pieces.

FUNCTION ANN_x2_curMonInpSplit( &
     X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
     DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4,DO_prv4_1,DO_prv4_2, &  
     mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type,currMonth,currYear,BeginDay,EndDay)  RESULT (outputX2) 
    !DO: delta outflow
    ! mon4_1 and mon4_2 are the number of days in mon4 which the input of Qsac_prv4_1,Qsac_prv4_2 
    ! are applicable to these two periods respectively. It holds true for all input: Qexp_prv4_1,Qexp_prv4_2, etc,..
    ! condition: mon4_1+mon4_2 <=mon4
                  
    REAL,INTENT(IN)    ::  &
     X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
     DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4,DO_prv4_1,DO_prv4_2  
     
    integer, INTENT(IN) :: currMonth, currYear,mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type
    integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
      
    REAL    :: outputX2 
    
    logical :: debugCode = .false.
    
    outputX2 =  ANNX2_curMonInpSplit(X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
                        DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4,DO_prv4_1,DO_prv4_2, &  
                        mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,13,ave_type,currMonth,currYear,BeginDay, EndDay) 

    if(debugCode == .TRUE.) then
        print*,"Information X2 function:"
        print*,"month, water year:",currMonth,currYear
        print*,"X2: ",X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4            
        print*,"DO: ",DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4    
        print*,"***calculated X2: ", outputX2
    end if

END function ANN_x2_curMonInpSplit
!end of add 

FUNCTION getNDO_x2_curMonNDOSplit( X2, & 
     X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
     DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4_1,DO_prv4_2, &  
     mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type,currMonth,currYear,BeginDay, EndDay)  RESULT (requiredNDO) 
    !** returning the monthly required NDO in to obtain a desired monthly X2(the monthly average depending on "ave_type".
    !DO: delta outflow
    !DO_prv4_1 and DO_prv4_2 are the first 2 periods (mon4_1 and mon4_2) of NDOs in the current month
    !mon4_1 and mon4_2 are the number of days in the current month whose NDO flows are DO_prv4_1 and DO_prv4_2 respectively
    !mon4_1 + mon4_2 <= mon4
                  
    REAL,INTENT(IN)    ::  X2, &
     X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, & 
     DO_prv0,DO_prv1,DO_prv2,DO_prv3,DO_prv4_1,DO_prv4_2  

    integer, INTENT(IN) :: currMonth, currYear,mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type
        
    integer, optional, intent(in) :: BeginDay, EndDay !only used in ave_type ==10
      
    REAL   :: requiredNDO
    
    !logical debugCode = .true.
    !print*,"read in GetNDO: DO_prv3,DO_prv4_1,DO_prv4_2:", DO_prv3,DO_prv4_1,DO_prv4_2
    !print*,"read in GetNDO: mon4_1 and mon4_2, average type, at water year and water month, BeginDay, EndDay:", &
     !       mon4_1,mon4_2,ave_type,currYear,currMonth,BeginDay,EndDay          

    real InitialDO,tempDO, DO_lo, DO_high, DIFF, X2_TOL, DO_TOL, tempX2, BigDOstep  
    
    InitialDO=20000.0 
    tempDO=0.0 
    DO_lo=0.0
    DO_high=0.0
    DIFF = 0.0
    X2_TOL = 0.1
    DO_TOL= 0.5
    tempX2=0.
    BigDOstep = 10000.0 
    
    tempX2=ANN_x2_curMonInpSplit( &
                    X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, &
                    DO_prv0,DO_prv1,DO_prv2,DO_prv3,InitialDO,DO_prv4_1,DO_prv4_2, &  
                    mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type,currMonth,currYear,BeginDay,EndDay) 
        
        
    !find DO range to have desired X2
    
    tempDO=initialDO
    
    if(tempX2 > X2) then
        do while (tempX2 > X2) 
            DO_lo= tempDO
!            tempDO = DO_lo+BigDOstep
            tempDO = tempDO+BigDOstep
            DO_high= tempDO
     
           if (DO_high> 99999.9) then  !shengjun add 10/19/07: 99999.9 is the maximum required DO can go
                requiredNDO =  99999.9
                return
           end if
                       
            tempX2=ANN_x2_curMonInpSplit(X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, &
                    DO_prv0,DO_prv1,DO_prv2,DO_prv3,tempDO,DO_prv4_1,DO_prv4_2 , &  
					mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type,currMonth,currYear,BeginDay, EndDay)                             
        end do
    else
        do while (tempX2 < X2) 
        
            DO_high= tempDO                        
!            tempDO = DO_high-BigDOstep!shengjun revise 10/19/07
            tempDO = tempDO-BigDOstep!shengjun revise 10/19/07            
            DO_lo= tempDO            

            if (DO_lo < 0.0) then !4/20/08
                tempDO =  0.0
            end if            
              
            tempX2=ANN_x2_curMonInpSplit(X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, &
                            DO_prv0,DO_prv1,DO_prv2,DO_prv3,tempDO,DO_prv4_1,DO_prv4_2 , &    
                            mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type,currMonth,currYear,BeginDay, EndDay)                                   
                            
                            
            if(tempX2 < X2 .and. tempDO<0.1) then !4/20/08
              requiredNDO = 0.
              return
            end if
                            
        end do
    end if
    
    !now try to find out correct DO
    DIFF=ABS(X2-tempX2)    
       
    do while(DIFF > X2_TOL .and. (DO_high-DO_lo) > DO_TOL) !shengjun10/19/07: may need to consider no DO can be found for certain X2
        
        tempDO=0.5*(DO_lo+DO_high)

        tempX2=ANN_x2_curMonInpSplit(X2_prv0,X2_prv1,X2_prv2,X2_prv3,X2_prv4, &
                        DO_prv0,DO_prv1,DO_prv2,DO_prv3,tempDO,DO_prv4_1,DO_prv4_2 , &  
                        mon0,mon1,mon2,mon3,mon4,mon4_1,mon4_2,ave_type,currMonth,currYear,BeginDay, EndDay)                   
                                       	    	
    	if(tempX2 > X2) then
	        DO_lo= tempDO
	    else
	        DO_high= tempDO
	    end if
		
        DIFF=ABS(X2-tempX2)
    end do
    
    !print *, "DO diff", DO_high-DO_lo 
      
    requiredNDO =  tempDO
   
END function getNDO_x2_curMonNDOSplit
!end of add 
