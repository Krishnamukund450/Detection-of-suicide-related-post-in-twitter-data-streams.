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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/Retweets")
@MultipartConfig(maxFileSize = 16177215)
public class Retweet extends HttpServlet {

    // database connection settings
    private String dbURL = "jdbc:mysql://localhost:3306/interaction";
    private String dbUser = "root";
    private String dbPass = "root";
    private SimpleDateFormat format;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String userid = (String) session.getAttribute("sid");
        String uname = (String) session.getAttribute("sname");
        String msg = request.getParameter("msg");
        String msg1 = request.getParameter("msg1");
        String retweet = msg + "\n" + msg1;
        session.setAttribute("message", retweet);
        InputStream inputStream = null;
        Part filePart = request.getPart("file");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }

        Connection conn = null;
        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "INSERT INTO tweet (uid, username, msg, photo, reply) values (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, userid);
            statement.setString(2, uname);
            statement.setString(3, retweet);


            if (inputStream != null) {
                statement.setBlob(4, inputStream);
            }
            statement.setString(5, "0");
            int row = statement.executeUpdate();
            if (row > 0) {
                response.sendRedirect("state.jsp?msg=success");
            } else {
                response.sendRedirect("home.jsp?msgg=Failed");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}