FUNCTION testdllfunction( X1 )  RESULT (ans) 
               
    dll_export testdllfunction

                  
    REAL,INTENT(IN)    ::  X1
      
    REAL   :: ans
    
      
    ans =  4.7*X1
   
END function testdllfunction