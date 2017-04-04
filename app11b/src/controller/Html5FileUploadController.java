package controller;

import domain.UploadFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created by 范培忠 on 2017/2/27.
 */
@Controller
public class Html5FileUploadController {
    private static final Log logger = LogFactory.getLog(Html5FileUploadController.class);

    @RequestMapping(value = "/html5")
    public String inputProduct() {
        return "Html5";
    }

    @RequestMapping(value = "/file_upload")
    public void saveFile(HttpServletRequest httpServletRequest,
                         @ModelAttribute UploadFile uploadFile,
                         BindingResult bindingResult) {
        logger.info("file_upload:");
        MultipartFile multipartFile = uploadFile.getMultipartFile();
        String fileName = multipartFile.getOriginalFilename();
        logger.info(httpServletRequest.getServletContext().getRealPath("/file"));
        logger.info(fileName);
        File file = new File(httpServletRequest.getServletContext().getRealPath("/file"), fileName);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
