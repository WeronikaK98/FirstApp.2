package pl.WeronikaK98.firstApp.model;

public class Lesson {

    private String name;

    private String type;

    private int limitOfGroup;

    public Lesson(String lessonName, Child child) {
    }

    public Lesson(String name, String type, int limitOfGroup) {
        this.name = name;
        this.type = type;
        this.limitOfGroup = limitOfGroup;
    }

    public Lesson(String lessonName) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLimitOfGroup() {
        return limitOfGroup;
    }

    public void setLimitOfGroup(int limitOfGroup) {
        this.limitOfGroup = limitOfGroup;
    }
}
