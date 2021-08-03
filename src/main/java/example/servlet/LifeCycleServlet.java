package example.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 라이프 싸이클를 확인해 보기 위한 서블릿
 */
@WebServlet(name = "lifeCycleServlet", urlPatterns = "/lifecycle")
public class LifeCycleServlet extends HttpServlet {

    /**
     * 처음 LifeCycleServlet 호출시 동작, 이후에는 동작하지 않음
     * - Memory에 해당 서블릿이 적재되어 있기 때문
     */
    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet 생성");
    }

    /**
     * 처음 LifeCycleServlet 호출시 동작, 이후에는 동작하지 않음
     * - Memory에 해당 서블릿이 적재되어 있기 때문
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifeCycleServlet.init() 호출");
    }

    /**
     * 처음 LifeCycleServlet 호출시 동작하고, 이후 호출할 때마다 실행
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LifeCycleServlet.service() 호출");
    }

    /**
     * WAS가 종료될 때 실행
     */
    @Override
    public void destroy() {
        System.out.println("LifeCycleServlet.destroy() 호출");
    }
}
