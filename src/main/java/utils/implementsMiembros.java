package utils;

import org.example.DAO.MiembrosDAO;
import org.example.model.Miembros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class implementsMiembros implements MiembrosDAO {

    @Override
    public void insertar(Miembros miembro) {
        String sql = "INSERT INTO miembro(nombre,apellido, fechaInscripcion) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, miembro.getNombre());
            ps.setString(2, miembro.getApellido());
            ps.setDate(3, miembro.getFechaInscripcion());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Miembros> obtenerTodos() {
        List<Miembros> miembros = new ArrayList<>();
        String sql = "SELECT * FROM miembro";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Miembros miembro = new Miembros();
                miembro.setNombre(rs.getString("nombre"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setFechaInscripcion(rs.getDate("telefono"));
                miembros.add(miembro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return miembros;
}




}