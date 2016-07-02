/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DavidDaniel
 */
@WebServlet(urlPatterns = {"/Servicio"})
public class Servicio extends HttpServlet {

    String DRIVER = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/bd";
    String USER = "root";
    String PASSWORD = "1234";
    Connection con;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            //Registro de datos del cliente
            String apellidopaterno = request.getParameter("ap");
            String apellidomaterno = request.getParameter("am");
            String nombre = request.getParameter("nm");
            String dni = request.getParameter("dn");
            String ciudad = request.getParameter("ci");
            String direccion = request.getParameter("di");
            String telefono = request.getParameter("te");
            String email = request.getParameter("em");

            System.out.println("Apellido Paterno es" + apellidopaterno);
            System.out.println("Apellido Materno es" + apellidomaterno);

            String sql = "insert into cliente (cliente_paterno,cliente_materno,cliente_nombre,cliente_dni,"
                    + "cliente_ciudad,cliente_direccion,cliente_telefono,cliente_email)"
                    + "values (?,?,?,?,?,?,?,?)";
            try {

                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, apellidopaterno);
                ps.setString(2, apellidomaterno);
                ps.setString(3, nombre);
                ps.setString(4, dni);
                ps.setString(5, ciudad);
                ps.setString(6, direccion);
                ps.setString(7, telefono);
                ps.setString(8, email);

                int a = ps.executeUpdate();

                if (a == 1) {
                    System.out.println("datos ingresados");
                }

                //Lista de clientes
                List<Cliente> lista = null;
                CallableStatement stmt = null;
                ResultSet dr = null;
                sql = "select cliente_paterno,cliente_materno from cliente";
                stmt = con.prepareCall(sql);
                dr = stmt.executeQuery();
                while (dr.next()) {
                    if (lista == null)
                        lista = new ArrayList<Cliente>();
                   
                    Cliente cliente = new Cliente();
                    cliente.setApellidopaterno(dr.getString(1));
                    cliente.setApellidomaterno(dr.getString(2));
                    lista.add(cliente);
                   

                    

                }
                dr.close();
                stmt.close();
                con.close();

              
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
