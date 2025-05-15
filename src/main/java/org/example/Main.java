package org.example;

import org.example.DAO.AutoresDAO;
import org.example.DAO.LibrosDAO;
import org.example.DAO.MiembrosDAO;
import org.example.DAO.PrestamosDAO;
import org.example.model.Autores;
import org.example.model.Libros;
import org.example.model.Miembros;
import org.example.model.Prestamos;
import utils.implementsAutor;
import utils.ImplementsLibros;
import utils.implementsMiembros;
import utils.implementsPrestamos;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ImplementsLibros libro = new ImplementsLibros();
        boolean play = false;

        int op;
        do {
            System.out.println("""
                     BIENVENIDO A NUESTRA LIBRERIA
                     SELECCIONA LA OPCION QUE DESEES
                    
                     1. AGREGAR AUTOR
                     2. AGREGAR LIBRO
                     3. AGREGAR MIEMBRO
                     4. REALIZAR PRESTAMO
                     5. LISTAR LIBROS
                     6. SALIR DEL PROGRAMA
                    
                    
                    """);
            op = scanner.nextInt();

            AutoresDAO autorDAO = new implementsAutor();
            LibrosDAO libroDAO = new ImplementsLibros();
            MiembrosDAO miembroDAO = new implementsMiembros();
            PrestamosDAO prestamoDAO = new implementsPrestamos();


            switch (op) {
                case 1 -> {
                    System.out.print("NOMBRE DEL AUTOR: ");
                    String nombre = scanner.nextLine();
                    System.out.print("APELLIDO DEL AUTOR: ");
                    String apellido = scanner.nextLine();
                    System.out.print("NACIONALIDAD DEL AUTOR: ");
                    String nacionalidad = scanner.nextLine();
                    System.out.print("ID DEL AUTOR: ");
                    int autorId = Integer.parseInt(scanner.nextLine());

                    Autores autor = new Autores(nombre, apellido, nacionalidad, autorId);
                    autorDAO.agregarAutor(autor);
                    System.out.println("EL AUTOR HA SIDO AGREGADO");
                }

                case 2 -> {
                    System.out.print("TITULO DEL LIBRO: ");
                    String titulo = scanner.nextLine();
                    System.out.print("ID DEL LIBRO: ");
                    String libroId = scanner.nextLine();
                    System.out.print("GENERO DEL LIBRO: ");
                    String genero = scanner.nextLine();
                    System.out.print("ID DEL AUTOR: ");
                    String autorId = scanner.nextLine();

                    Libros libro1 = new Libros(titulo, libroId, genero, autorId);
                    libroDAO.insertar(libro1);
                    System.out.println("EL LIBRO HA SIDO AGREGADO");
                }

                case 3 -> {
                    System.out.print("NOMBRE DEL MIEMBRO: ");
                    String nombre = scanner.nextLine();
                    System.out.print("APELLIDO DEL MIEMBRO: ");
                    String apellido = scanner.nextLine();
                    System.out.print("FECHA DE INSCRIPCION (AAAA/MM/DD): ");
                    Date fechaInscripcion = Date.valueOf(scanner.nextLine());
                    System.out.print("ID DEL MIEMBRO: ");
                    String miembroId = scanner.nextLine();

                    Miembros miembro = new Miembros(nombre, apellido, fechaInscripcion, miembroId);
                    miembroDAO.insertar(miembro);
                    System.out.println("EL LIBRO HA SIDO AGREGADO");
                }

                case 4 -> {
                    System.out.print("ID DEL PRESTAMO: ");
                    int prestamoId = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID DEL LIBRO: ");
                    int libroId = Integer.parseInt(scanner.nextLine());
                    System.out.print("ID DEL MIEMBRO: ");
                    int miembroId = Integer.parseInt(scanner.nextLine());
                    System.out.print("FECHA DEL PRESTAMO (AAAA/MM/DD): ");
                    Date fechaPrestamo = Date.valueOf(scanner.nextLine());
                    System.out.print("FECHA DE DEVOLUCION (AAAA/MM/DD) ");
                    System.out.println("SI NO HAY FECHA DE DEVOLUCION, DARLE A LA TECLA 'ENTER'");
                    String fechaDevStr = scanner.nextLine();
                    Date fechaDevolucion = fechaDevStr.isEmpty() ? null : Date.valueOf(fechaDevStr);

                    Prestamos prestamo = new Prestamos(prestamoId, libroId, miembroId, fechaPrestamo, fechaDevolucion);
                    prestamoDAO.insertar(prestamo);
                    System.out.println("DE HA REALIZADO EL PRESTAMO");
                }

                case 5 -> {
                    System.out.println("\nLISTA DE LIBROS");
                    for (Libros libro1 : libroDAO.obtenerTodos()) {
                        System.out.println("TITULO DEL LIBRO: " + libro1.getTitulo() +
                                ", ID DEL LIBRO: " + libro1.getLibroId() +
                                ", GENERO DEL LIBRO: " + libro1.getGenero() +
                                ", ID DEL AUTOR: " + libro1.getAutorId());
                    }
                }

                case 6 -> System.out.println("SALIENDO DEL PROGRAMA");
                default -> System.out.println("ESA OPCION NO ESTA DISPONIBLE, VUELVE A INTENTARLO");
            }

        } while (op!=0);
}
}