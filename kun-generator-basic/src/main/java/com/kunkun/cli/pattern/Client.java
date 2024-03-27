package com.kunkun.cli.pattern;

//命令模式，主要是解耦，每个按钮相当于每一个命令，这些命令还可以灵活的装在遥控器上，由遥控器进行控制
public class Client {
    public static void main(String[] args) {
        //创建接收者对象
        Device tv = new Device("TV");
        Device stereo = new Device("Stereo");

       //创建具体命令对象，可以绑定不同设备
        TurnOnComand turnOn = new TurnOnComand(tv);
        TurnOffComand turnOff = new TurnOffComand(stereo);

        //遥控器装上按钮
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOn);
        remoteControl.pressButton();

        remoteControl.setCommand(turnOff);
        remoteControl.pressButton();
    }
}
