package example.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/requestinfoservlet", urlPatterns = "/request-info")
public class RequestInfoServlet extends HttpServlet {

    /**
     * 요청의 다양한 정보를 출력하는 서블릿 메소드
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

        String requestURI = request.getRequestURI(); //URI(요청주소 일부) 정보
        StringBuffer requestURL = request.getRequestURL(); //요청주소 전체
        String contextPath = request.getContextPath(); //WAS내 웹 애플리케이션과 매핑되는 정보(* WAS내에는 여러 웹 애플리케이션이 동작할 수 있음.)
        String remoteAddr = request.getRemoteAddr(); //접속 IP

        out.println("requestURI: " + requestURI + "<br/>");
        out.println("requestURL: " + requestURL + "<br/>");
        out.println("contextPath: " + contextPath + "<br/>");
        out.println("remoteAddr: " + remoteAddr + "<br/>");

        out.println("</body>");
        out.println("</html>");

    }
}
