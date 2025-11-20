package org.example.ApiEscolaIngles;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody @Valid Student student) {
        Student alunoSalvo = repository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    /*
     * GET - Listar todos os Alunos
     * Endereço final: GET http://localhost:8080/students
     */
    @GetMapping
    public List<Student> listAll() {
        return repository.findAll();
    }
}