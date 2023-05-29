package pl.WeronikaK98.firstApp.model;

import java.util.List;

public class Child {

    private String name;

    private String pesel;

    private int age;

    private String adress;

    private List<Lesson> lessons;

    public Child() {
    }

    public Child(String name, String pesel, int age, String adress, List<Lesson> lessons) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
