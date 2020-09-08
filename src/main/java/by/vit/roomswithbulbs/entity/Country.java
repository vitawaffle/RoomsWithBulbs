package by.vit.roomswithbulbs.entity;

/**
 * Class Country.
 *
 * Contains country name.
 *
 * @author Vitaly Lobatsevich
 */
public class Country {

    /** Country name. */
    private String name;

    /** Default constructor. */
    public Country() {
        name = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param name - country name.
     */
    public Country(final String name) {
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
