package com.moebel_de;

public class Server {
    Integer cpu;
    Integer ram;
    Integer hdd;

    public Server(Integer cpu, Integer ram, Integer hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    public Server(Server serverType) {
        this.cpu = serverType.getCpu();
        this.ram = serverType.getRam();
        this.hdd = serverType.getHdd();
    }

    public boolean reduceByVM(VirtualMachine virtualMachine) {
        // check first (for enough resources) and then perform operation
        if (cpu >= virtualMachine.getCpu()
                && ram >= virtualMachine.getRam()
                && hdd >= virtualMachine.getHdd()) {
            cpu -= virtualMachine.getCpu();
            ram -= virtualMachine.getRam();
            hdd -= virtualMachine.getHdd();

            return true;
        } else {
            // Server does not have enough resources.
            return false;
        }

    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getHdd() {
        return hdd;
    }

    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }
}