package jader.totvs.tasksapi.dto;

import jader.totvs.tasksapi.model.Task;

import java.time.LocalDateTime;
import java.util.Date;

public class TaskDto {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;
    private String prioridade;
    private String responsavel;
    private String categoria;
    private LocalDateTime prazo;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public static TaskDto fromEntity(Task task) {
            TaskDto dto = new TaskDto();
            dto.setId(task.getId());
            dto.setTitulo(task.getTitulo());
            dto.setDescricao(task.getDescricao());
            dto.setConcluida(task.isConcluida());
            dto.setDataCriacao(task.getDataCriacao());
            dto.setDataConclusao(task.getDataConclusao());
            dto.setPrioridade(task.getPrioridade());
            dto.setResponsavel(task.getResponsavel());
            dto.setCategoria(task.getCategoria());
            dto.setPrazo(task.getPrazo());
            return dto;
        }

        public Task toEntity() {
            Task task = new Task();
            if (this.id != null) {
                task.setId(this.id);
            }
            task.setTitulo(this.getTitulo());
            task.setDescricao(this.getDescricao());
            task.setConcluida(this.isConcluida());
            task.setDataCriacao(this.getDataCriacao());
            task.setDataConclusao(this.getDataConclusao());
            task.setPrioridade(this.getPrioridade());
            task.setResponsavel(this.getResponsavel());
            task.setCategoria(this.getCategoria());
            task.setPrazo(this.getPrazo());
            return task;
        }
}
