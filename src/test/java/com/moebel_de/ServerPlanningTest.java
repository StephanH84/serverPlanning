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
		
		int calculate = (new ServerPlanning()).calculate(serverType, virtualMachines);
		assertEquals(2, calculate);
	}

	
	@Test
	public void throwsExceptionWhenServerTypeTooSmall() throws Exception {
		Server serverType = new Server(1, 1, 1);
		VirtualMachine[] virtualMachines =
				{new VirtualMachine(1, 16, 10),
				new VirtualMachine(1, 16, 10),
				new VirtualMachine(2, 32, 100)};
		
		try {
			(new ServerPlanning()).calculate(serverType, virtualMachines);
			fail("Should throw an exception if server type is too small.");
		} catch (Exception e) {
			assert(e.getMessage().contains("At least one virtual machine"));
		}

	}
	
	
	@Test
	public void throwsExceptionWhenServerTypeTooSmallForLastMachine() throws Exception {
		Server serverType = new Server(4, 4, 4);
		VirtualMachine[] virtualMachines =
				{new VirtualMachine(1, 1, 1),
				new VirtualMachine(2, 2, 2),
				new VirtualMachine(2, 32, 100)};
		
		try {
			(new ServerPlanning()).calculate(serverType, virtualMachines);
			fail("Should throw an exception if server type is too small for last VM.");
		} catch (Exception e) {
			assert(e.getMessage().contains("At least one virtual machine"));
		}

	}
	
	@Test
	public void testReduceByVM() throws Exception {
		Server serverType = new Server(2, 32, 100);
		VirtualMachine virtualMachine = new VirtualMachine(1, 16, 50);
		serverType.reduceByVM(virtualMachine);
		assertEquals(16L, serverType.getRam().longValue());
	}

	@Test
	public void testCheckSizeForVM() throws Exception {
		Server serverType = new Server(2, 8, 100);
		VirtualMachine virtualMachine = new VirtualMachine(1, 16, 50);
		boolean result = serverType.checkSizeForVM(virtualMachine);
		assertEquals(false, result);
	}
	
}
