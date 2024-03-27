package com.kunkun.cli.pattern;
//设备
public class Device {
    private String name;
    public Device(String name){
        this.name=name;
    }
    public void turnOn(){
        System.out.println(name+"打开");
    }
    public void turnOff(){
        System.out.println(name+"关闭");
    }
}
