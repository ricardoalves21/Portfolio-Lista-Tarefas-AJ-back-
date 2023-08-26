package com.ricardo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record TarefaDTO(
        @JsonProperty("id")
        Long id,

        @NotBlank
        @NotNull
        @Length(min = 5, max = 200)
        String conteudo,

        @NotBlank
        @NotNull
        @Length(min = 5, max = 100)
        String responsavel,

        @NotNull
        @Length(max = 10)
        @Pattern(regexp = "etapa1|etapa2|etapa3")
        String etapa
){}
