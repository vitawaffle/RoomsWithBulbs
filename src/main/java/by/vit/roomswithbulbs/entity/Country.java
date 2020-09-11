package by.vit.roomswithbulbs.entity;

/**
 * Country entity.
 *
 * @author Vitaly Lobatsevich
 */
public class Country extends Entity {

    /** Country name. */
    private String name;

    /** Alpha2 country code. */
    private String alpha2;

    /**
     * Default constructor.
     */
    public Country() {
        id = null;
        name = null;
        alpha2 = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param id - country id.
     * @param name - country name.
     * @param alpha2 - alpha2 country code.
     */
    public Country(final String id, final String name, final String alpha2) {
        this.id = id;
        this.name = name;
        this.alpha2 = alpha2;
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

    /**
     * Alpha2 setter.
     *
     * @param alpha2 - alpha2 country code.
     */
    public void setAlpha2(final String alpha2) {
        this.alpha2 = alpha2;
    }

    /**
     * Alpha2 getter.
     *
     * @return alpha2 country code.
     */
    public String getAlpha2() {
        return alpha2;
    }

}
