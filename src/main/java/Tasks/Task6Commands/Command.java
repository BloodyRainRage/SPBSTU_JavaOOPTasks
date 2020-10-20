package Tasks.Task6Commands;

import java.nio.file.Path;

public interface Command {

    public int executeCommand(String commandString, Path path);

    public String commandName();

}
