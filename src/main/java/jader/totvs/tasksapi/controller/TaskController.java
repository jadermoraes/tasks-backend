package jader.totvs.tasksapi.controller;

import jader.totvs.tasksapi.dto.TaskDto;
import jader.totvs.tasksapi.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping()
    @ResponseBody
    public List<TaskDto> findAll() {
        return  taskService.getAll();
    }

    @PostMapping()
    @ResponseBody
    public TaskDto create(@RequestBody TaskDto taskDTO) {
        return taskService.save(taskDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TaskDto findById(@PathVariable long id) {
        return taskService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public TaskDto update(@PathVariable long id, @RequestBody TaskDto taskDTO) {
        return taskService.update(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable long id) {
        taskService.delete(id);
    }
}
