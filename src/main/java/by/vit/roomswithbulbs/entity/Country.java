package by.vit.roomswithbulbs.entity;

/**
 * Class Country.
 *
 * Represents a country as a name and alpha code.
 *
 * @author Vitaly Lobatsevich
 */
public class Country {

    /** Country name. */
    private String name;

    /** Alpha 2 code. */
    private String alpha2;

    /** Default constructor. */
    public Country() {
        name = null;
        alpha2 = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param name - country name.
     * @param alpha2 - alpha 2 country code.
     */
    public Country(final String name, final String alpha2) {
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
     * @param alpha2 - alpha 2 country code.
     */
    public void setAlpha2(final String alpha2) {
        this.alpha2 = alpha2;
    }

    /**
     * Alpha2 getter.
     *
     * @return Alpha2.
     */
    public String getAlpha2() {
        return alpha2;
    }

}
