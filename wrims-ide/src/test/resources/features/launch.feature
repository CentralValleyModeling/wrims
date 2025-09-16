Feature: Launch study
  As a user of the wrims
  I want to launch a regular run a CalSim study
  So that I can see it running
    
  Scenario: Regular launch    
  	Given Select launch file "C:\\9.3.1_danube_adj\\CS3_Adjusted_Dev.launch" and mode "run"
    When Run the launch shortcut