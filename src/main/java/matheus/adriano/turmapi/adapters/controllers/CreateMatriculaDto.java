package matheus.adriano.turmapi.adapters.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMatriculaDto {
    @NotBlank
    protected String siglaTurma;

    public CreateMatriculaDto(String sigla) {
        this.siglaTurma = sigla;
    }

    public CreateMatriculaDto() {
    }
}
