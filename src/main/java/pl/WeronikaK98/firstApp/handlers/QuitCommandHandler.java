package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.QuitFirstAppException;
import pl.WeronikaK98.firstApp.input.UserInputCommand;

public class QuitCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "quit";

    @Override
    public void handle(UserInputCommand command) {
        throw new QuitFirstAppException();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
