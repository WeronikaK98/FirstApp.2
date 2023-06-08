package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.dao.ChildDao;
import pl.WeronikaK98.firstApp.dao.LessonDao;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.model.Lesson;

import java.util.List;
import java.util.logging.Logger;

public class LessonCommandHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(LessonCommandHandler.class.getName());

    private static final String COMMAND_NAME = "lesson";

    private LessonDao lessonDao;
    private ChildDao childDao;

    public LessonCommandHandler() {
        lessonDao = new LessonDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        if (command.getAction() == null) {
            throw new IllegalArgumentException("Action can't be null");
        }

        switch (command.getAction()) {
            case LIST:
                LOG.info("List of lessons");

                if (!command.getParam().isEmpty()) {
                    throw new IllegalArgumentException("lesson list doesn't support any additional params");
                }
                List<Lesson> lessons = lessonDao.findAll();
                lessons.forEach(System.out::println);
                break;

            case ADD:
                System.out.println("Add new Lesson");
                String lessonName = command.getParam().get(0);
                String lessonType = command.getParam().get(1);
                String lessonLimitOfGroup = command.getParam().get(2);
                lessonDao.add(new Lesson(lessonName, lessonType, lessonLimitOfGroup));
                break;

            default: {
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s",
                        command.getAction(), command.getCommand()));
            }
        }
    }
}
