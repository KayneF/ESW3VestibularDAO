package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @Column(name = "ra")
    @NotNull
    private String ra;

    @Column(name = "nome_aluno")
    @NotNull
    private String nome;

    @Column(name = "telefone_aluno")
    @NotNull
    private String telefone;

    @Column(name = "posicao")
    @NotNull
    private int posicaoVestibular;

    // ====================================================================

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getPosicaoVestibular() {
        return posicaoVestibular;
    }

    public void setPosicaoVestibular(int posicaoVestibular) {
        this.posicaoVestibular = posicaoVestibular;
    }
}
