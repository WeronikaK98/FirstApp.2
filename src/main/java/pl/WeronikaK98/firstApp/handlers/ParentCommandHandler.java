package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.dao.ParentDao;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.model.ParentProfile;

import java.util.List;

public class ParentCommandHandler extends BaseCommandHandler {

    private static final String COMMAND_NAME = "parent";

    private ParentDao parentDao;

    public ParentCommandHandler() {
        parentDao = new ParentDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        // parent login
        // parent add
switch (command.getAction()){
    case "login":
        System.out.println("Login...");
        break;

    case "add":
        System.out.println("Add new profile");
        String parentName = command.getParam().get(0);
        String parentPesel = command.getParam().get(1);
        String parentAge = command.getParam().get(2);
        String parentAdress = command.getParam().get(3);
//        List<> children = command.getParam().get(4);
        parentDao.add(new ParentProfile(parentName, parentPesel, parentAge, parentAdress));
        break;

    default: {
        throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s",
                command.getAction(), command.getCommand()));
    }
}
    }
}