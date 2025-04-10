package jader.totvs.tasksapi.repository;

import jader.totvs.tasksapi.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAllBy();
    Task findById(long id);
    List<Task> findByResponsavel(String responsavel);
    List<Task> findByCategoria(String categoria);
    List<Task> findByPrioridade(String prioridade);
    List<Task> findByConcluida(boolean concluida);
    void deleteById(long id);

}
