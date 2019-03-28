package helpers;

import com.google.gson.Gson;
import runner.Runner;
import model.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ExtractObject {

    public static User getObjectFromJson(final String pathToFile)
            throws IOException {
        Gson gson = new Gson();
        File file = new File(
                Runner.class
                        .getResource(pathToFile)
                        .getFile());
        Reader reader = new FileReader(file);
        return gson.fromJson(reader, User.class);
    }
}
