package matheus.adriano.turmapi.adapters.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateTurmaDTO {
        @NotBlank
        @Length(min = 3)
        private  String sigla;
        @NotNull
        private  Integer ano;
        @NotNull

    private  Integer semestre;
        @NotBlank
        @Length(min = 3)
        private String nome;
    @NotNull

    private Integer minVagas;
    @NotNull

    private  Integer maxVagas;
        public CreateTurmaDTO(String sigla, Integer ano, Integer semestre, String nome, Integer minVagas, Integer maxVagas) {
            this.sigla = sigla;
            this.ano = ano;
            this.semestre = semestre;
            this.nome = nome;
            this.minVagas = minVagas;
            this.maxVagas = maxVagas;
        }
}
