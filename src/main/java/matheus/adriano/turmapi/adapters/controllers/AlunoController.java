package matheus.adriano.turmapi.adapters.controllers;

import jakarta.validation.Valid;
import matheus.adriano.turmapi.application.AlunoService;
import matheus.adriano.turmapi.domain.entities.Aluno;
import matheus.adriano.turmapi.domain.entities.Matricula;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService= alunoService;
    }


    @PostMapping()
    public Aluno create(@RequestBody @Valid CreateAlunoDto aluno){
        return this.alunoService.create(aluno.getCpf(), aluno.getNome());
    }

    @PostMapping ("/{cpf}/matriculas")
    public Matricula matricularAluno(@PathVariable String cpf, @RequestBody CreateMatriculaDto matricula){
        return this.alunoService.matricularAluno(cpf,matricula.getSiglaTurma());
    }

    @GetMapping("/{cpf}/matriculas/{id}")
    public Matricula getMatricula(@PathVariable String id){
        return this.alunoService.getMatriculas(id);
    }

    @GetMapping("/{cpf}/matriculas")
    public List<Matricula> getMatricula(){
        return this.alunoService.getMatriculass();
    }

    @GetMapping("/{cpf}")
    public Aluno getByCpf(@PathVariable String cpf){

        Aluno aluno =  this.alunoService.getByCpf(cpf);
        return aluno;
    }

    @GetMapping()
    public List<Aluno> findAll(){
        return this.alunoService.findAll();
    }

}
