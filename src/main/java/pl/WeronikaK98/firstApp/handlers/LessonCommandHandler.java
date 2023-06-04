package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.dao.ChildDao;
import pl.WeronikaK98.firstApp.dao.LessonDao;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.model.Child;
import pl.WeronikaK98.firstApp.model.Lesson;

import java.util.List;
import java.util.logging.Logger;

public class LessonCommandHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(LessonCommandHandler.class.getName());

    private static final String COMMAND_NAME = "lesson";

//    private ChildDao childDao;
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
        if (command.getAction()==null){
            throw new IllegalArgumentException("Action can't be null");
        }
        //lesson list

        switch (command.getAction()) {
            case LIST:
                LOG.info("List of lessons");

                if (!command.getParam().isEmpty()){
                    throw new IllegalArgumentException("lesson list doesn't support any additional params");
                }
                List<Lesson> lessons = lessonDao.findAll();
                lessons.forEach(System.out::println);
                break;

//            case ADD:
//                System.out.println("Add new ChildrenProfile");
//                String childName = command.getParam().get(0);
//                String childPesel = command.getParam().get(1);
//                String childAge = command.getParam().get(2);
//                String childAdress = command.getParam().get(3);
////        List<Lesson> childLesson = command.getParam().get(4);
//                childDao.add(new Child(childName, childPesel, childAge, childAdress));


//                break;

            default: {
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s",
                        command.getAction(), command.getCommand()));
            }
        }
    }
}
