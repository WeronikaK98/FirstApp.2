package pl.WeronikaK98.firstApp.model;

import java.util.ArrayList;
import java.util.List;

public class Child {

    private String name;

    private String pesel;

    private String age;

    private String adress;

    private List<Lesson> lessons;

    public Child(String line) {
    }

    public Child() {
    }

    public Child(String name, String pesel, String age, String adress) {
        this.name = name;
        this.pesel = pesel;
        this.age = age;
        this.adress = adress;
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Lesson> getLessons() {
        if (lessons == null) {
            lessons = new ArrayList<>();
        }
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                ", age='" + age + '\'' +
                ", adress='" + adress + '\'' +
                ", lessons=" + lessons +
                '}';
    }
}
