package com.yupi.generator;

import com.yupi.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        //因为文件众多，目录不一样，所以统一在原信息里面配置每一个文件的位置信息，就不读取当前目录的方式了
        String inputRootPath = "D:/MyFullNotes/BaiduSyncdisk/X Project/code-generator/kun-generator/kun-generator-demo-projects/acm-template-pro";
        String outputRootPath = "generated";

        String inputPath;
        String outputPath;
    
    	inputPath = new File(inputRootPath, "src/com/yupi/acm/MainTemplate.java.ftl").getAbsolutePath();
    	outputPath = new File(outputRootPath, "src/com/yupi/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
    
    	inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
    	outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    
    	inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
    	outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    }
}