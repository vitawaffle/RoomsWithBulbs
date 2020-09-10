package by.vit.roomswithbulbs.entity;

/**
 * Room entity.
 *
 * @author Vitaly Lobatsevich
 */
public class Room extends Entity {

    /** Room name. */
    private String name;

    /** Room country. */
    private Country country;

    /** Is the light on. */
    private Boolean light;

    /**
     * Default constructor.
     */
    public Room() {
        super();
        name = null;
        country = null;
        light = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param id - room id.
     * @param name - room name.
     * @param country - room country.
     * @param light - light.
     */
    public Room(final String id, final String name, final Country country, final Boolean light) {
        super(id);
        this.name = name;
        this.country = country;
        this.light = light;
    }

    /**
     * Name setter.
     *
     * @param name - room name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Name getter.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Country setter.
     *
     * @param country - room country.
     */
    public void setCountry(final Country country) {
        this.country = country;
    }

    /**
     * Country getter.
     *
     * @return country.
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Light setter.
     *
     * @param light - light.
     */
    public void setLight(final Boolean light) {
        this.light = light;
    }

    /**
     * Light getter.
     *
     * @return light.
     */
    public Boolean getLight() {
        return light;
    }

}
