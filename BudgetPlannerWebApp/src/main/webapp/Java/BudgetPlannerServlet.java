import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Webservlet("")
public class BudgetPlannerServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try(PrintWriter out = response.getWriter()){
            out.println("JOS");
        }
    }

}
