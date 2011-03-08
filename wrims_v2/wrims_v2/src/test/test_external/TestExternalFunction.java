package test.test_external;

import org.testng.annotations.*;
import org.testng.Assert;

import wrimsv2.external.*;

import java.util.*;


public class TestExternalFunction {

	@Test
	public void sample()
	{
		Assert.assertEquals(1,1);
        System.out.println("@Test sample: 1==1");
	}

	@Test
	public void testAnnEC(){
		
		new LoadInterfaceDll("InterfaceToAnn.dll");
		
		ExternalFunctionTable eft=new ExternalFunctionTable();
		ExternalFunction ef=eft.externalFunctionsHashtable.get("annec");
		Stack stack= new Stack();
		stack.add(81183.7421875);
		stack.add(57666.609375);
		stack.add(33755.21875);
		stack.add(35595.9726563);
		stack.add(12703.9482422);
		stack.add(11567.1210938);
		stack.add(10971.9179688); 
		stack.add(1835.09558105);
		stack.add(2110.24755859);
		stack.add(6749.43554688);
		stack.add(11402.3476563);
		stack.add(10534.6083984);
		stack.add(7340.38232422); 
		stack.add(8440.99023438);
		stack.add(5723.10986328);
		stack.add(0.0);
		stack.add(0.0);
		stack.add(0.0);
		stack.add(0.0);
		stack.add(26.0);
		stack.add(-3725.58007813);
		stack.add(183.309997559);
		stack.add(1131.44995117);
		stack.add(1359.26000977);
		stack.add(3874.82983398); 
		stack.add(52724.8515625);
		stack.add(6683.39941406);
		stack.add(2338.921875);
		stack.add(4785.66699219);
		stack.add(753.499328613);
		stack.add(77.187461853);
		stack.add(79.5642929077);
		stack.add(0.0);
		stack.add(149.219497681);
		stack.add(343.878936768);
		stack.add(331.338287354);
		stack.add(337.781890869);
		stack.add(358.810211182);
		stack.add(311.293121338);
		stack.add(470.136566162); 
		stack.add(29);
		stack.add(31);
		stack.add(30);
		stack.add(31);
		stack.add(30);
		stack.add(3);
		stack.add(1);
		stack.add(7);
		stack.add(1996);
		ef.execute(stack);
		
		if (stack.size()!=1){
			System.out.println("stack size <>1");
		}else{
			System.out.println(((Number) stack.pop()).floatValue());
		}
		
		stack = new Stack();
		stack.add(57666.609375);
		stack.add(33755.21875);
		stack.add(35595.9726563);
		stack.add(12703.9482422);
		stack.add(21248.9335938);
		stack.add(10971.9179688); 
		stack.add(1835.09558105);
		stack.add(2110.24755859);
		stack.add(6749.43554688);
		stack.add(11190.7050781);
		stack.add(10534.6083984);
		stack.add(7340.38232422);
		stack.add(8440.99023438); 
		stack.add(5723.10986328);
		stack.add(2537.1784668);
		stack.add(0.0);
		stack.add(0.0);
		stack.add(0.0);
		stack.add(26.0);
		stack.add(31.0);
		stack.add(183.309997559);
		stack.add(1131.44995117);
		stack.add(1359.26000977);
		stack.add(3874.82983398);
		stack.add(4374.95019531);
		stack.add(6683.39941406);
		stack.add(2338.921875);
		stack.add(4785.66699219);
		stack.add(753.499328613);
		stack.add(0.0);
		stack.add(79.5642929077);
		stack.add(0.0);
		stack.add(149.219497681);
		stack.add(343.878936768);
		stack.add(256.333435059); 
		stack.add(337.781890869);
		stack.add(358.810211182);
		stack.add(311.293121338);
		stack.add(470.136566162);
		stack.add(602.596130371);
		stack.add(31);
		stack.add(30);
		stack.add(31);
		stack.add(30);
		stack.add(31);
		stack.add(3);
		stack.add(1);
		stack.add(8);
		stack.add(1996);
		
		ef.execute(stack);
		
		if (stack.size()!=1){
			System.out.println("stack size <>1");
		}else{
			System.out.println(((Number) stack.pop()).floatValue());
		}
	}
}