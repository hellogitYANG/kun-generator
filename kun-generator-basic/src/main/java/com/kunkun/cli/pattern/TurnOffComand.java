package com.kunkun.cli.pattern;
//按钮
public class TurnOffComand implements Command{
    private Device device;
    public TurnOffComand(Device device){
        this.device=device;
    }
    @Override
    public void execute() {
        device.turnOff();
    }
}
