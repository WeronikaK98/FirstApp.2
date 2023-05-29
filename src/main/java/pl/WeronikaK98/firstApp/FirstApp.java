package pl.WeronikaK98.firstApp;

import pl.WeronikaK98.firstApp.handlers.CommandHandler;
import pl.WeronikaK98.firstApp.handlers.HelpCommandHandler;
import pl.WeronikaK98.firstApp.handlers.QuitCommandHandler;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.input.UserInputManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FirstApp {
    public static void main(String[] args) {
        new FirstApp().start();
    }

    private void start() {
        System.out.println("Start app");

        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(new HelpCommandHandler());
        handlers.add(new QuitCommandHandler());

        /**
         * parent add ParentName -> parentAdd(name, pesel, age, adress)
         *
         * child list -> childrenList()
         * child add ChildName -> childAdd(name, pesel, age, adress)
         *
         * quit -> quitApplication()
         *
         * lesson list -> lessonList()  [lista wszystkich dostępnych zajęć]
         * lesson list ChildName -> lessonList(ChildName)  [lista zajęć na które zapisane jest dane dziecko]
         * lesson add ChildName LessonName -> lessonAdd(ChildName, LessonName)
         */

        boolean applicationLoop = true;

        UserInputManager userInputManager = new UserInputManager();

        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);

                Optional<CommandHandler> currentHandler = Optional.empty();
                for (CommandHandler handler : handlers) {
                    if (handler.supports(userInputCommand.getCommand())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }
                }

                currentHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + userInputCommand.getCommand()))
                        .handle(userInputCommand);

            } catch (QuitFirstAppException e) {
                System.out.println("Quit");
                applicationLoop = false;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
