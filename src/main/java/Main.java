import command.Command;
import command.ExecutableCommand;
import command.builtin.*;
import constant.BuiltinCommands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static command.util.CommandUtil.getWorkingDirectory;

public class Main {
    private static File workingDirectory = new File(getWorkingDirectory());

    public static void main() {

        while (true) {
            System.out.print(BuiltinCommands.START_STRING);
            Scanner scanner = new Scanner(System.in);

            String userInput = scanner.nextLine();

            List<String> inputList = new ArrayList<>(List.of(userInput.split(" ")));
            inputList.remove(BuiltinCommands.START_STRING);

            if (inputList.getFirst().equals(BuiltinCommands.EXIT_COMMAND))
                break;

            String inputCommand = inputList.getFirst().toLowerCase();

            Command command = switch (inputCommand) {
                case BuiltinCommands.ECHO_COMMAND -> new EchoCommand();
                case BuiltinCommands.TYPE_COMMAND -> new TypeCommand();
                case BuiltinCommands.PWD_COMMAND -> new PwdCommand(workingDirectory);
                case BuiltinCommands.CD_COMMAND -> new CdCommand();
                default -> new ExecutableCommand();
            };

            command.execute(inputList);

            if (inputCommand.equals(BuiltinCommands.CD_COMMAND)) {
                CdCommand cdCommand = (CdCommand) command;

                if (cdCommand.getChangedWorkingDirectory() != null)
                    workingDirectory = cdCommand.getChangedWorkingDirectory();
            }
        }
    }
}
