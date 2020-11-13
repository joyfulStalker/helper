package common.utils;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static cn.hutool.core.date.DatePattern.PURE_DATETIME_PATTERN;

/**
 * @author liuSonglin
 */

@Slf4j
public final class ExcelUtils {
    private static final String XLSX = ".xlsx";
    private static final String USER_AGENT = "USER-AGENT";
    private static final String TRIDENT = "Trident";
    private static final String MSIE = "MSIE";
    private static final String UTF_8 = "UTF-8";
    private static final String MOZILLA = "Mozilla";
    private static final String ISO_8859_1 = "ISO8859-1";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_VND_MS_EXCEL = "application/vnd.ms-excel";
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String ATTACHMENT_FILENAME = "attachment;filename=";
    private static final String STRING = "-";

    private ExcelUtils() {
    }

    /**
     * 设置导出头属性
     *
     * @param fileName fileName
     * @param request  fileName
     * @param response fileName
     */
    public static void setExcelExportContent(String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(fileName)) {
            fileName = DateUtil.format(new Date(), PURE_DATETIME_PATTERN);
        } else {
            fileName = fileName + STRING + DateUtil.format(new Date(), PURE_DATETIME_PATTERN);
        }
        fileName = fileName + XLSX;
        final String userAgent = request.getHeader(USER_AGENT);
        if (StringUtils.contains(userAgent, MSIE) || StringUtils.contains(userAgent, TRIDENT)) {
            //E浏览器
            fileName = URLEncoder.encode(fileName, UTF_8);
        } else if (StringUtils.contains(userAgent, MOZILLA)) {
            //google,火狐浏览器
            fileName = new String(fileName.getBytes(), StandardCharsets.UTF_8);
        } else {
            //其他浏览器
        }
        fileName = URLEncoder.encode(fileName, UTF_8);


        response.setCharacterEncoding(UTF_8);

        response.setHeader(CONTENT_TYPE, APPLICATION_VND_MS_EXCEL);
        /*
         * 下载文件的默认名称
         */
        response.setHeader(CONTENT_DISPOSITION, ATTACHMENT_FILENAME + fileName);
    }
}
