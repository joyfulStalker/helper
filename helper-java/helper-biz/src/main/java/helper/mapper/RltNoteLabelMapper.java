package helper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import common.common.enums.LabelEnum;
import helper.entity.RltLabel;
import helper.vo.note.LabelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
public interface RltNoteLabelMapper extends BaseMapper<RltLabel> {

    /**
     * 获取指定标签集合
     *
     * @param businessId
     * @param labelEnum
     * @return
     */
    List<LabelVo> getLabelList(@Param("businessId") Integer businessId, @Param("labelEnum") LabelEnum labelEnum);
}