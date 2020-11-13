package helper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import helper.entity.Menstruation;
import helper.vo.more.MenstruationQueryVO;
import helper.vo.more.MenstruationRemindDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-27
 */
public interface MenstruationMapper extends BaseMapper<Menstruation> {

    /**
     * 分页查询
     *
     * @param page
     * @param queryVO
     * @return
     */
    IPage<Menstruation> list(Page page, @Param("queryVO") MenstruationQueryVO queryVO);

    /**
     * 查询所有的数据进行分析
     *
     * @return
     */
    List<MenstruationRemindDTO> taskRemind();
}