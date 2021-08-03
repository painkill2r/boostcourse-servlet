package example.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OldTenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //응답 헤더 설정

        PrintWriter out = response.getWriter();
        out.println("<h1>1 ~ 10까지 출력</h1>");

        for (int i = 1; i <= 10; i++) {
            out.println(i + "<br/>");
        }

        out.close();
    }
}
