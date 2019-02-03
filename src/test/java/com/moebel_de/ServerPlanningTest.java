package com.moebel_de;

import static org.junit.Assert.*;

import org.junit.Test;

public class ServerPlanningTest {
	@Test
	public void testServerPlanning() throws Exception {
		Server serverType = new Server(2, 32, 100);
		VirtualMachine[] virtualMachines =
				{new VirtualMachine(1, 16, 10),
				new VirtualMachine(1, 16, 10),
				new VirtualMachine(2, 32, 100)};
		
		assertEquals(2, (new ServerPlanning()).calculate(serverType, virtualMachines));
	}
	
	@Test
	public void testReduceByVM() throws Exception {
		Server serverType = new Server(2, 32, 100);
		VirtualMachine virtualMachine = new VirtualMachine(1, 16, 50);
		boolean result = serverType.reduceByVM(virtualMachine);
		assertEquals(true, result);
		assertEquals(16L, serverType.getRam().longValue());
	}

	@Test
	public void testfailedReduceByVM() throws Exception {
		Server serverType = new Server(2, 8, 100);
		VirtualMachine virtualMachine = new VirtualMachine(1, 16, 50);
		boolean result = serverType.reduceByVM(virtualMachine);
		assertEquals(false, result);
		assertEquals(8L, serverType.getRam().longValue());
	}
	
}
