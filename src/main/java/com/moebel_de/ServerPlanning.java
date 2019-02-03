package com.moebel_de;

public class ServerPlanning {
    public int calculate(Server serverType, VirtualMachine[] virtualMachines) throws Exception {
        if (virtualMachines.length == 0) {
            throw new Exception("No virtual machines specified.");
        }

        Server calcServer = new Server(serverType);
        int result = 1;

        for (VirtualMachine virtualMachine : virtualMachines) {
            if (!calcServer.reduceByVM(virtualMachine)) {
                // no space left on server, a new server needs to be spawned
                result += 1;
                calcServer = new Server(serverType);
            }
        }
        
        return result;
    }
}