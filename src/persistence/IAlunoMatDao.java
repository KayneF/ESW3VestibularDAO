package persistence;

import java.util.List;

public interface IAlunoMatDao<T> {

    void insert(T par);
    void update(T par);
    void delete(T par);
    T search(T par);
    List<T> lista();

}
