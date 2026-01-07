
<%    
    String email = (String)session.getAttribute("logemail");
    String pass = (String)session.getAttribute("logpass");
   
    if (email.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
        response.sendRedirect("admin_home.jsp?msg=success");
    } else {
        response.sendRedirect("index.jsp?log=Failed");
    }
    
%>
