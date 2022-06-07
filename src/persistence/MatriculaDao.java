package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Aluno;
import model.Disciplina;
import model.Matricula;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class MatriculaDao implements IMatriculaDao<Matricula>{

    private SessionFactory sf;

    public MatriculaDao(SessionFactory sf){
        this.sf = sf;
    }

    @Override
    public void insert(Matricula matricula) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(matricula);
        transaction.commit();
    }

    @Override
    public Matricula delete(Matricula matricula) {

        return null;
    }

    @Override
    public List<Matricula> list(Matricula matricula) {
        Disciplina disciplina = new Disciplina();
        Aluno aluno = new Aluno();
        List<Matricula> matriculas = new ArrayList<Matricula>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM matricula ");
        buffer.append("INNER JOIN aluno ON aluno.ra_aluno = matricula.ra_aluno ");
        buffer.append("INNER JOIN disciplina ON disciplina.codigo_disciplina = matricula.codigo_disciplina ");
        buffer.append("WHERE nome_disciplina = " + disciplina.getNomeDisc());
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            matricula.setAno(Integer.parseInt(obj[0].toString()));
            matricula.setSemestre(Integer.parseInt(obj[1].toString()));
            aluno.setRa(obj[2].toString());
            aluno.setNome(obj[3].toString());
            aluno.setTelefone(obj[4].toString());
            aluno.setPosicaoVestibular(Integer.parseInt(obj[5].toString()));
            disciplina.setNomeDisc(obj[6].toString());
            disciplina.setCodDisc(Integer.parseInt(obj[7].toString()));
            disciplina.setCargaHoraria(Integer.parseInt(obj[8].toString()));
        }
        return matriculas;
    }
}
