package by.vit.roomswithbulbs.entity;

import org.springframework.data.annotation.Id;

/**
 * Parent class for all application entities.
 *
 * @author Vitaly Lobatsevich
 */
public class Entity {

    /** Entity identifier. */
    @Id
    protected String id;

    /** Default constructor. */
    public Entity() {
        id = null;
    }

    /**
     * Parameterized constructor.
     *
     * @param id - entity id.
     */
    public Entity(final String id) {
        this.id = id;
    }

    /**
     * id setter.
     *
     * @param id - entity id.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * id getter.
     *
     * @return id.
     */
    public String getId() {
        return id;
    }

}
