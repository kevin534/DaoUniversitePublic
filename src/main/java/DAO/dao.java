package DAO;

import exceptions.DataAccessException;
import exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface defines the generic method for DAO Objects.
 *
 * @param <E> is the type of entities managed by the DAO
 */
public interface dao<E> {
    /**
     * Update the entity in the database with the parameter.
     *
     * @param e The entity to be updated. The id is used and cannot be updated.
     * @throws DataAccessException If there is a data access error (see message).
     */
    E persist(E e) throws DataAccessException;
    void update(E e) throws DataAccessException;
    /**
     * Return the complete list of entities managed by the DAO from the database.
     *
     * @return the list of entities managed by the DAO.
     * @throws DataAccessException If there is a data access error (see message).
     */
    List<E> findAll() throws DataAccessException;
    List<E> findAllS() throws DataAccessException;

}
