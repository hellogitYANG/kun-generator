package com.kunkun.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        //整个项目的路径
        File parentFile = new File(projectPath).getParentFile();
        //输入路径
        String absolutePath = new File(parentFile, "kun-generator-demo-projects/acm-template").getAbsolutePath();

        List<File> files = FileUtil.loopFiles(absolutePath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
