<%@page import="SourceCode.DbConnection"%>
<%@page import="java.sql.*"%>
<%
    String tid = request.getParameter("id");
    session.setAttribute("stidd", tid);
    String uid = (String) session.getAttribute("sid");
    String name = (String) session.getAttribute("sname");
    System.out.println("Tweet ID : " + tid + "\nUser ID : " + uid);
    String retweeter = name + " Retweeted";
    Connection con = DbConnection.getConnection();
    Connection con1 = DbConnection.getConnection();
    Statement st = con.createStatement();
    Statement st1 = con1.createStatement();
    Statement st2 = con1.createStatement();
    Statement st3 = con1.createStatement();

    String msg = null;
    int reply;
    int likes;
    int retweet;
    int total;


    try {

        ResultSet rss = st1.executeQuery("select * from tweet where tid='" + tid + "'");
        if (rss.next()) {
            msg = rss.getString("msg");
            reply = rss.getInt("reply");
            retweet = rss.getInt("retweet");
            likes = rss.getInt("likes");
            System.out.println("---- Retweet ----" + msg + "\n" + reply + "\n" + retweet + "\nlikes" + likes);
            total = retweet + 1;
            ResultSet rs = st.executeQuery("select * from tweet where msg='" + msg + "' AND uid='" + uid + "'");
            if (rs.next()) {
                response.sendRedirect("home.jsp?already_retweeted");

            } else {
                int in = st2.executeUpdate("insert into tweet (uid, username, msg, photo, reply, retweet, likes, twid) values ('" + uid + "','" + retweeter + "','" + msg + "','', '" + reply + "','" + retweet + "','" + likes + "','" + tid + "')");
                if (in != 0) {
                    int update = st1.executeUpdate("update tweet set retweet='" + total + "' where msg='" + msg + "'");
                    if (update != 0) {
                        System.out.println("---------------------------------------5----------------------------------");
                        response.sendRedirect("update.jsp");
                    } else {
                        response.sendRedirect("home.jsp");
                    }
                }
            }
        }
        response.sendRedirect("home.jsp?already_retweeted");
    } catch (Exception ex) {
        ex.printStackTrace();
    }

%>