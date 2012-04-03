# /* Date: 1921.10    */
# /* Cycle: 01    */
# /* Solver: ILP_XALOG    */

# /* dvar */
var X >= 0.0 <= 3.0 integer ;
var Y >= 0.0 <= 1.0 integer ;
var Z >= 0.0 <= 1.0 ;
var BB ;

# /* constraint */
subject to C1:  + X + 2 * Y + 3 * Z <= 4.0 ;
subject to C2:  + X + Y >= 1.0 ;
subject to C3:  + BB = 1.0 ;

# objective function 
maximize Obj:  
+ 1.0 * X
+ 1.0 * Y
+ 2.0 * Z
;



# /* objective value:   3.6666666666666665    */
