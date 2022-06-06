package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Aluno;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao implements IAlunoMatDao<Aluno>{

    private SessionFactory sf;

    public AlunoDao(SessionFactory sf){
        this.sf = sf;
    }

    @Override
    public void insert(Aluno par) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(par);
        transaction.commit();
    }

    @Override
    public void update(Aluno par) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(par);
        transaction.commit();
    }

    @Override
    public void delete(Aluno par) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(par);
        transaction.commit();
    }

    @Override
    public Aluno search(Aluno par) {
        EntityManager entityManager = sf.createEntityManager();
        par = entityManager.find(Aluno.class, par.getNome());
        return par;
    }

    @Override
    public List lista() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM alunos");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Aluno a = new Aluno();
            a.setRa(obj[0].toString());
            a.setNome(obj[1].toString());
            a.setTelefone(obj[2].toString());
            a.setPosicaoVestibular(Integer.parseInt(obj[3].toString()));

            alunos.add(a);
        }
        return alunos;
    }
}
