package helpers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import org.joda.time.DateTime;

public class JodaDeserializer extends JsonDeserializer<DateTime>
{
    @Override
    public DateTime deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException
    {
        return DateTime.parse(jp.getText());
    }
}
