/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-12-22 09:57:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("  <title>Green Bank</title>\n");
      out.write("  <link rel=\"shortcut icon\" type=\"image/png\" href=\"image/favicon.png\" />\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main_css.css\">\n");
      out.write("  <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("  <script\n");
      out.write("          src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("  <script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"row\">\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("</div>\n");
      out.write("<div class=\"container-fullwidth\" style=\"margin-top: 0px\">\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"col-md-12\">\n");
      out.write("      <div id=\"carousel-example-generic\" class=\"carousel slide\"\n");
      out.write("           data-ride=\"carousel\">\n");
      out.write("\n");
      out.write("        <ol class=\"carousel-indicators\">\n");
      out.write("          <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\"\n");
      out.write("              class=\"active\"></li>\n");
      out.write("          <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\n");
      out.write("        </ol>\n");
      out.write("\n");
      out.write("        <div class=\"carousel-inner\">\n");
      out.write("          <div class=\"item active\">\n");
      out.write("            <img src=\"image/CurrentDepositWide.jpg\" alt=\"First slide\">\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("          <div class=\"item\">\n");
      out.write("            <img src=\"image/SavingsDepositWide.jpg\" alt=\"Second slide\">\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <a class=\"left carousel-control\" href=\"#carousel-example-generic\"\n");
      out.write("           data-slide=\"prev\"> <span\n");
      out.write("                class=\"glyphicon glyphicon-chevron-left\"></span></a><a\n");
      out.write("              class=\"right carousel-control\" href=\"#carousel-example-generic\"\n");
      out.write("              data-slide=\"next\"><span\n");
      out.write("              class=\"glyphicon glyphicon-chevron-right\"> </span> </a>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"row\">\n");
      out.write("    <div class=\"schemes\" style=\"margin-bottom: -155px;\">\n");
      out.write("      <div class=\"col-md-4 scheme-type-1\">\n");
      out.write("        <h2 class=\"text-center text-medium\">\n");
      out.write("          Loan<br>Scheme\n");
      out.write("        </h2>\n");
      out.write("        <p class=\"col-md-6 col-md-offset-3 text-center scheme-text\">There\n");
      out.write("          is a variety of saving plans which can be tailored to your needs,\n");
      out.write("          including: Tax Exempt Savings Regular Savings.</p>\n");
      out.write("        <div class=\"scheme-button col-md-4 col-md-offset-4\">\n");
      out.write("          <a type=\"button\" class=\"btn btn-default btn-lg\" href=\"loan.jsp\"\n");
      out.write("             style=\"border-radius: 24px;\">Learn more..</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-md-4 scheme-type-2\">\n");
      out.write("        <h2 class=\"text-center text-medium\">\n");
      out.write("          Deposit<br>Scheme\n");
      out.write("        </h2>\n");
      out.write("        <p class=\"col-md-6 col-md-offset-3 text-center scheme-text\">There\n");
      out.write("          is a variety of saving plans which can be tailored to your needs,\n");
      out.write("          including: Tax Exempt Savings Regular Savings.</p>\n");
      out.write("        <div class=\"scheme-button col-md-4 col-md-offset-4\">\n");
      out.write("          <a type=\"button\" class=\"btn btn-default btn-lg\"\n");
      out.write("             href=\"deposit_scheme.jsp\" style=\"border-radius: 24px;\">Learn\n");
      out.write("            more..</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-md-4 scheme-type-3\">\n");
      out.write("        <h2 class=\"text-center text-medium\">\n");
      out.write("          Payment<br>Bill\n");
      out.write("        </h2>\n");
      out.write("        <p class=\"col-md-6 col-md-offset-3 text-center scheme-text\">There\n");
      out.write("          is a variety of saving plans which can be tailored to your needs,\n");
      out.write("          including: Tax Exempt Savings Regular Savings.</p>\n");
      out.write("        <div class=\"scheme-button col-md-4 col-md-offset-4\">\n");
      out.write("          <a type=\"button\" class=\"btn btn-default btn-lg\"\n");
      out.write("             style=\"border-radius: 24px;\">Learn more..</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- Footer start here -->\n");
      out.write("  <div class=\"row\" style=\"margin-top: 50px;\">\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
