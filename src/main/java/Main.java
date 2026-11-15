import command.Command;
import command.ExecutableCommand;
import command.builtin.EchoCommand;
import command.builtin.NotFoundCommand;
import command.builtin.PwdCommand;
import command.builtin.TypeCommand;
import constant.BuiltinCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main() {

        while (true) {
            System.out.print(BuiltinCommands.START_STRING);
            Scanner scanner = new Scanner(System.in);

            String userInput = scanner.nextLine();

            List<String> inputList = new ArrayList<>(List.of(userInput.split(" ")));
            inputList.remove(BuiltinCommands.START_STRING);

            if (inputList.getFirst().equals(BuiltinCommands.EXIT_COMMAND))
                break;

            Command command = switch (inputList.getFirst()) {
                case BuiltinCommands.ECHO_COMMAND -> new EchoCommand();
                case BuiltinCommands.TYPE_COMMAND -> new TypeCommand();
                case BuiltinCommands.PWD_COMMAND -> new PwdCommand();
                default -> new ExecutableCommand();
            };

            command.execute(inputList);
        }
    }
}
