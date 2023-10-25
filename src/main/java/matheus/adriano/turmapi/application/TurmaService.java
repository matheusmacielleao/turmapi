package matheus.adriano.turmapi.application;

import matheus.adriano.turmapi.domain.entities.Turma;
import matheus.adriano.turmapi.infra.repositories.TurmaRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    private TurmaRepository turmaRepo;
    public  TurmaService(TurmaRepository turmaRepo){
        this.turmaRepo = turmaRepo;
    }


    public Turma create(String nome, String sigla, Integer ano, Integer semestre, Integer minVagas, Integer maxVagas) {

        if(semestre>2 || semestre<1){
            throw  new RuntimeException("Semestre so pode ser 1 ou 2 ");
        }

        Turma novaTurma = new Turma(sigla,ano,semestre,nome,minVagas,maxVagas);
        Optional<Turma> siglajaexiste = this.turmaRepo.findById(novaTurma.getId());

        if(siglajaexiste.isPresent()){
            throw new RuntimeException("Essa sigla já existe");
        }

        return turmaRepo.save(novaTurma);
    }

    public List<Turma> find(String sigla, Integer ano){
        Turma t = new Turma();
        if(ano != null){
            t.setAno(ano);
        }
        if(sigla != null){
            t.setSigla(sigla);
        }
        Example<Turma> example = Example.of(t);
        return turmaRepo.findAll(example);
    }

    public Turma findById(String id)  {
        return this.turmaRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Essa turma com essa sigla não existe"));
    }
}
