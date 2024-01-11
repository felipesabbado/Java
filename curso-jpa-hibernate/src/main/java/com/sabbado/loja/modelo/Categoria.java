package com.sabbado.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @EmbeddedId
    private CategoriaId id;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.id = new CategoriaId(nome, "xpto");
    }

    public CategoriaId getId() {
        return id;
    }

    public String getNome() {
        return id.getNome();
    }

    public String getTipo() {
        return id.getTipo();
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " - " +
               "Modelo: " + this.getTipo();
    }
}
