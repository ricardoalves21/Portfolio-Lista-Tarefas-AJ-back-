package com.ricardo;

import com.ricardo.enums.Etapa;
import com.ricardo.model.Tarefa;
import com.ricardo.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	//A anotação 'Bean' diz pro spring gerenciar o ciclo de vida deste fluxo
	//Este comando 'CommandLineRunner' coloca este comando pra ser executado assim que esta aplicação subir
//	@Bean
//	CommandLineRunner initDataBase(TarefaRepository tarefaRepository) {
//
//		return args -> {
//			tarefaRepository.deleteAll();
//
//			Tarefa t = new Tarefa();
//			t.setConteudo("Criar portfólio Java");
//			t.setResponsavel("Ricardo Alves");
//			t.setEtapa(Etapa.AFAZER);
//
//			tarefaRepository.save(t);
//		};
//
//	}

}
