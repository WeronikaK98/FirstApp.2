package pl.WeronikaK98.firstApp.dao;

import pl.WeronikaK98.firstApp.model.Child;
import pl.WeronikaK98.firstApp.model.ParentProfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ChildDao {
    public List<Child> findAll() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("./children.txt"));
            List<Child> children = new ArrayList<>();
            for (String line : lines){
                children.add(new Child(line));
            }

            return children;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void add(Child child) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("./children.txt"));
            lines.add(child.getName());
            lines.add(child.getPesel());
            lines.add(child.getAge());
            lines.add(child.getAdress());

            Files.writeString(Paths.get("./children.txt"), String.join("\n", lines));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
