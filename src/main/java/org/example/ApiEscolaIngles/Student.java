package org.example.ApiEscolaIngles;

// Importa as anotações do JPA (Java Persistence API)

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Importa as anotações do Validation (adicionadas no start.spring.io)
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.annotation.processing.Generated;

/*
@Entity diz para o Spring Data JPA: essa classe e um "molde" para uma
tabela no banco de dados. Criando automaticamente uma tabela

*/

@Entity
public class Student {
    //Chave primária
    @Id

    //Gera um ID único (auto-incremento)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Anotação de "Validation" aluno não podera ser salvo sem nome
    @NotBlank(message = "O nome é obrigatório")

    //Regra de validação (min = 3, max = 100)
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String name;

    //Regra, o Spring vai verificar se o texto tem um formato de e-mail válido
    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "Por favor, insira um e-mail válido")
    private String email;


    //Construtor vazio para o JPA
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
