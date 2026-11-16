package command.builtin;

import command.Command;
import constant.BuiltinCommands;

import java.io.File;
import java.util.List;

public class CdCommand implements Command {

    private File workingDirectory;

    @Override
    public void execute(List<String> input) {
        input.remove(BuiltinCommands.CD_COMMAND);
        if (input.size() == 1) {
            workingDirectory = new File(input.getFirst());

            if (!workingDirectory.exists()) {
                System.out.println(BuiltinCommands.CD_COMMAND + ": " + workingDirectory + ": No such file or directory");
                workingDirectory = null;
            }
        }
    }

    public File getChangedWorkingDirectory() {
        return workingDirectory;
    }
}
