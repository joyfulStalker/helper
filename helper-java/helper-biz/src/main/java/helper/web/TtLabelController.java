package helper.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiSort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 标签  前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
@RestController
@ApiSort(value = 9)
@Api(value = "标签", tags = "标签")
@RequestMapping("/label")
public class TtLabelController {

}
