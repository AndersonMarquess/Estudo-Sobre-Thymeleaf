package com.andersonmarques.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTOS") //Nome da tabela do banco de dados
public class Departamento extends AbstractEntity<Long> {

    //O Nome da coluna, not null, unique, varchar(60)
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}