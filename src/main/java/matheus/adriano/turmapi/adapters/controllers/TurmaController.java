package matheus.adriano.turmapi.adapters.controllers;

import jakarta.validation.Valid;
import matheus.adriano.turmapi.application.TurmaService;
import matheus.adriano.turmapi.domain.entities.Turma;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private TurmaService turmaService;

    public TurmaController(TurmaService turma){
        this.turmaService = turma;
    }

    @PostMapping()
    public Turma create(@RequestBody @Valid CreateTurmaDTO turma){
        return this.turmaService.create(turma.getNome(), turma.getSigla(), turma.getAno(), turma.getSemestre(), turma.getMinVagas(), turma.getMaxVagas());
    }

    @GetMapping()
    public List<Turma> find(@RequestParam(required = false) String sigla, @RequestParam(required = false) Integer ano){
        return this.turmaService.find(sigla,ano);
    }

    @GetMapping("/{id}")
    public Turma findById(@PathVariable String id){
        return this.turmaService.findById(id);
    }
}
