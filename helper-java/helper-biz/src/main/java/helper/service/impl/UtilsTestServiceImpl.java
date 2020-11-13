package helper.service.impl;

import helper.service.UtilsTestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.any23.encoding.TikaEncodingDetector;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author liu
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UtilsTestServiceImpl implements UtilsTestService {
    @Override
    public String txtAutoIdentify(MultipartFile file) throws IOException {
        String charset = new TikaEncodingDetector().guessEncoding(file.getInputStream());
        InputStreamReader inputStreamReader = new InputStreamReader(file.getInputStream(), charset);
        BufferedReader bs = new BufferedReader(inputStreamReader);
        log.info(bs.readLine());
        bs.close();
        inputStreamReader.close();
        return charset;
    }
}
