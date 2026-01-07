/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/Registration")
@MultipartConfig(maxFileSize = 16177215)
public class Register extends HttpServlet {

    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/interaction";
    private String dbUser = "root";
    private String dbPass = "root";

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("User Information :" + fname + email + address + city + country + username + password);

        InputStream inputStream = null;

        Part filePart = request.getPart("photo");
        if (filePart != null) {

            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }

        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client

        try {
            // connects to the database
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        System.out.println("User Information :" + fname + email + address + city + country + username + password);

            // constructs SQL statement
            String sql = "INSERT INTO register (fname, email, address, city, country, username, password, photo) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, fname);
            statement.setString(2, email);
            statement.setString(3, address);
            statement.setString(4, city);
            statement.setString(5, country);
            statement.setString(6, username);
            statement.setString(7, password);

            if (inputStream != null) {
                statement.setBlob(8, inputStream);
            }

            int row = statement.executeUpdate();
            if (row > 0) {
                response.sendRedirect("index.jsp?msg=Success");
            } else {
                response.sendRedirect("index.jsp?msgg=Error");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}