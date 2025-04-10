package jader.totvs.tasksapi.service;

import jader.totvs.tasksapi.dto.TaskDto;
import jader.totvs.tasksapi.model.Task;
import jader.totvs.tasksapi.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetById() {
        Task task = new Task();
        task.setId(1L);
        when(taskRepository.findById(1L)).thenReturn(task);

        TaskDto taskDto = taskService.getById(1L);
        assertEquals(1L, taskDto.getId());
    }

    @Test
    void testSave() {
        TaskDto createTaskDto = new TaskDto();
        createTaskDto.setTitulo("Test Task");
        createTaskDto.setDescricao("Test Description");
        createTaskDto.setDataCriacao(LocalDateTime.now());

        Task task = new Task();
        task.setId(1L);
        when(taskRepository.save(any(Task.class))).thenReturn(task);

        TaskDto taskDto = taskService.save(createTaskDto);
        assertEquals(1L, taskDto.getId());
    }

    @Test
    void testUpdate() {
        Task task = new Task();
        task.setId(1L);
        when(taskRepository.findById(1L)).thenReturn(task);

        TaskDto taskDto = new TaskDto();
        taskDto.setId(1L);
        taskDto.setTitulo("Updated Task");
        taskDto.setDescricao("Updated Description");

        when(taskRepository.save(any(Task.class))).thenReturn(taskDto.toEntity());

        TaskDto updatedTaskDto = taskService.update(1L, taskDto);
        assertEquals("Updated Task", updatedTaskDto.getTitulo());
    }

    @Test
    void testDelete() {
        doNothing().when(taskRepository).deleteById(1L);
        taskService.delete(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }
}