package by.vit.roomswithbulbs.entity;

/**
 * Class Room.
 *
 * Represents room.
 *
 * @author Vitaly Lobatsevich
 */
public class Room {

    /** Room name. */
    private String name;

    /** Room country. */
    private Country country;

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
    public Room(final String name, final Country country) {
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

}
