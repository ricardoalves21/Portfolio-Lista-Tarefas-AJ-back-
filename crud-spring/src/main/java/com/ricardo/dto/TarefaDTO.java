package com.ricardo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ricardo.enums.Etapa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

//Uma classe 'record' trata-se de uma classe imutável
//Este tipo de classe 'record' não possui construtores vazios nem métodos setter.
//Em uma classe 'record' o método GET não possui a palavra get
//Uma classe 'record' é a extensão de uma classe do Java chamada Record, por isso ela não pode ser estendida.
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
        @Pattern(regexp = "a fazer|fazendo|feito")
        String etapa
){}
