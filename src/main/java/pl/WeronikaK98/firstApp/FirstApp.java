package pl.WeronikaK98.firstApp;

import pl.WeronikaK98.firstApp.input.UserInputCommand;
import pl.WeronikaK98.firstApp.input.UserInputManager;

public class FirstApp {
    public static void main(String[] args) {
        new FirstApp().start();
    }

    private void start() {
        System.out.println("Start app");

        /**
         * parent add ParentName -> parentAdd(name, pesel, age, adress)
         *
         * child list -> childrenList()
         * child add ChildName -> childAdd(name, pesel, age, adress)
         *
         * quite -> quiteApplication()
         *
         * lesson list -> lessonList()  [lista wszystkich dostępnych zajęć]
         * lesson list ChildName -> lessonList(ChildName)  [lista zajęć na które zapisane jest dane dziecko]
         * lesson add ChildName LessonName -> lessonAdd(ChildName, LessonName)
         */

        boolean applicationLoop = true;

        UserInputManager userInputManager = new UserInputManager();

        while (applicationLoop){
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
