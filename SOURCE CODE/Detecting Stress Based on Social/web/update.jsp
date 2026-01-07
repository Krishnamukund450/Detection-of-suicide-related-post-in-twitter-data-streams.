<%@page import="SourceCode.DbConnection"%>
<%@page import="java.sql.*"%>
<%
    String tid = (String) session.getAttribute("stidd");
    Connection con = DbConnection.getConnection();
    Connection con1 = DbConnection.getConnection();
    Statement st = con.createStatement();
    Statement st1 = con1.createStatement();
    int old = 0;
    int total = 0;
    try {
        ResultSet rs = st.executeQuery("select * from tweet where tid='" + tid + "'");
        if (rs.next()) {
            old = rs.getInt("retweet");
            System.out.println("Old Likes : " + old);
            total = old + 1;
            int update = st1.executeUpdate("update tweet set retweet='" + total + "' where tid='" + tid + "'");
            if (update != 0) {
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("home.jsp");
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }



%>