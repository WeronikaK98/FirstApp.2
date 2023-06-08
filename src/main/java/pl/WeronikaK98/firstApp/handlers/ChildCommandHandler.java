package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.dao.ChildDao;
import pl.WeronikaK98.firstApp.dao.LessonDao;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.model.Child;
import pl.WeronikaK98.firstApp.model.Lesson;

import java.util.List;
import java.util.logging.Logger;

public class ChildCommandHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(ChildCommandHandler.class.getName());

    private static final String COMMAND_NAME = "child";

    private ChildDao childDao;
    private LessonDao lessonDao;

//    public LessonCommandHandler(){
//        lessonDao = new LessonDao();
//    }
    private Child child = new Child();
    private Lesson lesson = new Lesson();

    public ChildCommandHandler() {
        childDao = new ChildDao();
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
        //child list
        // child add ChildName
        switch (command.getAction()) {
            case LIST:
                LOG.info("List of children");

                if (!command.getParam().isEmpty()){
                    throw new IllegalArgumentException("child list doesn't support any additional params");
                }
                List<Child> children = childDao.findAll();
                children.forEach(System.out::println);
                break;

            case ADD:
                LOG.info("Add new ChildrenProfile");

                if (command.getParam().size() != 4){
                    throw new IllegalArgumentException("Wrong command format. Check help for more information");
                }
                String childName = command.getParam().get(0);
                String childPesel = command.getParam().get(1);
                String childAge = command.getParam().get(2);
                String childAdress = command.getParam().get(3);
//        List<Lesson> childLesson = command.getParam().get(4);
                childDao.add(new Child(childName, childPesel, childAge, childAdress));
                break;

            case SIGN_UP:
                LOG.info("Sign up");
                // child sign_up ChildName LessonName
                if (command.getParam().size() != 2){
                    throw new IllegalArgumentException("Wrong command format. Check help for more information");
                }
                childName = command.getParam().get(0);
                String lessonName = command.getParam().get(1);
                Lesson lesson = lessonDao.findOne(lessonName)
                        .orElseThrow(() -> new IllegalArgumentException("Lesson not found: " + lessonName));

                System.out.println(lessonName);
                childDao.addLesson(child, lesson);
                break;

            default: {
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s",
                        command.getAction(), command.getCommand()));
            }
        }
    }
}
