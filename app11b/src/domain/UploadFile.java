package domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by 范培忠 on 2017/2/27.
 */
public class UploadFile implements Serializable {
    private static final long serialVersionUID = -8890489634397696210L;

    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
