package utils;

import org.example.DAO.LibrosDAO;
import org.example.model.Libros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImplementsLibros implements LibrosDAO {

    @Override
    public void insertar(Libros libros) {
        String sql = "INSERT INTO libros(titulo, LibroId, Genero , AutorId ) VALUES (?, ?, ? , ? )";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libros.getTitulo());
            ps.setString(2, libros.getLibroId());
            ps.setString(3, libros.getGenero());
            ps.setString(4, libros.getAutorId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Libros> listarTodos() {
        return List.of();
    }


    @Override
    public List<Libros> obtenerTodos() {
        List<Libros> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Libros libro = new Libros();
                libro.setLibroId(rs.getString("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutorId(rs.getString("AutorId"));
                libro.setGenero(rs.getString("Genero"));
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
}
}