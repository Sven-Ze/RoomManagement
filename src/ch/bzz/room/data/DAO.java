package ch.bzz.room.data;

import ch.bzz.room.util.Result;

import java.util.List;

/**
 * short description
 * <p>
 * RoomManagement
 *
 * @author Tizian
 * @version 1.0
 * @since 01.03.21
 */
public interface DAO<T, K> {
    /**
     * gets all datasets in a table
     * @return list of model-objects
     */
    default List<T> getAll() {
        throw new UnsupportedOperationException();
    }

    /**
     * gets a single datasets in a table
     * @param k  primary key
     * @return model-object
     */
    default T getEntity(K k) {
        throw new UnsupportedOperationException();
    }

    /**
     * adds an object to the database entity
     * @param t model-object
     * @return Result-code
     */
    default Result add (T t) {
        throw new UnsupportedOperationException();
    }

    /**
     * saves an object to the database entity
     * @param t model-object
     * @return Result-code
     */
    default Result save (T t) {
        throw new UnsupportedOperationException();
    }

    /**
     * delets an entity in the database
     * @param k primary key
     * @return Result-code
     */
    default Result delete (K k) {
        throw new UnsupportedOperationException();
    }

}
