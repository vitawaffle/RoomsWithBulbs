package by.vit.roomswithbulbs.entity;

/**
 * Light entity.
 *
 * @author Vitaly Lobatsevich
 */
public class Light {

    /** Is the light on. */
    private Boolean on;

    /**
     * Constructor.
     *
     * @param on - is the light on.
     */
    public Light(final Boolean on) {
        this.on = on;
    }

    /**
     * On setter.
     *
     * @param on - is the light on.
     */
    public void setOn(final Boolean on) {
        this.on = on;
    }

    /**
     * On getter.
     *
     * @return is the light on.
     */
    public Boolean getOn() {
        return on;
    }

}
