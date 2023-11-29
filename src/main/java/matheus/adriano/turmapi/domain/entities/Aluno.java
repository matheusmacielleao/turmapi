package matheus.adriano.turmapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Aluno {
    @Id
    protected String cpf;
    @Column
    protected String nome;
//    @OneToMany(mappedBy = "aluno")
//    @JsonIgnore
//    protected List<Matricula> matriculas;

    public Aluno (String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
//        this.matriculas = new ArrayList<>();
    }

    public  Aluno(){}
}