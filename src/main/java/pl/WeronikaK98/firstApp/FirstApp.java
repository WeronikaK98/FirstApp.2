package pl.WeronikaK98.firstApp;

import pl.WeronikaK98.firstApp.handlers.*;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.input.UserInputManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstApp {

    private static Logger LOG = Logger.getLogger(FirstApp.class.getName());
    public static void main(String[] args) {
        new FirstApp().start();
    }

    private void start() {
        LOG.info("Start app");

        List<CommandHandler> handlers = new ArrayList<>();
        handlers.add(new HelpCommandHandler());
        handlers.add(new QuitCommandHandler());
        handlers.add(new ParentCommandHandler());
        handlers.add(new ChildCommandHandler());
        handlers.add(new LessonCommandHandler());

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
                LOG.info(userInputCommand.toString());

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
                LOG.info("Quit");
                applicationLoop = false;

            } catch (IllegalArgumentException e) {
                LOG.log(Level.WARNING, "Validation exception " + e.getMessage());


            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Unknown error", e);
            }
        }
    }
}
