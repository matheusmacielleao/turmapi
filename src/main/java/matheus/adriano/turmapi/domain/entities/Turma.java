package matheus.adriano.turmapi.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Turma {
    @Id
    private String id;
    @Column
    private  String sigla;
    @Column
    private  Integer ano;
    @Column
    private  Integer semestre;
    @Column
    private String nome;
    @Column
    private Integer minVagas;
    @Column
    private  Integer maxVagas;
    public Turma(String sigla, Integer ano, Integer semestre, String nome, Integer minVagas, Integer maxVagas) {
        this.id = sigla+"-"+ano+"-"+semestre;
        this.sigla = sigla;
        this.ano = ano;
        this.semestre = semestre;
        this.nome = nome;
        this.minVagas = minVagas;
        this.maxVagas = maxVagas;
    }
    public Turma(){}

}
