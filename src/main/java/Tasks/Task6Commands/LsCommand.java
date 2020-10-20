package Tasks.Task6Commands;

import java.io.File;
import java.nio.file.Path;

public class LsCommand implements Command {


    @Override
    public int executeCommand(String commandString, Path path) {
        File file = new File(String.valueOf(path));

        File[] filesInDir = file.listFiles();

        for (File fileName : filesInDir) {
            if (fileName.isDirectory()) System.out.print("Dir  ");
            if (fileName.isFile()) System.out.print("File ");
            System.out.println(fileName);
        }

        return 0;
    }

    @Override
    public String commandName() {
        return "ls";
    }
}
