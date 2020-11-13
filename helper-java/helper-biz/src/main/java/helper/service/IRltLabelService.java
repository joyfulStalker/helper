package helper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import common.common.enums.LabelEnum;
import helper.entity.RltLabel;
import helper.vo.note.LabelVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
public interface IRltLabelService extends IService<RltLabel> {


    /**
     * 根据业务id、业务类型（指定表名） table获取指定 标签
     *
     * @param businessId
     * @param labelEnum
     * @return
     */
    List<LabelVo> getLabelList(Integer businessId, LabelEnum labelEnum);

}
