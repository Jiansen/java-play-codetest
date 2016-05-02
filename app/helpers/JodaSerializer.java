package helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import org.joda.time.DateTime;

public class JodaSerializer extends JsonSerializer<DateTime>
{
    @Override
    public void serialize(DateTime t, JsonGenerator jg, SerializerProvider _) throws IOException, JsonProcessingException
    {
        jg.writeString(t.toString());
    }
}
