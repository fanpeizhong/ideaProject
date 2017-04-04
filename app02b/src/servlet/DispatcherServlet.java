package servlet;

import controller.Controller;
import controller.InputProductController;
import controller.SaveProductController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by pzh.fan on 2017/1/17.
 */
@WebServlet(name = "DispatcherServlet", urlPatterns = {"/product_input", "/product_save"})
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 4538626576951673432L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String reqeustUri = request.getRequestURI();
        int slash = reqeustUri.lastIndexOf("/");
        String action = reqeustUri.substring(slash + 1);

        String dispatchUrl = null;
        Controller controller = null;
        switch (action) {
            case "product_input":
                controller = new InputProductController();
                dispatchUrl = controller.handleRequest(request, response);
                break;
            case "product_save":
                controller = new SaveProductController();
                dispatchUrl = controller.handleRequest(request, response);
                break;
            default:
                break;
        }

        if (dispatchUrl != null) {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }
}
