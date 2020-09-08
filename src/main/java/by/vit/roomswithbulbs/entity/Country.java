package by.vit.roomswithbulbs.entity;

/**
 * Class Country.
 *
 * @author Vitaly Lobatsevich
 */
public class Country extends Entity {

    /** Country name. */
    private String name;

    /** Default constructor. */
    public Country() {
        super();
        name = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param name - country name.
     */
    public Country(final String id, final String name) {
        super(id);
        this.name = name;
    }

    /**
     * name setter.
     *
     * @param name - country name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * name getter.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

}
