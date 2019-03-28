package helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WriteJsonObjectToFile {
    public static void writeToFile()
            throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        HashMap<String, Integer> hashMap;
        List<String> categories = new ArrayList<>();
        categories.add("car");
        categories.add("food");
        categories.add("mobile");
        User user = ExtractObject
                .getObjectFromJson("/expenses.json");
        hashMap = GetTotalAmount
                .getTotalAmountByCategory(user, categories);

        JSONArray jsonArray = new JSONArray();
        for (String key : hashMap.keySet()) {
            JSONObject category = new JSONObject();
            category.put("category", (key));
            category.put("total", hashMap.get(key));
            jsonArray.put(category);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", user.getId());
        jsonObject.put("name", user.getName());
        jsonObject.put("stats", jsonArray);

        try (FileWriter file = new FileWriter("src/files/stats.json")) {
            file.write(gson.toJson(jsonObject));
            file.flush();
        }
    }
}
