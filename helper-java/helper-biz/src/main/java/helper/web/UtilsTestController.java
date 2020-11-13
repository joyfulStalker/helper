package helper.web;

import com.google.common.collect.Lists;
import common.common.HttpMethod;
import common.common.base.R;
import common.utils.ExcelUtils;
import helper.service.UtilsTestService;
import helper.vo.test.EntityTest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiSort;
import office.enums.PatternStyle;
import office.tools.ExcelExportUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author liu
 */
@RestController
@ApiSort(value = 6)
@RequestMapping("/utilsTest")
@Api(value = "工具类测试", tags = "工具类测试")
public class UtilsTestController {

    @Autowired
    private UtilsTestService utilsTestService;

    @Autowired
    StringEncryptor encryptor;


    @ResponseBody
    @PostMapping("/txtAutoIdentify")
    @ApiOperation(value = "1、自动识别txt编码",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "txt自动识别，解析",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperationSupport(order = 1)
    public R txtAutoIdentify(MultipartFile file) throws IOException {
        return R.of(utilsTestService.txtAutoIdentify(file));
    }


    @ResponseBody
    @PostMapping("/txtExcelUtil")
    @ApiOperation(value = "2、测试Excel工具",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "2、测试Excel工具",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperationSupport(order = 2)
    public void txtExcelUtil(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<EntityTest> list = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            list.add(new EntityTest("张三" + i, i + 10, i / 2 == 1 ? "男" : "女", ""));
        }
        Workbook workbook = ExcelExportUtils.exportExcel(EntityTest.class, list, PatternStyle.XLSX, "sheet1", "测试表");
        ExcelUtils.setExcelExportContent("CE", request, response);
        workbook.write(response.getOutputStream());
    }


//    
//    @ResponseBody
//    @PostMapping("/textEncryptor")
//    @ApiOperation(value = "3、测试加密工具",
//            httpMethod = HttpMethod.POST,
//            response = R.class,
//            notes = "3、测试加密工具",
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ApiOperationSupport(order = 3)
//    public R textEncryptor(String passWord) {
//        String encrypt = encryptor.encrypt(passWord);//dprIDsgg1MlfQkVNJd0a0w==
//        String decrypt = encryptor.decrypt(encrypt);
//        return R.of("passWord:" + passWord + " encrypt:" + encrypt);
//    }

}
