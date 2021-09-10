package javeriana.ms.multiplier;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class DataPersistenceController {
    public void writeData(DataPersistence newData) {
        ArrayList<DataPersistence> data = getData();
        data.add(newData);
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = prettyGson.toJson(data);

        try {
            FileWriter fr = new FileWriter("resources/data.json");
            fr.write(prettyJson);
            fr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<DataPersistence> getData() {

        Type dataListType = new TypeToken<ArrayList<DataPersistence>>() {
        }.getType();
        JsonReader dataFile;
        Gson g = new Gson();
        try {
            dataFile = new JsonReader(new FileReader("resources/data.json"));
            ArrayList<DataPersistence> data = g.fromJson(dataFile, dataListType);
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
