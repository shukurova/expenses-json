package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import runner.Runner;
import model.User;

import java.io.File;
import java.io.IOException;

public class ExtractObject {

    public static User getObjectFromJson(final String pathToFile)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(
                Runner.class
                        .getResource(pathToFile)
                        .getFile());
        return mapper.readValue(file, User.class);
    }
}
