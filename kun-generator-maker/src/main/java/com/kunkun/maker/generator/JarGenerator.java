package com.kunkun.maker.generator;

import java.io.*;

public class JarGenerator {
    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        //清理之前的构建并打包
        //注意不同的操作系统不同的命令
        String winMavenCommand="mvn.cmd clean package -DskipTest=true";
        String otherMavenCommand="mvn clean package -DskipTest=true";
        String mavenCommand=winMavenCommand;

        //拆分命令
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();

        //读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }

        //等待命令执行完成
        int code = process.waitFor();
        System.out.println("命令执行结束，退出码："+code);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("D:\\MyFullNotes\\BaiduSyncdisk\\X Project\\code-generator\\kun-generator\\kun-generator-maker\\generated\\acm-template-pro-generator");
    }
}
