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
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LessonDao {

    private static Logger LOG = Logger.getLogger(LessonDao.class.getName());

    private ObjectMapper objectMapper;

    public LessonDao() {
        objectMapper = new ObjectMapper();
    }

    public List<Lesson> findAll() {
        return getLessons();
    }

    private List<Lesson> getLessons() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get("./lessons.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on getLessons", e);
            return new ArrayList<>();
        }
    }

    public void add(Lesson lesson) {
        try {
            List<Lesson> children = getLessons();
            children.add(lesson);

            Files.writeString(Paths.get("./children_lessons.txt"), objectMapper.writeValueAsString(lesson));

            objectMapper.writeValueAsString(lesson);

        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on addLesson", e);
        }
    }

    public  Optional<Lesson> findOne(String lessonName) {
        return getLessons().stream()
                .filter(l -> l.getName().equals(lessonName))
                .findAny();
    }
}