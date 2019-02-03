package com.moebel_de;

public class ServerPlanning {
    public int calculate(Server serverType, VirtualMachine[] virtualMachines) throws Exception {
        int result = 0;
        Server calcServer = null;
        
        for (VirtualMachine virtualMachine : virtualMachines) {
        	// check if operation is possible
        	if (!serverType.checkSizeForVM(virtualMachine)) {
        		throw new Exception("At least one virtual machine does not fit in an empty server.");
        	}

        	// check if current server is large enough
            if (calcServer == null || !calcServer.checkSizeForVM(virtualMachine)) {
            	calcServer = new Server(serverType);
            	result += 1;
            }
            
            // now it is possible, so perform placement
            calcServer.reduceByVM(virtualMachine);
        }
        return result;
    }
}