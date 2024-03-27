package com.kunkun.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;
@Command(name = "Login", version = "Login 1.0", mixinStandardHelpOptions = true )
public class Login implements Callable<Integer> {
    @Option(names = {"-u","--user"},description = "User Name")
    String user;
    @Option(names = {"-p","--password"}, arity = "0..1",description = "password",interactive = true)
    String password;
    @Option(names = {"-cp","--checkPassword"},arity = "0..1",description = "check Password",interactive = true)
    String checkPassword;
    @Override
    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
//        默认情况下，是无法直接在命令中给交互式选项指定任何参数的，只能通过交互式输入，比如命令中包含 -p xxx 会报错。
//        new CommandLine(new Login()).execute("-u","kunkun","-p","xxx","-cp");

//        官方提供了可选交互式的解决方案，通过调整 @Option 注解中的 arity 属性来指定每个选项可接受的参数个数，就能解决这个问题。
          new CommandLine(new Login()).execute("-u","kunkun","-p","xxx","-cp");
    }
}
