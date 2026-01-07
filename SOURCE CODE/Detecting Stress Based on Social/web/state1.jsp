<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="SourceCode.DbConnection"%>

<%
    Connection con = DbConnection.getConnection();
    Statement st = con.createStatement();
    String block = (String) session.getAttribute("message");
    try {

        int up = st.executeUpdate("update tweet set stress ='Stressd Tweet' where msg = '" + block + "'");
        if (up != 0) {
            response.sendRedirect("home.jsp?msg=success");
        } else {
            response.sendRedirect("home.jsp?msg=Failed");
        }

    } catch (Exception EX) {
        EX.printStackTrace();
    }
%>

