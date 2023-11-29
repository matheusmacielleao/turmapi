package matheus.adriano.turmapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

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
    @JsonIgnore
    @OneToMany(mappedBy = "turma")
    private List<Matricula> matriculas;
    public Turma(String sigla, Integer ano, Integer semestre, String nome, Integer minVagas, Integer maxVagas) {
        this.id = sigla+"-"+ano+"-"+semestre;
        this.sigla = sigla;
        this.ano = ano;
        this.semestre = semestre;
        this.nome = nome;
        this.minVagas = minVagas;
        this.maxVagas = maxVagas;
        this.matriculas = new ArrayList<>();

    }
    public Turma(){}

}
