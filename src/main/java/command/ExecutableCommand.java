package command;

import java.io.IOException;
import java.util.List;

import static command.util.CommandUtil.getExecutable;

public class ExecutableCommand implements Command{

    @Override
    public void execute(List<String> input) {
        if (!getExecutable(input.getFirst()).isEmpty()) {
            runExecutable(input);
        } else {
            System.out.println(String.join(" ", input) + ": command not found");
        }

    }

    private void runExecutable(List<String> input) {
        ProcessBuilder processBuilder = new ProcessBuilder(input);
        processBuilder.inheritIO();

        try {
            int exitCode = processBuilder.start().waitFor();
            if (exitCode != 0) {
                System.out.println("Command failed with exit code: " + exitCode);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }
    }
}
