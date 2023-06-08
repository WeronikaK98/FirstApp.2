package pl.WeronikaK98.firstApp.model;

public class Lesson {

    private String name;

    private String type;

    private String limitOfGroup;

    public Lesson() {
    }

    public Lesson(String lessonName, Child child) {
        this.name = lessonName;
        this.name = child.getName();
    }

    public Lesson(String name, String type, String limitOfGroup) {
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

    public String getLimitOfGroup() {
        return limitOfGroup;
    }

    public void setLimitOfGroup(String limitOfGroup) {
        this.limitOfGroup = limitOfGroup;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", limitOfGroup=" + limitOfGroup +
                '}';
    }
}
