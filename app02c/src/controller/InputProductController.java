package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pzh.fan on 2017/1/17.
 */
public class InputProductController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return request.getContextPath() + "/ProductForm.jsp";
    }
}
