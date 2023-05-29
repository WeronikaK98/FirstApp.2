package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.input.UserInputCommand;

public class HelpCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "help";

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("Help");
        System.out.println("Allowed commands: help, quit, parent, child, lesson");
        System.out.println("Command pattern: <command> <action> <param1> <param2> <param3>");
        System.out.println("Example: parent add ParentName");
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
