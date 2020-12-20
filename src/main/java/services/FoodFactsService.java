package services;

import com.google.gson.GsonBuilder;
import database.Informations;
import database.ShoppingList;
import deserializer.InformationsDtoDeserializer;
import dto.InformationsDto;
import mapper.InformationsMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class FoodFactsService {
    public InformationsDto food(long barCode) throws IOException {
        String uri = "https://word.openfoodfacts.org/api/v0/product/" + barCode + ".json";
        String json = get(uri);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(InformationsDto.class, new InformationsDtoDeserializer());
        InformationsDto informationsDto = gsonBuilder.create().fromJson(json, InformationsDto.class);

        Informations entity = InformationsMapper.mapInformationsDtoToInformations(informationsDto);
        // TODO: save to database

        return informationsDto;
    }

    private String get(String uri) throws IOException {
        try {
            URL url = new URL(uri);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = in.readLine()) != null) {
                stringBuilder.append(line);
            }
            in.close();

            if (stringBuilder.toString() == "") {
                throw new IOException("Nie znaleziono produktu");


            }

            return stringBuilder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}

