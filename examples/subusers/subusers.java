import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sendgrid.*;

import subusers.examples.Example1;
import subusers.examples.Example10;
import subusers.examples.Example11;
import subusers.examples.Example12;
import subusers.examples.Example13;
import subusers.examples.Example14;
import subusers.examples.Example2;
import subusers.examples.Example3;
import subusers.examples.Example4;
import subusers.examples.Example5;
import subusers.examples.Example6;
import subusers.examples.Example7;
import subusers.examples.Example8;
import subusers.examples.Example9;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//////////////////////////////////////////////////////////////////
// Create Subuser
// POST /subusers

public class ExecuteExamples{
	
	public static void main(String[]args) throws IOException{
		Example1.executeTest();
		Example2.executeTest();
		Example3.executeTest();
		Example4.executeTest();
		Example5.executeTest();
		Example6.executeTest();
		Example7.executeTest();
		Example8.executeTest();
		Example9.executeTest();
		Example10.executeTest();
		Example11.executeTest();
		Example12.executeTest();
		Example13.executeTest();
		Example14.executeTest();
	}
}
