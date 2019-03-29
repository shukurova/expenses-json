package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import model.stats.Stat;
import model.stats.Stats;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WriteJsonObjectToFile {
    public static void writeJsonToFile()
            throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        HashMap<String, Integer> hashMap;
        User user = ExtractObject
                .getObjectFromJson("/expenses.json");
        hashMap = GetTotalAmount
                .getTotalAmountByCategory(user);

        Stat stat = new Stat();
        List<Stats> stats = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            Stats statsList = new Stats();
            statsList.setCategory(key);
            statsList.setTotal(hashMap.get(key));
            stats.add(statsList);
        }

        stat.setId(user.getId());
        stat.setName(user.getName());
        stat.setStats(stats);

        try (FileWriter file = new FileWriter("src/files/stats.json")) {
            file.write(gson.toJson(stat));
            file.flush();
        }
    }
}
