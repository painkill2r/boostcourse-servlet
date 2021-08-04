package example.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "/requestheaderservlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    /**
     * 요청 헤더 정보를 출력하는 서블릿 메소드
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

        Enumeration<String> headerNames = request.getHeaderNames();

        //요청 헤더 정보 출력
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String header = request.getHeader(headerName);

            out.println(headerName + ": " + header + "<br/>");
        }

        out.println("</body>");
        out.println("</html>");

    }
}
