package main;

import java.io.IOException;
import org.antlr.runtime.RecognitionException;

import wrimsv2.wreslparser.elements.StudyUtils;

public class WreslCheck {

	public static void main(String[] args) throws RecognitionException, IOException {

		String csvFolderName = "=WreslCheck_csv=";
		String logFileName = "=WreslCheck=.log";

		StudyUtils.checkStudy(args[0], logFileName, csvFolderName);

	}

}
