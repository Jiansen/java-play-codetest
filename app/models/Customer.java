package models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import helpers.JodaDeserializer;
import helpers.JodaSerializer;
import org.joda.time.DateTime;

public class Customer
{

    private String id;

    private String name;

    @JsonSerialize(using = JodaSerializer.class)
    @JsonDeserialize(using = JodaDeserializer.class)
    private DateTime duetime;

    @JsonSerialize(using = JodaSerializer.class)
    @JsonDeserialize(using = JodaDeserializer.class)
    private DateTime jointime;

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the duetime
     */
    public DateTime getDuetime()
    {
        return duetime;
    }

    /**
     * @param duetime the duetime to set
     */
    public void setDuetime(DateTime duetime)
    {
        this.duetime = duetime;
    }

    /**
     * @return the jointime
     */
    public DateTime getJointime()
    {
        return jointime;
    }

    /**
     * @param jointime the jointime to set
     */
    public void setJointime(DateTime jointime)
    {
        this.jointime = jointime;
    }
}
