package persistence;

import model.Matricula;
import org.hibernate.SessionFactory;

import java.util.List;

public class MatriculaDao implements IMatriculaDao<Matricula>{

    private SessionFactory sf;

    public MatriculaDao(SessionFactory sf){
        this.sf = sf;
    }

    @Override
    public void insert(Matricula matricula) {

    }

    @Override
    public void delete(Matricula matricula) {

    }

    @Override
    public List list() {
        return null;
    }
}
