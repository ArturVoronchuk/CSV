import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CsvToJson {

    static String listToJson(List<Employee> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gsonList = builder
                .setPrettyPrinting()
                .create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        return gsonList.toJson(list, listType);
    }

    static void writeString(String json, String jsonFileName) {
        try (FileWriter file = new FileWriter(jsonFileName)) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(json);
    }
}