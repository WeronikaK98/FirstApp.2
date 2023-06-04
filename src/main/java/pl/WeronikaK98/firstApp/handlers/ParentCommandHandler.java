package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.dao.ChildDao;
import pl.WeronikaK98.firstApp.dao.ParentDao;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.model.ParentProfile;

import java.util.List;
import java.util.logging.Logger;

public class ParentCommandHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(ParentCommandHandler.class.getName());

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
        if (command.getAction()==null){
            throw new IllegalArgumentException("Action can't be null");
        }
        // parent login
        // parent add
switch (command.getAction()){
    case LOGIN:
        LOG.info("Login...");
        break;

    case ADD:
        LOG.info("Add new profile");

        if (command.getParam().size() != 4){
            throw new IllegalArgumentException("Wrong command format. Check help for more information");
        }
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