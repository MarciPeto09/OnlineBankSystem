package utilities;

import java.util.List;

public interface InterfaceRepo<T> {
    public void add(T type);
    public void remove(int id);
    public T findById(int id);
    public void update(T object, int id);
    public List<T> findAll();
}
