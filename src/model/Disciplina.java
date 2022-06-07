package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "disciplina")
public class Disciplina {

    @Id
    @Column(name = "codigo_disciplina")
    @NotNull
    private int CodDisc;

    @Column(name = "nome_disciplina")
    @NotNull
    private String nomeDisc;

    @Column(name = "carga_horaria")
    @NotNull
    private int cargaHoraria;

    // ====================================================================

    public int getCodDisc() {
        return CodDisc;
    }

    public void setCodDisc(int codDisc) {
        CodDisc = codDisc;
    }

    public String getNomeDisc() {
        return nomeDisc;
    }

    public void setNomeDisc(String nomeDisc) {
        this.nomeDisc = nomeDisc;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
