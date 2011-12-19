WRIMS v2.0
c 2011 California Department of Water Resources and Federal Bureau of Reclamation

This product contains merchant resources of Oracle JRockit.

This product requires the previous purchase the license for XA developed by Sunset Software Technology.

Directions:
Go to "bin" folder and double click "wrimsv2_sg.bat" file.

Notes:
1) When a variable in the past cycle is undefined but used in a later cycle, WRIMS will continue looking for the same variable in the previous cycles from this past cycle in the reverse order. WRIMS will use the variable from the nearest previous cycle where this variable is found. If the variable is not defined in any of the previous cycles, an error message will show that the variable in the past cycle is not defined.

2) The XA linear programming solver maximizes the objective function composed of decision variables and their coefficients while subject to constraints. The uniqueness of decision variable solutions is not guaranteed unless the maximum objective value occurs at single point of the feasible region. The decision variable solution set returned by the XA solver is probably only one of infinitely many solution sets that give the same maximum objective value.


