package Tasks.Task6Commands;

import Tasks.Task6;

import java.io.File;
import java.nio.file.Path;

public class CdCommand implements Command {
    @Override
    public int executeCommand(String commandString, Path path) {

        String[] args = commandString.split(" ");

        try {
            if (args[1].equals("..")) {
                Task6.path = new File(path.toString().substring(0, path.toString().lastIndexOf("\\"))).toPath();
            } else {
                Task6.path = new File(path.toString().concat("\\" + args[1])).toPath();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;


    }

    @Override
    public String commandName() {
        return "cd";
    }
}
