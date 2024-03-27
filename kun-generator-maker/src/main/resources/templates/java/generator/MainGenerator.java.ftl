package ${basePackage}.generator;

import ${basePackage}.model.DataModel;
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
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;
	<#list fileConfig.files as fileInfo>
    
    	inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
    	outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
    	<#if fileInfo.generateType == "static">
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);
    	<#else>
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
    	</#if>
	</#list>
    }
}