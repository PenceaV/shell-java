package command.builtin;

import command.Command;

import java.io.File;
import java.util.List;

public class PwdCommand implements Command {

    private final File workingDirectory;

    public PwdCommand(File workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    @Override
    public void execute(List<String> input) {
        if (input.size() == 1) {
            System.out.println(workingDirectory);
        } else {
            System.out.println(String.join(" ", input) + ": command not found");
        }
    }
}
