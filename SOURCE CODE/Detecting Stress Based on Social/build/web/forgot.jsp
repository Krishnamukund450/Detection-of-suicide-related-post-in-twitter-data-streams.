<%@page import="java.security.SecureRandom"%>
<%@page import="java.util.Random"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="SourceCode.DbConnection"%>
<%@page import="js.Mail"%>
<%
    Connection con = DbConnection.getConnection();
    Statement st = con.createStatement();
    Statement st1 = con.createStatement();
    String email = request.getParameter("email");
    Random RANDOM = new SecureRandom();
    int PIN = 4;
    String letters = "0123456789";
    String uid = "";
    for (int i = 0; i < PIN; i++) {
        int index = (int) (RANDOM.nextDouble() * letters.length());
        uid += letters.substring(index, index + 1);
    }
    String resertPassword = uid;
    System.out.println("Value :" + email);
    String name = null;

    try {
        ResultSet rs = st.executeQuery("select * from register where email='" + email + "'");
        if (rs.next()) {
            name = rs.getString("username");
            int in = st1.executeUpdate("update register set password = '" + resertPassword + "' where email = '" + email + "'");
            if (in != 0) {
                String msg = "Your Account User Name and New Passwords!!" + "\n\n\tUser Name : " + name + "\n\tNew Password : " + resertPassword;
                Mail mail = new Mail();
                mail.secretMail(msg, "FORGOT_PASSWORD", email);
                response.sendRedirect("index.jsp?msg=Check_Your_e-Mail");
            } else {
                response.sendRedirect("index.jsp?msgg=Error");
            }
        }
        response.sendRedirect("index.jsp");
    } catch (Exception ex) {
        ex.printStackTrace();
    }
%>