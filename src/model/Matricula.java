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

    @Column(name = "ano")
    @NotNull
    private int ano;

    @Column(name = "semestre")
    @NotNull
    private int semestre;

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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
