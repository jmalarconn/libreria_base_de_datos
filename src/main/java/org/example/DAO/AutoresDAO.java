package org.example.DAO;

import org.example.model.Autores;

import java.util.List;

public interface AutoresDAO {
    void agregarAutor(Autores autor);
    List<Autores> obtenerTodos();
}