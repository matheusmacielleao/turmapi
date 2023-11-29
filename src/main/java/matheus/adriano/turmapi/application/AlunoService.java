package matheus.adriano.turmapi.application;

import jakarta.validation.Valid;
import matheus.adriano.turmapi.adapters.controllers.CreateAlunoDto;
import matheus.adriano.turmapi.domain.entities.Aluno;
import matheus.adriano.turmapi.domain.entities.Matricula;
import matheus.adriano.turmapi.domain.entities.Turma;
import matheus.adriano.turmapi.infra.repositories.AlunoRepository;
import matheus.adriano.turmapi.infra.repositories.MatriculaRepository;
import matheus.adriano.turmapi.infra.repositories.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final  TurmaRepository turmaRepository;
    private final MatriculaRepository matriculaRepository;
    public AlunoService (AlunoRepository alunoRepository, TurmaRepository turmaRepository, MatriculaRepository matriculaRepository){
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
        this.matriculaRepository = matriculaRepository;
    }

    public Aluno create (String cpf, String nome) {

        Aluno aluno = new Aluno(cpf, nome);
        Optional<Aluno> alunoExiste = alunoRepository.findById(aluno.getCpf());
            if(alunoExiste.isPresent()){
                throw new RuntimeException("Aluno com esse cpf já existe");
            }
        return alunoRepository.save(aluno);
    }
    public Matricula matricularAluno(String cpf, String siglaTurma){
        Aluno aluno = alunoRepository.findById(cpf).orElseThrow(()->new RuntimeException("Aluno não existe"));
        Turma turma = turmaRepository.findById(siglaTurma).orElseThrow(()->new RuntimeException("Turma não existe"));
        Matricula matricula = new Matricula(aluno, turma);
        matriculaRepository.save(matricula);
        return matricula;
    }
    public Aluno getByCpf (String cpf) {

       Aluno a = alunoRepository.findById(cpf).orElseThrow(()->new RuntimeException("Aluno não existe"));

       return a;
    }

    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }


    public Matricula getMatriculas(String id) {
        return matriculaRepository.findById(id).orElseThrow(()->new RuntimeException("Matricula não existe"));
    }

    public List<Matricula> getMatriculass() {
        return matriculaRepository.findAll();
    }
}
