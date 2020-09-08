package by.vit.roomswithbulbs.entity;

/**
 * Class Room.
 *
 * Room entity.
 *
 * @author Vitaly Lobatsevich
 */
public class Room {

    /** Room name. */
    private String name;

    /** Room country. */
    private String country;

    /** Default constructor. */
    public Room() {
        name = null;
        country = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param name - room name.
     * @param country - room country.
     */
    public Room(final String name, final String country) {
        this.name = name;
        this.country = country;
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
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * Country getter.
     *
     * @return country.
     */
    public String getCountry() {
        return country;
    }

}
