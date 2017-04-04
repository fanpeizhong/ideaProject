package controller;

import domain.Login;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Created by 范培忠 on 2017/2/28.
 */
@Controller
public class ResourceController {
    private static final Log logger = LogFactory.getLog(ResourceController.class);
    private static final int _1m = 1024 * 1024;

    @RequestMapping(value = "/login")
    public String login(@ModelAttribute Login login, HttpSession session, Model model) {
        logger.info("/login");
        logger.info("login.getUserName()[" + login.getUserName() + "]");
        logger.info("login.getPassword()[" + login.getPassword() + "]");
        if ("aaa".equals(login.getUserName()) && "bbb".equals(login.getPassword())) {
            session.setAttribute("loggedIn", Boolean.TRUE);
            return "Main";
        } else {
            model.addAttribute("login", new Login());
            return "LoginForm";
        }
    }

    @RequestMapping(value = "resource_download")
    public String downloadResource(HttpSession session,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
        logger.info("/resource_download");
        //validate user
        if (null == session || null == session.getAttribute("loggedIn")) {
            return "LoginForm";
        }
        //prepare file path
        String path = request.getServletContext().getRealPath("/WEB-INF/files");
        String filename = "Spring实战（第4版）.pdf";
        String filename_header = null;//for http header

        //encode
        logger.info("User-Agent:[" + request.getHeader("User-Agent") + "]");

        try {
            if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                filename_header = new String(filename.getBytes("GBK"),
                        "ISO8859-1");
            } else {//firefox、chrome、safari、opera
                filename_header = new String(filename.getBytes("UTF8"),
                        "ISO8859-1");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //ready to download
        File file = new File(path, filename);
        logger.info("file:[" + file.getAbsolutePath() + "]");

        if (file.exists()) {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition",
                    "attachment; filename=" + filename_header);

            byte[] buffer = new byte[_1m];
            FileInputStream fis = null;
            BufferedInputStream bis = null;

            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                for (int i = bis.read(buffer); i != -1; i = bis.read(buffer)) {
                    os.write(buffer, 0, i);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }//finally
        }//if (file.exists()) {

        return null;
    }//controller
}
