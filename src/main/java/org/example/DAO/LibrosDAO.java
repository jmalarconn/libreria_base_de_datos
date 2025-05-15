package org.example.DAO;

import org.example.model.Libros;

import java.util.List;

public interface LibrosDAO {
    void insertar(Libros libro);
    List<Libros> listarTodos();

    List<Libros> obtenerTodos();
}