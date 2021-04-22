import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "imgTransfer",urlPatterns = "/imgTransfer")
public class imgTransfer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String photoData = request.getParameter("photoData");
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateNow = df.format(new Date());
        String picFileName = uname+dateNow;
        PhotoTools.savaPhoto(photoData,"C:\\yhj\\data\\mapTransfer\\rawMap\\"+picFileName);

        ControlPython controlPython = new ControlPython();
//        controlPython.getPythonDemo("C:\\yhj\\code\\PycharmProject\\mapTransfer\\demo.py","--content_image_path="+picFileName);
        controlPython.getPythonDemo("C:\\yhj\\code\\PycharmProject\\mapTransfer\\demo.py", "");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
