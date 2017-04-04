package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pzh.fan on 2017/1/17.
 */
public interface Controller {
    String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
