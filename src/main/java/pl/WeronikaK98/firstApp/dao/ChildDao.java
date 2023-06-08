package pl.WeronikaK98.firstApp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.WeronikaK98.firstApp.model.Child;
import pl.WeronikaK98.firstApp.model.Lesson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChildDao {

    private static Logger LOG = Logger.getLogger(ChildDao.class.getName());

    private ObjectMapper objectMapper;

    public ChildDao() {
        objectMapper = new ObjectMapper();
    }

    public List<Child> findAll() {
        return getChildren();
    }

    private List<Child> getChildren() {
        try {
            Files.readString(Paths.get("./children.txt"));
            return objectMapper.readValue(Files.readString(Paths.get("./children.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on getChildren", e);
            return new ArrayList<>();
        }
    }

    public void add(Child child) {
        try {
            List<Child> children = getChildren();
            children.add(child);

            saveChild(children);

            objectMapper.writeValueAsString(children);

        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on addChildren", e);
        }
    }

    private void saveChild(List<Child> children) {
        try {
            Files.writeString(Paths.get("./children.txt"), objectMapper.writeValueAsString(children));
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on saveChild", e);
        }
    }

    public void addLesson(Child child, Lesson lesson) {
        List<Child> children = getChildren();
        for (Child c : children) {
            if (Objects.equals(c.getName(), child.getName())) {
                c.getLessons().add(lesson);
            }
        }

        saveChild(children);
    }

    public Optional<Child> findOne(String childName) {
        return getChildren().stream()
                .filter(c -> c.getName().equals(childName))
                .findAny();
    }
}
