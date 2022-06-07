package persistence;

import java.util.List;

public interface IAlunoDiscDao<T> {

    void insert(T par);
    void update(T par);
    void delete(T par);
    T search(T par);
    List<T> lista();

}
