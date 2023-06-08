package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.input.UserInputCommand;

public interface CommandHandler {
    void handle(UserInputCommand command);

    boolean supports(String name);
}
