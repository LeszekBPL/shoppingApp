package deserializer;

import com.google.gson.*;
import dto.InformationsDto;

import java.lang.reflect.Type;

public class InformationsDtoDeserializer implements JsonDeserializer<InformationsDto> {

    @Override
    public InformationsDto deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonObject object = jsonObject.getAsJsonObject("product");
        String product_name = object.get("product_name").getAsString();
        String brands = object.get("brands").getAsString();
        String categories = object.get("categories").getAsString();
        String countries = object.get("countries").getAsString();
        String stores = object.get("stores").getAsString();
        String purchase_places = object.get("purchase_places").getAsString();
        long code = object.get("code").getAsLong();

        return new InformationsDto(code, product_name, brands, categories, countries, stores, purchase_places);
    }
}
