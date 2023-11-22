package matheus.adriano.turmapi.adapters.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAlunoDto {
    @NotBlank
    protected String cpf;
    @NotBlank
    protected String nome;

    public CreateAlunoDto(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

}
