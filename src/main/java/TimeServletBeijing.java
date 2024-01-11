import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeServletBeijing extends HttpServlet {
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
