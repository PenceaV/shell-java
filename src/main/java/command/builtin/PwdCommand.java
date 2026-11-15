package command.builtin;

import command.Command;

import java.util.List;

public class PwdCommand implements Command {

    @Override
    public void execute(List<String> input) {
        if (input.size() == 1) {
            System.out.println(System.getProperty("user.dir"));
        } else {
            System.out.println(String.join(" ", input) + ": command not found");
        }
    }
}
