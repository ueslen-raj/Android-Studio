package devcomcury.tk.ultimatentativa;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by t3ddy on 22/12/2017.
 */

public class ClimaDeserialize implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonElement element = null;
            if(json.getAsJsonObject() != null){
                element = json.getAsJsonObject();
            }
            return (new Gson().fromJson(element,Clima.class));
    }
}
