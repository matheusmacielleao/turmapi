package matheus.adriano.turmapi.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Matricula {
    @Id
    protected UUID id;
    @ManyToOne
//    @JsonIgnoreProperties("matriculas")
    @JoinColumn(name="aluno_cpf")
    protected Aluno aluno;

    @ManyToOne
    @JoinColumn(name="turma_id")
//    @JsonIgnoreProperties("matriculas")
    protected Turma turma;

    public Matricula(Aluno aluno, Turma turma){
        this.id = UUID.randomUUID();
        this.aluno = aluno;
        this.turma = turma;
    }

    public Matricula(){}
}
