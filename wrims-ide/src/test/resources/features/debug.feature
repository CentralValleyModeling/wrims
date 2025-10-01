Feature: Debug a study
  As a user of the wrims
  I want to launch a regular run a CalSim study in debug mode
  So that I can debug the study
    
  Scenario: Debug a study    
  	Given WRIMS GUI is started and the project "C:\9.3.1_danube_adj\.project" exists
	When import the project
	Given timestamp of year 1923 and month 10 and date 31 and cycle 1
	When set this timestamp and cycle as breakpoint
	Given the launch file "C:\9.3.1_danube_adj\CS3_Hist_Dev.launch" exists
	When launch this lanuch file under "debug" mode
	Given the study reach the breakpoint
	When click "next step" button
	And click "next cycle" button
	And click menu of "Run->Next step" button
	And click menu of "Run->Next cycle" button
	Given wresl file "C:\9.3.1_danube_adj\Run\COA\coa.wresl" exists
	When open this wresl file
	Given view "Variables" exists
	When open this view
	Given view "Goals" exists
	When open this view
	Given view "All Variable" exists
	When open this view
	Given dss file "C:\9.3.1_danube_adj\DSS\output\DCR2023_DV_9.3.1_v2a_Danube_Adj_v1.8.dss" exists
	When load this dss file
	And click "all variables from DSS" button in this view
	Given view "All Goals" exists
	When open this view
	And click "constrol goals" button in this view
	Given view "Watch" exists
	When open this view
	Given variable "s_shsta"
	When add this variable to the watch list
	Given constraint "swp_storage_change"
	When add this constraint to the watch list
	And delete this constraint from watch list
	Given variable "I_SHSTA" exists in the wresl file "C:\9.3.1_danube_adj\Run\COA\coa.wresl"
	When hove over on this variable
	Given constraint "swp_storage_change" exists in the wresl file "C:\9.3.1_danube_adj\Run\COA\coa.wresl"
	When hove over on this constraint
	And click "Resume" button
	And click "Pause" button after 2 second
	And click menu "Run->Resume" button
	And click menu "Run->Pause" button after 2 second
	And click "Terminate" button
