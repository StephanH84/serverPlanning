package com.moebel_de;

public class VirtualMachine {
    Integer cpu;
    Integer ram;
    Integer hdd;

    public VirtualMachine(Integer cpu, Integer ram, Integer hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
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