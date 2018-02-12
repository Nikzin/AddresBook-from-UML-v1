package Console;

import Console.CommandLine;

import java.util.Scanner;

public class Console implements ConsolePrinter {

    @Override
    public void print(String string) {
        System.out.println(string);

    }
    public void registerInputHandler(InputHandler handler) {
        System.out.println("enter your command or type 'help' for help");
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            CommandLine commandLine = new CommandLine();
            commandLine = commandLine.parse(scanner.nextLine());
            handler.handle(commandLine);
            System.out.println("enter your command or type 'help' for help");
        }
    }



}
