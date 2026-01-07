package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import SourceCode.DbConnection;

public final class admin_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Detecting Stress Based on Social Interactions </title>\n");
      out.write("        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"http://code.ionicframework.com/ionicons/2.0.0/css/ionicons.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"plugins/morris/morris.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"plugins/jvectormap/jquery-jvectormap-1.2.2.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"plugins/daterangepicker/daterangepicker-bs3.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"dist/css/AdminLTE.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <link href=\"dist/css/skins/_all-skins.min.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <style>\n");
      out.write("            .container .box{\n");
      out.write("                width: 100px;\n");
      out.write("                float: left; \n");
      out.write("                margin: 2px;\n");
      out.write("                padding: 5px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*Fade all the DIV when user hovers on any div*/\n");
      out.write("            .container:hover .box{\n");
      out.write("                zoom: 1;\n");
      out.write("                filter: alpha(opacity=45);\n");
      out.write("                opacity: 0.45;\n");
      out.write("                -webkit-transition: opacity .5s ease-in-out;\n");
      out.write("                -moz-transition: opacity .5s ease-in-out;\n");
      out.write("                -ms-transition: opacity .5s ease-in-out;\n");
      out.write("                -o-transition: opacity .5s ease-in-out;\n");
      out.write("                transition: opacity .5s ease-in-out;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*Fade out the particular DIV when user hover on that DIV*/\n");
      out.write("            .container .box:hover{\n");
      out.write("                box-shadow: 3px 3px 15px #666;\n");
      out.write("                border-color:#C76C0C;\n");
      out.write("                background: #C76C0C;\n");
      out.write("                color: #fff;\n");
      out.write("                cursor: pointer;\n");
      out.write("\n");
      out.write("                /*Opacity*/\n");
      out.write("                zoom: 1;\n");
      out.write("                filter: alpha(opacity=100);\n");
      out.write("                opacity: 1;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <style>\n");
      out.write("            .modal {\n");
      out.write("                display: none; /* Hidden by default */\n");
      out.write("                position: fixed; /* Stay in place */\n");
      out.write("                z-index: 1; /* Sit on top */\n");
      out.write("                padding-top: 100px; /* Location of the box */\n");
      out.write("                left: 0;\n");
      out.write("                top: 0;\n");
      out.write("                width: 100%; /* Full width */\n");
      out.write("                height: 100%; /* Full height */\n");
      out.write("                overflow: auto; /* Enable scroll if needed */\n");
      out.write("                background-color: rgb(0,0,0); /* Fallback color */\n");
      out.write("                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n");
      out.write("            }\n");
      out.write("            .modal-content {\n");
      out.write("                background-color: #fefefe;\n");
      out.write("                margin: auto;\n");
      out.write("                padding: 20px;\n");
      out.write("                border: 1px solid #888;\n");
      out.write("                width: 30%;\n");
      out.write("            }\n");
      out.write("            .close {\n");
      out.write("                color: #aaaaaa;\n");
      out.write("                float: right;\n");
      out.write("                font-size: 28px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .close:hover,\n");
      out.write("            .close:focus {\n");
      out.write("                color: #000;\n");
      out.write("                text-decoration: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            #aaa:hover\n");
      out.write("            {\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("            #bb:hover{\n");
      out.write("                color: #7ed321;\n");
      out.write("            }\n");
      out.write("            #ccc:hover{\n");
      out.write("                color: #00abf0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .modal1 {\n");
      out.write("                display: none; /* Hidden by default */\n");
      out.write("                position: fixed; /* Stay in place */\n");
      out.write("                z-index: 1; /* Sit on top */\n");
      out.write("                padding-top: 100px; /* Location of the box */\n");
      out.write("                left: 0;\n");
      out.write("                top: 0;\n");
      out.write("                width: 100%; /* Full width */\n");
      out.write("                height: 100%; /* Full height */\n");
      out.write("                overflow: auto; /* Enable scroll if needed */\n");
      out.write("                background-color: rgb(0,0,0); /* Fallback color */\n");
      out.write("                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n");
      out.write("            }\n");
      out.write("            .modal-content1 {\n");
      out.write("                background-color: #fefefe;\n");
      out.write("                margin: auto;\n");
      out.write("                padding: 20px;\n");
      out.write("                border: 1px solid #888;\n");
      out.write("                width: 30%;\n");
      out.write("            }\n");
      out.write("            .close1 {\n");
      out.write("                color: #aaaaaa;\n");
      out.write("                float: right;\n");
      out.write("                font-size: 28px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            .close1:hover,\n");
      out.write("            .close1:focus {\n");
      out.write("                color: #000;\n");
      out.write("                text-decoration: none;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"skin-blue\">\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <header class=\"main-header\">\n");
      out.write("                <a href=\"index2.html\" class=\"logo\"><img src=\"img\\icon.png\" width=\"64\" height=\"64\"></a>\n");
      out.write("                <nav class=\"navbar navbar-static-top\" role=\"navigation\">\n");
      out.write("                    <a href=\"#\" class=\"sidebar-toggle\" data-toggle=\"offcanvas\" role=\"button\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    </a>\n");
      out.write("                    <div class=\"navbar-custom-menu\">\n");
      out.write("                        <ul class=\"nav navbar-nav\">\n");
      out.write("                            <li style=\"font-size: 26px; font-family: serif ; color: white\">Detecting Stress Based on Social Interactions in Social Networks&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>\n");
      out.write("                            \n");
      out.write("                            <!-- User Account: style can be found in dropdown.less -->\n");
      out.write("                            <li class=\"dropdown user user-menu\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                    <img src=\"img\\admin.png\" class=\"user-image\" alt=\"User Image\"/>\n");
      out.write("                                    <span class=\"hidden-xs\">Admin</span>\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\">\n");
      out.write("                                    <!-- User image -->\n");
      out.write("                                    <li class=\"user-header\">\n");
      out.write("                                        <img src=\"img\\admin.png\" class=\"img-circle\" alt=\"User Image\" />\n");
      out.write("                                        <p>\n");
      out.write("                                            Admin\n");
      out.write("                                            <small></small>\n");
      out.write("                                        </p>\n");
      out.write("                                    </li>\n");
      out.write("\n");
      out.write("                                    <li class=\"user-footer\">\n");
      out.write("                                        <div class=\"pull-left\">\n");
      out.write("                                            <a href=\"#\" class=\"btn btn-default btn-flat\">Profile</a>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"pull-right\">\n");
      out.write("                                            <a href=\"index.jsp\" class=\"btn btn-default btn-flat\">Sign out</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </nav>\n");
      out.write("            </header>\n");
      out.write("            <!-- Left side column. contains the logo and sidebar -->\n");
      out.write("            <aside class=\"main-sidebar\">\n");
      out.write("                <!-- sidebar: style can be found in sidebar.less -->\n");
      out.write("                <section class=\"sidebar\">\n");
      out.write("                    <!-- Sidebar user panel -->\n");
      out.write("                    <div class=\"user-panel\" style=\"width: 400px\">\n");
      out.write("                        <div class=\"pull-left image\">\n");
      out.write("                            <img src=\"img\\admin.png\" class=\"img-circle\"  alt=\"User Image\" />\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"pull-left info\">\n");
      out.write("                            <p>Admin</p>\n");
      out.write("\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-circle text-success\"></i> Online</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- search form -->\n");
      out.write("                    <form action=\"#\" method=\"get\" class=\"sidebar-form\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <input type=\"text\" name=\"q\" class=\"form-control\" placeholder=\"Search...\"/>\n");
      out.write("                            <span class=\"input-group-btn\">\n");
      out.write("                                <button type='submit' name='search' id='search-btn' class=\"btn btn-flat\"><i class=\"fa fa-search\"></i></button>\n");
      out.write("                            </span>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </section>\n");
      out.write("            </aside>\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("                <!------------------------------------------------------ Content Header (Page header) ------------------------>\n");
      out.write("                <div style=\"width:100%;\" align=\"center\" class=\"container\">\n");
      out.write("                    <div style=\"float:left; width:100%; background-color: #ccc; \" >\n");
      out.write("                        <div style=\"background-color: #fefefe\">\n");
      out.write("                            <font style=\"font-family: cursive; color: #269abc \"><strong><font size=\"5\">User Details</font></strong></font><br><br>\n");
      out.write("                            <table>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th style=\"text-align: center;width: 200px; font-size: 16px; color: black\">User ID</th>\n");
      out.write("                                    <th style=\"text-align: center;width: 200px; font-size: 16px; color: black\">User Name</th>\n");
      out.write("                                    <th style=\"text-align: center;width: 400px;  font-size: 16px; color: black\">Email</th>\n");
      out.write("                                    <th style=\"text-align: center;width: 300px;  font-size: 16px; color: black\">City</th>\n");
      out.write("                                    <th style=\"text-align: center;width: 200px;  font-size: 16px; color: black\">Country</th>\n");
      out.write("                                    <th style=\"text-align: center;width: 200px;  font-size: 16px; color: black\">Photo</th>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    ");

                                        Connection con = DbConnection.getConnection();
                                        Statement st = con.createStatement();
                                        try {
                                            ResultSet rs = st.executeQuery("select * from register");
                                            while (rs.next()) {
                                    
      out.write("\n");
      out.write("                                    <td style=\"font-size: 16px\"><center>");
      out.print(rs.getString("id"));
      out.write("</center></td>   \n");
      out.write("                                    <td style=\"font-size: 16px\"><center>");
      out.print(rs.getString("username"));
      out.write("</center></td>   \n");
      out.write("                                    <td style=\"font-size: 16px\"><center>");
      out.print(rs.getString("email"));
      out.write("</center></td>  \n");
      out.write("                                    <td style=\"font-size: 16px\"><center>");
      out.print(rs.getString("city"));
      out.write("</center></td>  \n");
      out.write("                                    <td style=\"font-size: 16px\"><center>");
      out.print(rs.getString("country"));
      out.write("</center></td>\n");
      out.write("                                    <td><center><img src=\"view1.jsp?id=");
      out.print(rs.getString("id"));
      out.write("\" width=\"120\" height=\"100\"></center></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                            ");

                                                    }
                                                } catch (Exception ex) {
                                                    ex.printStackTrace();
                                                }

                                            
      out.write("\n");
      out.write("                                \n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!------------------------------------------------------ Content Header (Page header) ------------------------>\n");
      out.write("        </div><!-- /.content-wrapper -->\n");
      out.write("\n");
      out.write("        <footer class=\"main-footer\">\n");
      out.write("            <div class=\"pull-right hidden-xs\">\n");
      out.write("                <b>Version</b> 2.0\n");
      out.write("            </div>\n");
      out.write("            <strong>Copyright &copy; 2017-2018 <a href=\"#\">jp</a>.</strong>\n");
      out.write("        </footer>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"plugins/jQuery/jQuery-2.1.3.min.js\"></script>\n");
      out.write("    <script src=\"bootstrap/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src='plugins/fastclick/fastclick.min.js'></script>\n");
      out.write("    <script src=\"dist/js/app.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"plugins/sparkline/jquery.sparkline.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"plugins/jvectormap/jquery-jvectormap-1.2.2.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"plugins/jvectormap/jquery-jvectormap-world-mill-en.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"plugins/daterangepicker/daterangepicker.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"plugins/datepicker/bootstrap-datepicker.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"plugins/iCheck/icheck.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"plugins/slimScroll/jquery.slimscroll.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"plugins/chartjs/Chart.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"dist/js/pages/dashboard2.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"dist/js/demo.js\" type=\"text/javascript\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
