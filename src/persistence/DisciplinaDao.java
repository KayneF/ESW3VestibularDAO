package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Disciplina;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDao implements IAlunoDiscDao<Disciplina> {

    private SessionFactory sf;

    public DisciplinaDao(SessionFactory sf){
        this.sf = sf;
    }

    @Override
    public void insert(Disciplina par) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(par);
        transaction.commit();
    }

    @Override
    public void update(Disciplina par) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(par);
        transaction.commit();
    }

    @Override
    public void delete(Disciplina par) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(par);
        transaction.commit();
    }

    @Override
    public Disciplina search(Disciplina par) {
        EntityManager entityManager = sf.createEntityManager();
        par = entityManager.find(Disciplina.class, par.getNomeDisc());
        return par;
    }

    @Override
    public List lista() {
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM disciplinas");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Disciplina d = new Disciplina();
            d.setCodDisc(Integer.parseInt(obj[0].toString()));
            d.setNomeDisc(obj[1].toString());
            d.setCargaHoraria(Integer.parseInt(obj[2].toString()));

            disciplinas.add(d);
        }
        return disciplinas;
    }
}
