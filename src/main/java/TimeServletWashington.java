import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeServletWashington extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        LocalTime localTime = LocalTime.now();
        localTime = localTime.minusHours(8);
        localTime = LocalTime.parse(localTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("Time in washington : " + localTime);
        printWriter.close();
    }
}
