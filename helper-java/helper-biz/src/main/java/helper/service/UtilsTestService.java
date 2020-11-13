package helper.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UtilsTestService {
    /**
     * 自动识别文本的编码格式
     *
     * @param file
     * @return
     */
    String txtAutoIdentify(MultipartFile file) throws IOException;
}
