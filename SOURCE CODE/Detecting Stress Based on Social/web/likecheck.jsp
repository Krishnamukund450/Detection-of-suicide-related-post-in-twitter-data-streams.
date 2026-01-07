<%@page import="SourceCode.DbConnection"%>
<%@page import="java.sql.*"%>
<%
    String tid = request.getParameter("id");
    session.setAttribute("stid", tid);
    String uid = (String) session.getAttribute("sid");
    String name = (String) session.getAttribute("sname");
    System.out.println("Tweet ID : " + tid + "\nUser ID : " + uid);

    Connection con = DbConnection.getConnection();
    Connection con1 = DbConnection.getConnection();
    Statement st = con.createStatement();
    Statement st1 = con1.createStatement();

    try {
        ResultSet rs = st.executeQuery("select * from likes where tid='" + tid + "' AND uid='" + uid + "' AND likes='1'");
        if (rs.next()) {
            response.sendRedirect("dislike.jsp");
        } else {
            int in = st1.executeUpdate("insert into likes (tid, uid, likes, name) values ('" + tid + "','" + uid + "','1','" + name + "')");
            if (in != 0) {
                response.sendRedirect("like.jsp");
            } else {
                response.sendRedirect("home.jsp");
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }



%>