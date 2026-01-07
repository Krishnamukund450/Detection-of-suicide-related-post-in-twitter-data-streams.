<%@page import="java.sql.*" %>
<%@page import="SourceCode.DbConnection" %>
<%

    String block = (String) session.getAttribute("message");
    System.out.println("Message check :  " + block);
    
    boolean bol = false;
    Connection con = DbConnection.getConnection();
    Statement st = con.createStatement();
    String Query = "select * from stress";
    ResultSet rs = st.executeQuery(Query);
    while (rs.next()) {
        String val1 = rs.getString("stresswords");
        System.out.println("val1 is :" + val1);
        if (block.indexOf(val1) >= 0) {

            response.sendRedirect("state1.jsp");

            bol = false;
            break;
        } else {
            bol = true;
        }
    }
    if (bol == true) {
        response.sendRedirect("state2.jsp");
    }

%>
