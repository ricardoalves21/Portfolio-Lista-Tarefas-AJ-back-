package com.ricardo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ricardo.enums.Etapa;
import com.ricardo.enums.converters.EtapaConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data //Esta anotação do Lombok é equivalente a getter, setter, equalsAndHashCode
@Entity //Pertence ao pacote JPA, avisa ao spring que esta classe é uma entidade mapeada para o banco de dados
//@SQLDelete(sql = "UPDATE Tarefa SET status='inativo' WHERE id=?")
//@Where(clause = "status = 'ativo'")
public class Tarefa {

    @Id //Informando ao spring que este campo será a chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.AUTO) //Diz para o banco de dados que a chave será gerada automaticamente
    @JsonProperty("_id") //Faz o ajuste entre o front-end e o back-end em relação aos nomes dados aos atributos em ambos os lados.
    private Long id;

    @Column(length = 200, nullable = false)
    @NotNull
    @Length(min = 5, max = 200)
    private String conteudo;

    //Informa que é uma coluna da tabela e que o tamanho máximo é 200 caracteres e não aceita null
    @Column(length = 100, nullable = false)
    @NotNull
    @Length(min = 5, max = 100)
    private String responsavel;

    @NotNull
    @Column(length = 10, nullable = false)
    @Convert(converter = EtapaConverter.class)
    private Etapa etapa;

}
