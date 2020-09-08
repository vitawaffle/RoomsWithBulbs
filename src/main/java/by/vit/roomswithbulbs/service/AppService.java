package by.vit.roomswithbulbs.service;

/**
 * Parent interface for all application services.
 *
 * @param <T> - entity type.
 * @param <ID> - entity id type.
 *
 * @author Vitaly Lobatsevich
 */
public interface AppService<T, ID> {

    /**
     * Returns entity by id.
     *
     * @param id - entity id.
     * @return entity or null.
     */
    T getById(ID id);

    /**
     * Saves entity.
     *
     * @param t - entity to save.
     * @return saved entity id.
     */
    ID save(T t);

    /**
     * Deletes entity by id.
     *
     * @param id - entity id.
     */
    void deleteById(ID id);

}
