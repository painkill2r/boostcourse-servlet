package example.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/requestparameterservlet", urlPatterns = "/request-parameter")
public class RequestParameterServlet extends HttpServlet {

    /**
     * 요청 파라미터 정보를 출력하는 서블릿 메소드
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
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");

        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));

        out.println("name: " + name + "<br/>");
        out.println("age: " + age + "<br/>");

        out.println("</body>");
        out.println("</html>");

    }
}
