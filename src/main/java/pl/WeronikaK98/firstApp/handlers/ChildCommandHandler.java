package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.dao.ChildDao;
import pl.WeronikaK98.firstApp.dao.ParentDao;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.model.Child;
import pl.WeronikaK98.firstApp.model.Lesson;
import pl.WeronikaK98.firstApp.model.ParentProfile;

import java.util.List;

public class ChildCommandHandler extends BaseCommandHandler {

    private static final String COMMAND_NAME = "child";

    private ChildDao childDao;

    public ChildCommandHandler() {
        childDao = new ChildDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        //child list
        // child add ChildName
switch (command.getAction()){
    case "list":
        System.out.println("List of children");
        List<Child> children = childDao.findAll();
        children.forEach(System.out::println);
        break;

    case "add":
        System.out.println("Add new ChildrenProfile");
        String childName = command.getParam().get(0);
        String childPesel = command.getParam().get(1);
        String childAge = command.getParam().get(2);
        String childAdress = command.getParam().get(3);
//        List<Lesson> childLesson = command.getParam().get(4);
        childDao.add(new Child(childName, childPesel, childAge, childAdress));


        break;

    default: {
        throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s",
                command.getAction(), command.getCommand()));
    }
}
    }
}
