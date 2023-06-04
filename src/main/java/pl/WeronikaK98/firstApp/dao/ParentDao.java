package pl.WeronikaK98.firstApp.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.WeronikaK98.firstApp.model.Child;
import pl.WeronikaK98.firstApp.model.ParentProfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParentDao {

    private static Logger LOG = Logger.getLogger(ParentDao.class.getName());

    private ObjectMapper objectMapper;

    public ParentDao() {
        objectMapper = new ObjectMapper();
    }

    public List<ParentProfile> findAll() {
        return getParentProfile();
    }

    private List<ParentProfile> getParentProfile() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get("./parents.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on getParentProfile", e);
            return new ArrayList<>();
        }
    }

    public void add(ParentProfile parentProfile) {
        try {
            List<ParentProfile> parentProfiles = getParentProfile();
            parentProfiles.add(parentProfile);

            Files.writeString(Paths.get("./parents.txt"), objectMapper.writeValueAsString(parentProfiles));

            objectMapper.writeValueAsString(parentProfiles);

        } catch (IOException e) {
            LOG.log(Level.WARNING, "Error on addParentProfile", e);
        }
    }
}
