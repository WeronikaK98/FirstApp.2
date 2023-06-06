package pl.WeronikaK98.firstApp.model;

import java.util.List;

public class ParentProfile {
    private String name;

    private String pesel;

    private String age;

    private String adress;

    private List<Child> children;

    public ParentProfile() {
    }

    public ParentProfile(String name, String pesel, String age, String adress) {
        this.name = name;
        this.pesel = pesel;
        this.age = age;
        this.adress = adress;
        this.children = children;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
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

    @Override
    public String toString() {
        return "ParentProfile{" +
                "name='" + name + '\'' +
                ", pesel='" + pesel + '\'' +
                ", age='" + age + '\'' +
                ", adress='" + adress + '\'' +
                ", children=" + children +
                '}';
    }
}
