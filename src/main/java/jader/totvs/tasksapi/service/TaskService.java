package jader.totvs.tasksapi.service;

import jader.totvs.tasksapi.dto.TaskDto;
import jader.totvs.tasksapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public TaskDto getById(long id) {
        return TaskDto.fromEntity(taskRepository.findById(id));
    }

    public TaskDto save(TaskDto taskDTO) {
        return TaskDto.fromEntity(taskRepository.save(taskDTO.toEntity()));
    }

    public TaskDto update(long id, TaskDto taskDTO) {
        //add save logic
        TaskDto task = getById(id);
        if (task != null) {
            if (taskDTO.getTitulo() != null) task.setTitulo(taskDTO.getTitulo());
            if (taskDTO.getDescricao() != null) task.setDescricao(taskDTO.getDescricao());
            task.setConcluida(taskDTO.isConcluida());
            if (taskDTO.getDataCriacao() != null) task.setDataCriacao(taskDTO.getDataCriacao());
            if (taskDTO.getDataConclusao() != null) task.setDataConclusao(taskDTO.getDataConclusao());
            if (taskDTO.getPrioridade() != null) task.setPrioridade(taskDTO.getPrioridade());
            if (taskDTO.getResponsavel() != null) task.setResponsavel(taskDTO.getResponsavel());
            if (taskDTO.getCategoria() != null) task.setCategoria(taskDTO.getCategoria());
            if (taskDTO.getPrazo() != null) task.setPrazo(taskDTO.getPrazo());

            return TaskDto.fromEntity(taskRepository.save(task.toEntity()));
        }
        return null;
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }

    public List<TaskDto> getAll() {
        return taskRepository.findAllBy().stream().map( TaskDto::fromEntity ).collect(Collectors.toList());
    }
}
