package command.builtin;

import command.Command;
import constant.BuiltinCommands;

import java.util.List;

public class EchoCommand implements Command {

    @Override
    public void execute(List<String> input) {
        input.remove(BuiltinCommands.ECHO_COMMAND);
        System.out.println(String.join(" ", input));
    }
}
