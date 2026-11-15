package command.builtin;

import command.Command;

import java.util.List;

public class NotFoundCommand implements Command {

    @Override
    public void execute(List<String> input) {
        System.out.println(String.join(" ", input) + ": command not found");
    }
}
