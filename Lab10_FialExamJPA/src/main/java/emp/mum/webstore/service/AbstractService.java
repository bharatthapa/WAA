package emp.mum.webstore.service;

import java.util.List;

/**
 *
 * @author Bharat
 * @param <T>
 * @param <ID>
 */
public interface AbstractService<T, ID> {

    public void add(T t);

    public void update(T t);

    public void remove(T t);

    public T findOne(ID id);

    public List<T> findAll();

}
