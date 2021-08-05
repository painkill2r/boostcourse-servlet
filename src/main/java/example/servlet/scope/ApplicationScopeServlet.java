package example.servlet.scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "applicationScopeServlet", urlPatterns = "/scope-application")
public class ApplicationScopeServlet extends HttpServlet {

    public ApplicationScopeServlet() {
    }

    /**
     * Application Scope에 "value"를 설정하는 서블릿 함수
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        ServletContext application = getServletContext(); //ServletContext를 통해 application scope를 다룬다.
        int value = 1;

        application.setAttribute("value", value);

        out.println("<h1>value: " + value + "</h1>");
    }
}
