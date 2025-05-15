package org.example.DAO;

import org.example.model.Prestamos;

import java.util.List;

public interface PrestamosDAO {
    void insertar(Prestamos prestamo);
    List<Prestamos> obtenerTodos();

}