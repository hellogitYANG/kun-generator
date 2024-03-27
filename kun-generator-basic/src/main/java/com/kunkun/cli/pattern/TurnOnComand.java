package com.kunkun.cli.pattern;
//按钮
public class TurnOnComand implements Command{
    private Device device;
    public TurnOnComand(Device device){
        this.device=device;
    }
    @Override
    public void execute() {
        device.turnOn();
    }
}
