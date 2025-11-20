package org.example.ApiEscolaIngles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A descrição da tarefa é obrigatória")
    private String description;

    @NotBlank(message = "A data de entrega é obrigatoria")
    @Future(message = "A data de entrega deve ser no futuro")
    private LocalDate dueDate;

    //(muitos-pra-Um)
    @ManyToOne
    @JoinColumn(name = "student_id")

    //Evita o loop infinito quando transformado em JSON
    @JsonIgnore
    private Student student;

    public Homework(){
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

}
