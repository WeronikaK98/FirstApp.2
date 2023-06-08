package pl.WeronikaK98.firstApp.handlers;

import pl.WeronikaK98.firstApp.dao.ChildDao;
import pl.WeronikaK98.firstApp.dao.ParentDao;
import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.model.Child;
import pl.WeronikaK98.firstApp.model.ParentProfile;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParentCommandHandler extends BaseCommandHandler {

    private static Logger LOG = Logger.getLogger(ParentCommandHandler.class.getName());

    private static final String COMMAND_NAME = "parent";

    private ParentDao parentDao;
    private ChildDao childDao;
    private ParentProfile parentProfile;

    public ParentCommandHandler() {
        parentDao = new ParentDao();
        childDao = new ChildDao();
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
            case LOGIN:
                LOG.info("Login");
                ;
                Scanner scanner = new Scanner(System.in);

                System.out.println("Login: ");

                Scanner console = new Scanner(System.in);
                String line = console.nextLine();

                if (!line.equals("Weronika")) {
                    System.out.println("User not found");
                    System.out.println("Make sure the login is correct");
                    LOG.log(Level.INFO, "Login attempt failed");

                    System.out.println("Login: ");
                    line = console.nextLine();
                } else {
                    LOG.log(Level.INFO, "User login");
                }

                System.out.println("Password: ");
                line = scanner.nextLine();

                while (!line.equals("1477")) {
                    System.out.println("Incorrect password");
                    System.out.println("Try again");
                    LOG.log(Level.INFO, "Login attempt failed");

                    System.out.println("Password: ");
                    line = scanner.nextLine();
                }
                System.out.println("Hello");
                LOG.log(Level.INFO, "User login");
                break;

            case ADD:
                LOG.info("Add new profile");

                if (command.getParam().size() != 4) {
                    throw new IllegalArgumentException("Wrong command format. Check help for more information");
                }
                String parentName = command.getParam().get(0);
                String parentPesel = command.getParam().get(1);
                String parentAge = command.getParam().get(2);
                String parentAdress = command.getParam().get(3);

                parentDao.add(new ParentProfile(parentName, parentPesel, parentAge, parentAdress));
                break;

            case NEW_CHILD:
                LOG.info("Assign a child profile");

                if (command.getParam().size() != 2) {
                    throw new IllegalArgumentException("Wrong command format. Check help for more information");
                }
                parentName = command.getParam().get(0);
                String childName = command.getParam().get(1);
                Child child = childDao.findOne(childName)
                        .orElseThrow(() -> new IllegalArgumentException("Child not found: " + childName));

                parentProfile = parentDao.findOne(parentName)
                        .orElseThrow(() -> new IllegalArgumentException("Parent not found: " + parentName));

                parentDao.addChild(parentProfile, child);
                break;

            default: {
                throw new IllegalArgumentException(String.format("Unknown action: %s from command: %s",
                        command.getAction(), command.getCommand()));
            }
        }
    }
}