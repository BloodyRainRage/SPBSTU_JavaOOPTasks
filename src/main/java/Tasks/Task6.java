package Tasks;

import Tasks.Task6Commands.CdCommand;
import Tasks.Task6Commands.Command;
import Tasks.Task6Commands.FileCommand;
import Tasks.Task6Commands.LsCommand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task6 implements Task {

    public static Path path;

    File[] filesInDir;

    Map<String, Command> commands = new HashMap<>();

    public Task6() {
        try {
            path = Paths.get(new File(".").getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        commands.put("ls", new LsCommand());
        commands.put("cd", new CdCommand());
        commands.put("file", new FileCommand());
    }

//    6.	Разработать консольное приложение, позволяющее просматривать файлы и
//          каталоги файловой системы, а также создавать и удалять текстовые файлы.
//          Для работы с текстовыми файлами необходимо реализовать функциональность записи (дозаписи) в файл.

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Current directory: " + path);
//            File file = new File(String.valueOf(path));
                System.out.print("command>");
                String commandStr = scanner.nextLine();
                if (commandStr.equals("exit")) break;


                String[] arg = commandStr.split(" ");


                if (commands.containsKey(arg[0]))
                    commands.get(arg[0]).executeCommand(commandStr, path);
                else System.out.println("command " + arg[0] + " not found");


            }
        } finally {
            scanner.close();
        }

    }
}
