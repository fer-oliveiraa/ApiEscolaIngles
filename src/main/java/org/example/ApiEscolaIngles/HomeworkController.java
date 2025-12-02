package org.example.ApiEscolaIngles;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class HomeworkController {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Autowired
    private StudentRepository studentRepository;

    //Cadastrando uma tarefa pra um aluno
    //POST /stundents/{stundetId}/homework

    @PostMapping("/students/{studentId}/homework")
    public ResponseEntity<Homework> create(@PathVariable("studentId") Long studentId, @RequestBody @Valid Homework homework) {

        //Buscando o aluno pelo ID, se não existir e lançado um alerta 404.
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));


        //"Liga" a tarefa ao aluno encontrado
        homework.setStudent(student);

        //Salva a tarefa no banco
        Homework tarefaSalva = homeworkRepository.save(homework);

        //Retorna 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);

    }
}
