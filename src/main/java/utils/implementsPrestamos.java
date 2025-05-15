package utils;


import org.example.DAO.PrestamosDAO;
import org.example.model.Prestamos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class implementsPrestamos implements PrestamosDAO {

    @Override
    public void insertar(Prestamos prestamo) {
        String sql = "INSERT INTO prestamo(libroId, prestamosId, miembroId, fechaPrestamo, fechaDevolucion) VALUES (?, ?, ?, ? ,?)";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, prestamo.getLibroId());
            ps.setInt(2, prestamo.getPrestamosId());
            ps.setInt(3, prestamo.getMiembroId());
            ps.setDate(4, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));

            if (prestamo.getFechaDevolucion() != null) {
                ps.setDate(5, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
            } else {
                ps.setNull(5, Types.DATE);
            }

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Prestamos> obtenerTodos() {
        List<Prestamos> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamo";

        try (Connection conn = Conexion.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Prestamos prestamo = new Prestamos();
                prestamo.setPrestamosId(rs.getInt("PrestamosId"));
                prestamo.setLibroId(rs.getInt("idLibro"));
                prestamo.setMiembroId(rs.getInt("idMiembro"));
                prestamo.setFechaPrestamo(rs.getDate("fechaPrestamo"));
                prestamo.setFechaDevolucion(rs.getDate("fechaDevolucion"));
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
}

}