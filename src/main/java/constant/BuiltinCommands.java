package constant;

import java.util.Set;

public final class BuiltinCommands {
    private BuiltinCommands() {
        /* This utility class should not be instantiated */
    }

    public static final String START_STRING = "$ ";

    public static final String EXIT_COMMAND = "exit";
    public static final String ECHO_COMMAND = "echo";
    public static final String TYPE_COMMAND = "type";
    public static final String PWD_COMMAND = "pwd";
    public static final String CD_COMMAND = "cd";

    private static final Set<String> BUILTIN_COMMANDS = Set.of(
            EXIT_COMMAND,
            ECHO_COMMAND,
            TYPE_COMMAND,
            PWD_COMMAND,
            CD_COMMAND);

    public static boolean contains(String command) {
        return BUILTIN_COMMANDS.contains(command);
    }
}
