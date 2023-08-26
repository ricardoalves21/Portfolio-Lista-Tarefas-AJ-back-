package com.ricardo.service;

import com.ricardo.dto.TarefaDTO;
import com.ricardo.dto.mapper.TarefaMapper;
import com.ricardo.exception.RecordNotFoundException;
import com.ricardo.repository.TarefaRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;


    public TarefaService(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    public List<TarefaDTO> list() {
        return tarefaRepository.findAll()
                .stream()
                .map(tarefaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TarefaDTO buscarTarefa(@NotNull @Positive Long id) {
        return tarefaRepository.findById(id).map(tarefaMapper::toDTO)
                .orElseThrow( () -> new RecordNotFoundException(id) );
    }

    public TarefaDTO create(@Valid @NotNull TarefaDTO tarefa) {
        return tarefaMapper.toDTO(tarefaRepository.save(tarefaMapper.toEntity(tarefa)));
    }

    public TarefaDTO atualizaTarefa(@NotNull @Positive Long id, @Valid @NotNull TarefaDTO tarefa) {
        return tarefaRepository.findById(id)
                .map(registroEncontrado -> {
                    registroEncontrado.setResponsavel(tarefa.responsavel());
                    registroEncontrado.setEtapa(tarefaMapper.convertTarefaValue(tarefa.etapa()));
                    registroEncontrado.setConteudo(tarefa.conteudo());
                    return tarefaMapper.toDTO(tarefaRepository.save(registroEncontrado));
                }).orElseThrow( () -> new RecordNotFoundException(id) );
    }

    public void removeTarefa(@NotNull @Positive Long id) {
        tarefaRepository.delete(tarefaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
