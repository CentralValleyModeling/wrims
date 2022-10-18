package wrimsv2.external;

import java.util.*;

import wrimsv2.components.ControlData;

public class Functioncamdll extends ExternalFunction{
	private final boolean DEBUG = false;


	public Functioncamdll(){

	}

	public void execute(Stack stack) {

		long t1 = Calendar.getInstance().getTimeInMillis();
		
		if (stack.size()==2){
			Object param2 = stack.pop();
			Object param1 = stack.pop();
			
			int ICODE = ((Number) param2).intValue();
			int ICALC = ((Number) param1).intValue();
			
			float result = camdll(ICALC, ICODE, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0, (float) 0.0);
			
			// push the result on the Stack
			stack.push(new Float(result));
		}else{
			//values in reverse order:
			Object param201 = stack.pop();
			Object param200 = stack.pop();
			Object param199 = stack.pop();
			Object param198 = stack.pop();
			Object param197 = stack.pop();
			Object param196 = stack.pop();
			Object param195 = stack.pop();
			Object param194 = stack.pop();
			Object param193 = stack.pop();
			Object param192 = stack.pop();
			Object param191 = stack.pop();
			Object param190 = stack.pop();
			Object param189 = stack.pop();
			Object param188 = stack.pop();
			Object param187 = stack.pop();
			Object param186 = stack.pop();
			Object param185 = stack.pop();
			Object param184 = stack.pop();
			Object param183 = stack.pop();
			Object param182 = stack.pop();
			Object param181 = stack.pop();
			Object param180 = stack.pop();
			Object param179 = stack.pop();
			Object param178 = stack.pop();
			Object param177 = stack.pop();
			Object param176 = stack.pop();
			Object param175 = stack.pop();
			Object param174 = stack.pop();
			Object param173 = stack.pop();
			Object param172 = stack.pop();
			Object param171 = stack.pop();
			Object param170 = stack.pop();
			Object param169 = stack.pop();
			Object param168 = stack.pop();
			Object param167 = stack.pop();
			Object param166 = stack.pop();
			Object param165 = stack.pop();
			Object param164 = stack.pop();
			Object param163 = stack.pop();
			Object param162 = stack.pop();
			Object param161 = stack.pop();
			Object param160 = stack.pop();
			Object param159 = stack.pop();
			Object param158 = stack.pop();
			Object param157 = stack.pop();
			Object param156 = stack.pop();
			Object param155 = stack.pop();
			Object param154 = stack.pop();
			Object param153 = stack.pop();
			Object param152 = stack.pop();
			Object param151 = stack.pop();
			Object param150 = stack.pop();
			Object param149 = stack.pop();
			Object param148 = stack.pop();
			Object param147 = stack.pop();
			Object param146 = stack.pop();
			Object param145 = stack.pop();
			Object param144 = stack.pop();
			Object param143 = stack.pop();
			Object param142 = stack.pop();
			Object param141 = stack.pop();
			Object param140 = stack.pop();
			Object param139 = stack.pop();
			Object param138 = stack.pop();
			Object param137 = stack.pop();
			Object param136 = stack.pop();
			Object param135 = stack.pop();
			Object param134 = stack.pop();
			Object param133 = stack.pop();
			Object param132 = stack.pop();
			Object param131 = stack.pop();
			Object param130 = stack.pop();
			Object param129 = stack.pop();
			Object param128 = stack.pop();
			Object param127 = stack.pop();
			Object param126 = stack.pop();
			Object param125 = stack.pop();
			Object param124 = stack.pop();
			Object param123 = stack.pop();
			Object param122 = stack.pop();
			Object param121 = stack.pop();
			Object param120 = stack.pop();
			Object param119 = stack.pop();
			Object param118 = stack.pop();
			Object param117 = stack.pop();
			Object param116 = stack.pop();
			Object param115 = stack.pop();
			Object param114 = stack.pop();
			Object param113 = stack.pop();
			Object param112 = stack.pop();
			Object param111 = stack.pop();
			Object param110 = stack.pop();
			Object param109 = stack.pop();
			Object param108 = stack.pop();
			Object param107 = stack.pop();
			Object param106 = stack.pop();
			Object param105 = stack.pop();
			Object param104 = stack.pop();
			Object param103 = stack.pop();
			Object param102 = stack.pop();
			Object param101 = stack.pop();
			Object param100 = stack.pop();
			Object param99 = stack.pop();
			Object param98 = stack.pop();
			Object param97 = stack.pop();
			Object param96 = stack.pop();
			Object param95 = stack.pop();
			Object param94 = stack.pop();
			Object param93 = stack.pop();
			Object param92 = stack.pop();
			Object param91 = stack.pop();
			Object param90 = stack.pop();
			Object param89 = stack.pop();
			Object param88 = stack.pop();
			Object param87 = stack.pop();
			Object param86 = stack.pop();
			Object param85 = stack.pop();
			Object param84 = stack.pop();
			Object param83 = stack.pop();
			Object param82 = stack.pop();
			Object param81 = stack.pop();
			Object param80 = stack.pop();
			Object param79 = stack.pop();
			Object param78 = stack.pop();
			Object param77 = stack.pop();
			Object param76 = stack.pop();	
			Object param75 = stack.pop();
			Object param74 = stack.pop();
			Object param73 = stack.pop();
			Object param72 = stack.pop();
			Object param71 = stack.pop();
			Object param70 = stack.pop();
			Object param69 = stack.pop();
			Object param68 = stack.pop();
			Object param67 = stack.pop();
			Object param66 = stack.pop();
			Object param65 = stack.pop();
			Object param64 = stack.pop();
			Object param63 = stack.pop();
			Object param62 = stack.pop();
			Object param61 = stack.pop();
			Object param60 = stack.pop();
			Object param59 = stack.pop();
			Object param58 = stack.pop();
			Object param57 = stack.pop();
			Object param56 = stack.pop();
			Object param55 = stack.pop();
			Object param54 = stack.pop();
			Object param53 = stack.pop();
			Object param52 = stack.pop();
			Object param51 = stack.pop();
			Object param50 = stack.pop();
			Object param49 = stack.pop();
			Object param48 = stack.pop();
			Object param47 = stack.pop();
			Object param46 = stack.pop();
			Object param45 = stack.pop();
			Object param44 = stack.pop();
			Object param43 = stack.pop();
			Object param42 = stack.pop();
			Object param41 = stack.pop();
			Object param40 = stack.pop();
			Object param39 = stack.pop();
			Object param38 = stack.pop();
			Object param37 = stack.pop();
			Object param36 = stack.pop();
			Object param35 = stack.pop();
			Object param34 = stack.pop();
			Object param33 = stack.pop();
			Object param32 = stack.pop();
			Object param31 = stack.pop();
			Object param30 = stack.pop();
			Object param29 = stack.pop();
			Object param28 = stack.pop();
			Object param27 = stack.pop();
			Object param26 = stack.pop();
			Object param25 = stack.pop();
			Object param24 = stack.pop();
			Object param23 = stack.pop();
			Object param22 = stack.pop();
			Object param21 = stack.pop();
			Object param20 = stack.pop();
			Object param19 = stack.pop();
			Object param18 = stack.pop();
			Object param17 = stack.pop();
			Object param16 = stack.pop();
			Object param15 = stack.pop();
			Object param14 = stack.pop();
			Object param13 = stack.pop();
			Object param12 = stack.pop();
			Object param11 = stack.pop();
			Object param10 = stack.pop();
			Object param9 = stack.pop();
			Object param8 = stack.pop();
			Object param7 = stack.pop();
			Object param6 = stack.pop();
			Object param5 = stack.pop();
			Object param4 = stack.pop();
			Object param3 = stack.pop();
			Object param2 = stack.pop();
			Object param1 = stack.pop();

			//cast params to correct types:
			float PSH_1_12 = ((Number) param201).floatValue();
			float PSH_1_11 = ((Number) param200).floatValue();
			float PSH_1_10 = ((Number) param199).floatValue();
			float PSH_0_4 = ((Number) param198).floatValue();
			float PSH_0_3 = ((Number) param197).floatValue();
			float PSH_0_2 = ((Number) param196).floatValue();
			float PSH_0_1 = ((Number) param195).floatValue();
			float PYU_1_12 = ((Number) param194).floatValue();
			float PYU_1_11 = ((Number) param193).floatValue();
			float PYU_1_10 = ((Number) param192).floatValue();
			float PYU_0_4 = ((Number) param191).floatValue();
			float PYU_0_3 = ((Number) param190).floatValue();
			float PYU_0_2 = ((Number) param189).floatValue();
			float PYU_0_1 = ((Number) param188).floatValue();
			float PFO_1_12 = ((Number) param187).floatValue();
			float PFO_1_11 = ((Number) param186).floatValue();
			float PFO_1_10 = ((Number) param185).floatValue();
			float PFO_0_4 = ((Number) param184).floatValue();
			float PFO_0_3 = ((Number) param183).floatValue();
			float PFO_0_2 = ((Number) param182).floatValue();
			float PFO_0_1 = ((Number) param181).floatValue();
			float POR_1_12 = ((Number) param180).floatValue();
			float POR_1_11 = ((Number) param179).floatValue();
			float POR_1_10 = ((Number) param178).floatValue();
			float POR_0_4 = ((Number) param177).floatValue();
			float POR_0_3 = ((Number) param176).floatValue();
			float POR_0_2 = ((Number) param175).floatValue();
			float POR_0_1 = ((Number) param174).floatValue();
			float QBD_1_12 = ((Number) param173).floatValue();
			float QBD_1_11 = ((Number) param172).floatValue();
			float QBD_1_10 = ((Number) param171).floatValue();
			float QBD_0_4 = ((Number) param170).floatValue();
			float QBD_0_3 = ((Number) param169).floatValue();
			float QBD_0_2 = ((Number) param168).floatValue();
			float QBD_0_1 = ((Number) param167).floatValue();
			float QSH_1_12 = ((Number) param166).floatValue();
			float QSH_1_11 = ((Number) param165).floatValue();
			float QSH_1_10 = ((Number) param164).floatValue();
			float QSH_0_4 = ((Number) param163).floatValue();
			float QSH_0_3 = ((Number) param162).floatValue();
			float QSH_0_2 = ((Number) param161).floatValue();
			float QSH_0_1 = ((Number) param160).floatValue();
			float QYU_1_12 = ((Number) param159).floatValue();
			float QYU_1_11 = ((Number) param158).floatValue();
			float QYU_1_10 = ((Number) param157).floatValue();
			float QYU_0_4 = ((Number) param156).floatValue();
			float QYU_0_3 = ((Number) param155).floatValue();
			float QYU_0_2 = ((Number) param154).floatValue();
			float QYU_0_1 = ((Number) param153).floatValue();
			float QFO_1_12 = ((Number) param152).floatValue();
			float QFO_1_11 = ((Number) param151).floatValue();
			float QFO_1_10 = ((Number) param150).floatValue();
			float QFO_0_4 = ((Number) param149).floatValue();
			float QFO_0_3 = ((Number) param148).floatValue();
			float QFO_0_2 = ((Number) param147).floatValue();
			float QFO_0_1 = ((Number) param146).floatValue();
			float QOR_2_12 = ((Number) param145).floatValue();
			float QOR_2_11 = ((Number) param144).floatValue();
			float QOR_2_10 = ((Number) param143).floatValue();
			float QOR_1_12 = ((Number) param142).floatValue();
			float QOR_1_11 = ((Number) param141).floatValue();
			float QOR_1_10 = ((Number) param140).floatValue();
			float QOR_1_9 = ((Number) param139).floatValue();
			float QOR_1_8 = ((Number) param138).floatValue();
			float QOR_1_7 = ((Number) param137).floatValue();
			float QOR_1_6 = ((Number) param136).floatValue();
			float QOR_1_5 = ((Number) param135).floatValue();
			float QOR_1_4 = ((Number) param134).floatValue();
			float QOR_1_3 = ((Number) param133).floatValue();
			float QOR_1_2 = ((Number) param132).floatValue();
			float QOR_1_1 = ((Number) param131).floatValue();
			float QOR_0_4 = ((Number) param130).floatValue();
			float QOR_0_3 = ((Number) param129).floatValue();
			float QOR_0_2 = ((Number) param128).floatValue();
			float QOR_0_1 = ((Number) param127).floatValue();
			float SQNB_2_12 = ((Number) param126).floatValue();
			float SQNB_2_11 = ((Number) param125).floatValue();
			float SQNB_2_10 = ((Number) param124).floatValue();
			float SQNB_1_12 = ((Number) param123).floatValue();
			float SQNB_1_11 = ((Number) param122).floatValue();
			float SQNB_1_10 = ((Number) param121).floatValue();
			float SQNB_1_9 = ((Number) param120).floatValue();
			float SQNB_1_8 = ((Number) param119).floatValue();
			float SQNB_1_7 = ((Number) param118).floatValue();
			float SQNB_1_6 = ((Number) param117).floatValue();
			float SQNB_1_5 = ((Number) param116).floatValue();
			float SQNB_1_4 = ((Number) param115).floatValue();
			float SQNB_1_3 = ((Number) param114).floatValue();
			float SQNB_1_2 = ((Number) param113).floatValue();
			float SQNB_1_1 = ((Number) param112).floatValue();
			float SQNB_0_4 = ((Number) param111).floatValue();
			float SQNB_0_3 = ((Number) param110).floatValue();
			float SQNB_0_2 = ((Number) param109).floatValue();
			float SQNB_0_1 = ((Number) param108).floatValue();
			float SQSW_2_12 = ((Number) param107).floatValue();
			float SQSW_2_11 = ((Number) param106).floatValue();
			float SQSW_2_10 = ((Number) param105).floatValue();
			float SQSW_1_12 = ((Number) param104).floatValue();
			float SQSW_1_11 = ((Number) param103).floatValue();
			float SQSW_1_10 = ((Number) param102).floatValue();
			float SQSW_1_9 = ((Number) param101).floatValue();
			float SQSW_1_8 = ((Number) param100).floatValue();
			float SQSW_1_7 = ((Number) param99).floatValue();
			float SQSW_1_6 = ((Number) param98).floatValue();
			float SQSW_1_5 = ((Number) param97).floatValue();
			float SQSW_1_4 = ((Number) param96).floatValue();
			float SQSW_1_3 = ((Number) param95).floatValue();
			float SQSW_1_2 = ((Number) param94).floatValue();
			float SQSW_1_1 = ((Number) param93).floatValue();
			float SQSW_0_4 = ((Number) param92).floatValue();
			float SQSW_0_3 = ((Number) param91).floatValue();
			float SQSW_0_2 = ((Number) param90).floatValue();
			float SQSW_0_1 = ((Number) param89).floatValue();
			float SQFP_2_12 = ((Number) param88).floatValue();
			float SQFP_2_11 = ((Number) param87).floatValue();
			float SQFP_2_10 = ((Number) param86).floatValue();
			float SQFP_1_12 = ((Number) param85).floatValue();
			float SQFP_1_11 = ((Number) param84).floatValue();
			float SQFP_1_10 = ((Number) param83).floatValue();
			float SQFP_1_9 = ((Number) param82).floatValue();
			float SQFP_1_8 = ((Number) param81).floatValue();
			float SQFP_1_7 = ((Number) param80).floatValue();
			float SQFP_1_6 = ((Number) param79).floatValue();
			float SQFP_1_5 = ((Number) param78).floatValue();
			float SQFP_1_4 = ((Number) param77).floatValue();
			float SQFP_1_3 = ((Number) param76).floatValue();
			float SQFP_1_2 = ((Number) param75).floatValue();
			float SQFP_1_1 = ((Number) param74).floatValue();
			float SQFP_0_4 = ((Number) param73).floatValue();
			float SQFP_0_3 = ((Number) param72).floatValue();
			float SQFP_0_2 = ((Number) param71).floatValue();
			float SQFP_0_1 = ((Number) param70).floatValue();
			float SQFW_2_12 = ((Number) param69).floatValue();
			float SQFW_2_11 = ((Number) param68).floatValue();
			float SQFW_2_10 = ((Number) param67).floatValue();
			float SQFW_1_12 = ((Number) param66).floatValue();
			float SQFW_1_11 = ((Number) param65).floatValue();
			float SQFW_1_10 = ((Number) param64).floatValue();
			float SQFW_1_9 = ((Number) param63).floatValue();
			float SQFW_1_8 = ((Number) param62).floatValue();
			float SQFW_1_7 = ((Number) param61).floatValue();
			float SQFW_1_6 = ((Number) param60).floatValue();
			float SQFW_1_5 = ((Number) param59).floatValue();
			float SQFW_1_4 = ((Number) param58).floatValue();
			float SQFW_1_3 = ((Number) param57).floatValue();
			float SQFW_1_2 = ((Number) param56).floatValue();
			float SQFW_1_1 = ((Number) param55).floatValue();
			float SQFW_0_4 = ((Number) param54).floatValue();
			float SQFW_0_3 = ((Number) param53).floatValue();
			float SQFW_0_2 = ((Number) param52).floatValue();
			float SQFW_0_1 = ((Number) param51).floatValue();
			float SQOR_2_12 = ((Number) param50).floatValue();
			float SQOR_2_11 = ((Number) param49).floatValue();
			float SQOR_2_10 = ((Number) param48).floatValue();
			float SQOR_1_12 = ((Number) param47).floatValue();
			float SQOR_1_11 = ((Number) param46).floatValue();
			float SQOR_1_10 = ((Number) param45).floatValue();
			float SQOR_1_9 = ((Number) param44).floatValue();
			float SQOR_1_8 = ((Number) param43).floatValue();
			float SQOR_1_7 = ((Number) param42).floatValue();
			float SQOR_1_6 = ((Number) param41).floatValue();
			float SQOR_1_5 = ((Number) param40).floatValue();
			float SQOR_1_4 = ((Number) param39).floatValue();
			float SQOR_1_3 = ((Number) param38).floatValue();
			float SQOR_1_2 = ((Number) param37).floatValue();
			float SQOR_1_1 = ((Number) param36).floatValue();
			float SQOR_0_4 = ((Number) param35).floatValue();
			float SQOR_0_3 = ((Number) param34).floatValue();
			float SQOR_0_2 = ((Number) param33).floatValue();
			float SQOR_0_1 = ((Number) param32).floatValue();
			float SQKS_2_12 = ((Number) param31).floatValue();
			float SQKS_2_11 = ((Number) param30).floatValue();
			float SQKS_2_10 = ((Number) param29).floatValue();
			float SQKS_1_12 = ((Number) param28).floatValue();
			float SQKS_1_11 = ((Number) param27).floatValue();
			float SQKS_1_10 = ((Number) param26).floatValue();
			float SQKS_1_9 = ((Number) param25).floatValue();
			float SQKS_1_8 = ((Number) param24).floatValue();
			float SQKS_1_7 = ((Number) param23).floatValue();
			float SQKS_1_6 = ((Number) param22).floatValue();
			float SQKS_1_5 = ((Number) param21).floatValue();
			float SQKS_1_4 = ((Number) param20).floatValue();
			float SQKS_1_3 = ((Number) param19).floatValue();
			float SQKS_1_2 = ((Number) param18).floatValue();
			float SQKS_1_1 = ((Number) param17).floatValue();
			float SQKS_0_4 = ((Number) param16).floatValue();
			float SQKS_0_3 = ((Number) param15).floatValue();
			float SQKS_0_2 = ((Number) param14).floatValue();
			float SQKS_0_1 = ((Number) param13).floatValue();
			float IFREQ5X = ((Number) param12).floatValue();
			float IFREQ4X = ((Number) param11).floatValue();
			float IFREQ3X = ((Number) param10).floatValue();
			float IFREQ2X = ((Number) param9).floatValue();
			float IFREQ1X = ((Number) param8).floatValue();
			float IFREQODX = ((Number) param7).floatValue();
			float IMX = ((Number) param6).floatValue();
			float IYEARX = ((Number) param5).floatValue();
			float IMPOSX = ((Number) param4).floatValue();
			float IYPOSX = ((Number) param3).floatValue();
			int ICODE = ((Number) param2).intValue();
			int ICALC = ((Number) param1).intValue();
		
			float result = camdll(ICALC, ICODE, IYPOSX, IMPOSX, IYEARX, IMX, IFREQODX, IFREQ1X, IFREQ2X, IFREQ3X, IFREQ4X, IFREQ5X, SQKS_0_1, SQKS_0_2, SQKS_0_3, SQKS_0_4, SQKS_1_1, SQKS_1_2, SQKS_1_3, SQKS_1_4, SQKS_1_5, SQKS_1_6, SQKS_1_7, SQKS_1_8, SQKS_1_9, SQKS_1_10, SQKS_1_11, SQKS_1_12, SQKS_2_10, SQKS_2_11, SQKS_2_12, SQOR_0_1, SQOR_0_2, SQOR_0_3, SQOR_0_4, SQOR_1_1, SQOR_1_2, SQOR_1_3, SQOR_1_4, SQOR_1_5, SQOR_1_6, SQOR_1_7, SQOR_1_8, SQOR_1_9, SQOR_1_10, SQOR_1_11, SQOR_1_12, SQOR_2_10, SQOR_2_11, SQOR_2_12, SQFW_0_1, SQFW_0_2, SQFW_0_3, SQFW_0_4, SQFW_1_1, SQFW_1_2, SQFW_1_3, SQFW_1_4, SQFW_1_5, SQFW_1_6, SQFW_1_7, SQFW_1_8, SQFW_1_9, SQFW_1_10, SQFW_1_11, SQFW_1_12, SQFW_2_10, SQFW_2_11, SQFW_2_12, SQFP_0_1, SQFP_0_2, SQFP_0_3, SQFP_0_4, SQFP_1_1, SQFP_1_2, SQFP_1_3, SQFP_1_4, SQFP_1_5, SQFP_1_6, SQFP_1_7, SQFP_1_8, SQFP_1_9, SQFP_1_10, SQFP_1_11, SQFP_1_12, SQFP_2_10, SQFP_2_11, SQFP_2_12, SQSW_0_1, SQSW_0_2, SQSW_0_3, SQSW_0_4, SQSW_1_1, SQSW_1_2, SQSW_1_3, SQSW_1_4, SQSW_1_5, SQSW_1_6, SQSW_1_7, SQSW_1_8, SQSW_1_9, SQSW_1_10, SQSW_1_11, SQSW_1_12, SQSW_2_10, SQSW_2_11, SQSW_2_12, SQNB_0_1, SQNB_0_2, SQNB_0_3, SQNB_0_4, SQNB_1_1, SQNB_1_2, SQNB_1_3, SQNB_1_4, SQNB_1_5, SQNB_1_6, SQNB_1_7, SQNB_1_8, SQNB_1_9, SQNB_1_10, SQNB_1_11, SQNB_1_12, SQNB_2_10, SQNB_2_11, SQNB_2_12, QOR_0_1, QOR_0_2, QOR_0_3, QOR_0_4, QOR_1_1, QOR_1_2, QOR_1_3, QOR_1_4, QOR_1_5, QOR_1_6, QOR_1_7, QOR_1_8, QOR_1_9, QOR_1_10, QOR_1_11, QOR_1_12, QOR_2_10, QOR_2_11, QOR_2_12, QFO_0_1, QFO_0_2, QFO_0_3, QFO_0_4, QFO_1_10, QFO_1_11, QFO_1_12, QYU_0_1, QYU_0_2, QYU_0_3, QYU_0_4, QYU_1_10, QYU_1_11, QYU_1_12, QSH_0_1, QSH_0_2, QSH_0_3, QSH_0_4, QSH_1_10, QSH_1_11, QSH_1_12, QBD_0_1, QBD_0_2, QBD_0_3, QBD_0_4, QBD_1_10, QBD_1_11, QBD_1_12, POR_0_1, POR_0_2, POR_0_3, POR_0_4, POR_1_10, POR_1_11, POR_1_12, PFO_0_1, PFO_0_2, PFO_0_3, PFO_0_4, PFO_1_10, PFO_1_11, PFO_1_12, PYU_0_1, PYU_0_2, PYU_0_3, PYU_0_4, PYU_1_10, PYU_1_11, PYU_1_12, PSH_0_1, PSH_0_2, PSH_0_3, PSH_0_4, PSH_1_10, PSH_1_11, PSH_1_12);
			
			// push the result on the Stack
			stack.push(new Float(result));

		}
		
		long t2 = Calendar.getInstance().getTimeInMillis();
		ControlData.t_cam=ControlData.t_cam+(int) (t2-t1);
	}

	public native float camdll(int ICALC, int ICODE, float IYPOSX, float IMPOSX, float IYEARX, float IMX, float IFREQODX, float IFREQ1X, float IFREQ2X, float IFREQ3X, float IFREQ4X, float IFREQ5X, float SQKS_0_1, float SQKS_0_2, float SQKS_0_3, float SQKS_0_4, float SQKS_1_1, float SQKS_1_2, float SQKS_1_3, float SQKS_1_4, float SQKS_1_5, float SQKS_1_6, float SQKS_1_7, float SQKS_1_8, float SQKS_1_9, float SQKS_1_10, float SQKS_1_11, float SQKS_1_12, float SQKS_2_10, float SQKS_2_11, float SQKS_2_12, float SQOR_0_1, float SQOR_0_2, float SQOR_0_3, float SQOR_0_4, float SQOR_1_1, float SQOR_1_2, float SQOR_1_3, float SQOR_1_4, float SQOR_1_5, float SQOR_1_6, float SQOR_1_7, float SQOR_1_8, float SQOR_1_9, float SQOR_1_10, float SQOR_1_11, float SQOR_1_12, float SQOR_2_10, float SQOR_2_11, float SQOR_2_12, float SQFW_0_1, float SQFW_0_2, float SQFW_0_3, float SQFW_0_4, float SQFW_1_1, float SQFW_1_2, float SQFW_1_3, float SQFW_1_4, float SQFW_1_5, float SQFW_1_6, float SQFW_1_7, float SQFW_1_8, float SQFW_1_9, float SQFW_1_10, float SQFW_1_11, float SQFW_1_12, float SQFW_2_10, float SQFW_2_11, float SQFW_2_12, float SQFP_0_1, float SQFP_0_2, float SQFP_0_3, float SQFP_0_4, float SQFP_1_1, float SQFP_1_2, float SQFP_1_3, float SQFP_1_4, float SQFP_1_5, float SQFP_1_6, float SQFP_1_7, float SQFP_1_8, float SQFP_1_9, float SQFP_1_10, float SQFP_1_11, float SQFP_1_12, float SQFP_2_10, float SQFP_2_11, float SQFP_2_12, float SQSW_0_1, float SQSW_0_2, float SQSW_0_3, float SQSW_0_4, float SQSW_1_1, float SQSW_1_2, float SQSW_1_3, float SQSW_1_4, float SQSW_1_5, float SQSW_1_6, float SQSW_1_7, float SQSW_1_8, float SQSW_1_9, float SQSW_1_10, float SQSW_1_11, float SQSW_1_12, float SQSW_2_10, float SQSW_2_11, float SQSW_2_12, float SQNB_0_1, float SQNB_0_2, float SQNB_0_3, float SQNB_0_4, float SQNB_1_1, float SQNB_1_2, float SQNB_1_3, float SQNB_1_4, float SQNB_1_5, float SQNB_1_6, float SQNB_1_7, float SQNB_1_8, float SQNB_1_9, float SQNB_1_10, float SQNB_1_11, float SQNB_1_12, float SQNB_2_10, float SQNB_2_11, float SQNB_2_12, float QOR_0_1, float QOR_0_2, float QOR_0_3, float QOR_0_4, float QOR_1_1, float QOR_1_2, float QOR_1_3, float QOR_1_4, float QOR_1_5, float QOR_1_6, float QOR_1_7, float QOR_1_8, float QOR_1_9, float QOR_1_10, float QOR_1_11, float QOR_1_12, float QOR_2_10, float QOR_2_11, float QOR_2_12, float QFO_0_1, float QFO_0_2, float QFO_0_3, float QFO_0_4, float QFO_1_10, float QFO_1_11, float QFO_1_12, float QYU_0_1, float QYU_0_2, float QYU_0_3, float QYU_0_4, float QYU_1_10, float QYU_1_11, float QYU_1_12, float QSH_0_1, float QSH_0_2, float QSH_0_3, float QSH_0_4, float QSH_1_10, float QSH_1_11, float QSH_1_12, float QBD_0_1, float QBD_0_2, float QBD_0_3, float QBD_0_4, float QBD_1_10, float QBD_1_11, float QBD_1_12, float POR_0_1, float POR_0_2, float POR_0_3, float POR_0_4, float POR_1_10, float POR_1_11, float POR_1_12, float PFO_0_1, float PFO_0_2, float PFO_0_3, float PFO_0_4, float PFO_1_10, float PFO_1_11, float PFO_1_12, float PYU_0_1, float PYU_0_2, float PYU_0_3, float PYU_0_4, float PYU_1_10, float PYU_1_11, float PYU_1_12, float PSH_0_1, float PSH_0_2, float PSH_0_3, float PSH_0_4, float PSH_1_10, float PSH_1_11, float PSH_1_12);
}
