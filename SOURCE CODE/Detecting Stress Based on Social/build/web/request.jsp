<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.oreilly.servlet.*,java.sql.*,java.lang.*,java.text.SimpleDateFormat,java.util.*,java.io.*,javax.servlet.*, javax.servlet.http.*"  errorPage="Error.jsp"%>
<%@page import=" java.security.MessageDigest"%>
<%@page import="SourceCode.DbConnection"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Personalized Image Search</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <script type="text/javascript">
        </script>
    </head>
    <body>
        <%

            String str = request.getParameter("id");
            session.setAttribute("str1", str);
            String[] temp;

            String delimiter = ",";

            temp = str.split(delimiter, 4);
            for (int i = 0; i < temp.length; i++) {
            }
            int id = Integer.parseInt((temp[0]));
            String name = temp[1];
            int fid = Integer.parseInt((temp[2]));
            String fname = temp[3];
            String status = "Following";
            ResultSet rs = null;
            PreparedStatement psmt1 = null;

            try {

                Connection con = DbConnection.getConnection();

                String sql = null;

                psmt1 = con.prepareStatement("insert into follow(uid,name,fid,fname,status) values(?,?,?,?,?)");
                psmt1.setInt(1, id);
                psmt1.setString(2, name);
                psmt1.setInt(3, fid);
                psmt1.setString(4, fname);
                psmt1.setString(5, status);
                int row = psmt1.executeUpdate();
                if (row > 0) {
                    response.sendRedirect("home.jsp?message=success");
                } else {
                    response.sendRedirect("home.jsp?msgg=Failed");
                }
                con.close();
                psmt1.close();

            } catch (Exception ex) {

                out.println("Error in connection : " + ex);

            }

        %>

    </body>
</html>