package by.vit.roomswithbulbs.entity;

/**
 * Country entity.
 *
 * @author Vitaly Lobatsevich
 */
public class Country extends Entity {

    /** Country name. */
    private String name;

    /**
     * Default constructor.
     */
    public Country() {
        id = null;
        name = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param id - country id.
     * @param name - country name.
     */
    public Country(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Name setter.
     *
     * @param name - country name.
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

}
