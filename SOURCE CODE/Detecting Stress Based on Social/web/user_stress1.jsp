<%@page import="java.sql.*" %>
<%@page import="SourceCode.DbConnection" %>
<%
    String userid = request.getParameter("userid");
    String uname = null;
    session.setAttribute("UID", userid);
    session.setAttribute("username", uname);
    System.out.println("Print User ID : " + userid );
    Connection con = DbConnection.getConnection();
    Statement st = con.createStatement();
    String last_tweet = null;
    try {
        ResultSet rs = st.executeQuery("select * from tweet where uid = '" + userid + "' AND tid=(select MAX(tid) from tweet where uid='" + userid + "')");
        if (rs.next()) {
            last_tweet = rs.getString("stress");
            uname = rs.getString("username");
            session.setAttribute("UserName", uname);
            session.setAttribute("Last_Tweet", last_tweet);
            System.out.println("Last_Tweet : " + last_tweet);
            response.sendRedirect("user_stress2.jsp");
        }else{
            response.sendRedirect("user_stress.jsp");
        }
    } catch (Exception ex) {
        
        ex.printStackTrace();
    }

%>
