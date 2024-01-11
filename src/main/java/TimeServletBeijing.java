import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(value = "/beijing")

public class TimeServletBeijing extends HttpServlet {
    @Override
    public void init() {
        System.out.println("THis is INIT method!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("This is SERVICe method! ");
    }

    @Override
    public void destroy() {
        System.out.println("This is DESTROY METHOD!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        LocalTime localTime = LocalTime.now();
        localTime = localTime.plusHours(5);
        localTime = LocalTime.parse(localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("Time in beijing : " + localTime);
        printWriter.close();
    }
}
