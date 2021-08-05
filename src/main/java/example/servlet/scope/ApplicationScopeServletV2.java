package example.servlet.scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "applicationScopeServletV2", urlPatterns = "/scope-application-v2")
public class ApplicationScopeServletV2 extends HttpServlet {

    public ApplicationScopeServletV2() {
    }

    /**
     * ApplicationScopeServlet 서블릿에서 Application Scope에 저장한 "value" 값에 +1을 더한 후 값을 출력하는 서블릿
     * 만약, Application Scope에 "value" 값이 없는 경우에 대한 예외 처리도 포함한다.
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

        try {
            int value = (int) application.getAttribute("value");
            value++;

            application.setAttribute("value", value);

            out.println("<h1>value: " + value + "</h1>");
        } catch (NullPointerException e) {
            out.println("value의 값이 설정되지 않았습니다.");
        }
    }
}
