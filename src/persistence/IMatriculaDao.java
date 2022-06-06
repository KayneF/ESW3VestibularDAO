package persistence;

import java.util.List;

public interface IMatriculaDao<T>{

    void insert(T matricula);
    void delete(T matricula);
    List<T> list();

}
