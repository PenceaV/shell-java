package command.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommandUtil {

    private CommandUtil() {
        /* This utility class should not be instantiated */
    }

    public static String getWorkingDirectory() {
        return System.getProperty("user.dir");
    }

    public static String getExecutable(String name) {
        List<String> directories = new ArrayList<>(List.of(System.getenv("PATH").split(File.pathSeparator)));

        for (String directory : directories) {
            File file = new File(directory, name);

            if (file.isFile() && file.canExecute()) {
                return file.getAbsolutePath();
            }
        }

        return "";
    }
}
