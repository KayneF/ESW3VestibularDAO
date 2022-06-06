package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @Column(name = "ra_aluno")
    @NotNull
    private Aluno raAluno;

    @Id
    @Column(name = "codigo_disciplina")
    @NotNull
    private Disciplina codDisciplina;

    // ====================================================================

    public Aluno getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(Aluno raAluno) {
        this.raAluno = raAluno;
    }

    public Disciplina getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Disciplina codDisciplina) {
        this.codDisciplina = codDisciplina;
    }
}
