package command.builtin;

import command.Command;
import constant.BuiltinCommands;

import java.util.List;

import static command.util.CommandUtil.getExecutable;

public class TypeCommand implements Command {

    @Override
    public void execute(List<String> input) {
        input.remove(BuiltinCommands.TYPE_COMMAND);

        String inputString = String.join(" ", input);

        if (BuiltinCommands.contains(inputString)) {
            System.out.println(inputString + " is a shell builtin");
            return;
        } else {
            String exePath = getExecutable(inputString);
            if (!exePath.isEmpty()) {
                System.out.println(inputString + " is " + exePath);
                return;
            }
        }
        System.out.println(inputString + ": not found");
    }
}


