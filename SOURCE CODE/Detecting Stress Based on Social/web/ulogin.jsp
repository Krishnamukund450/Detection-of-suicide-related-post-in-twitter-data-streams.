<%@page import="SourceCode.DbConnection"%>
<%@page import="java.sql.*"%>
<%
    String email = request.getParameter("email");
    String pass = request.getParameter("pass");
    session.setAttribute("logemail", email);
    session.setAttribute("logpass", pass);
    Connection con = DbConnection.getConnection();
    Statement st = con.createStatement();
    try {
        ResultSet rs = st.executeQuery("select * from register where email='" + email + "' AND password='" + pass + "'");
        if (rs.next()) {
            session.setAttribute("semail", rs.getString("email"));
            session.setAttribute("sid", rs.getString("id"));
            session.setAttribute("sname", rs.getString("username"));
            response.sendRedirect("home.jsp?msg=success");
        } else {
            response.sendRedirect("alogin.jsp");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
%>
