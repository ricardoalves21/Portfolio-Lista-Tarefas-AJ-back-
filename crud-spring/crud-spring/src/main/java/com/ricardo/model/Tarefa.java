package com.ricardo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ricardo.enums.Etapa;
import com.ricardo.enums.converters.EtapaConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)
    @NotNull
    @Length(min = 5, max = 200)
    private String conteudo;
    
    @Column(length = 100, nullable = false)
    @NotNull
    @Length(min = 5, max = 100)
    private String responsavel;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = EtapaConverter.class)
    private Etapa etapa;

}
