package firstservlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns={"/LoginServlet-url"},
        initParams = {
                @WebInitParam(name="username",value="Harsha"),
                @WebInitParam(name="password",value="godigit"),
        }
)
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST");

        String user=req.getParameter("user");//html form data
        String pwd= req.getParameter("pwd");//html form data
        String userId = getServletConfig().getInitParameter("username");
        String pwdId = getServletConfig().getInitParameter("password");
        if (userId.equals(user) && pwdId.equals(pwd)) {
            req.setAttribute("user", user);
            PrintWriter out=resp.getWriter();
            out.println("<font color=red>Wrong User Id or Password</font>");
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Wrong User Id or Password</font>");
            requestDispatcher.include(req, resp);
        }
    }
}
