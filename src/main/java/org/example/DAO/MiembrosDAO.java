package org.example.DAO;

import org.example.model.Miembros;

import java.util.List;

public interface MiembrosDAO {
    void insertar(Miembros miembro);
    List<Miembros> obtenerTodos();

}
