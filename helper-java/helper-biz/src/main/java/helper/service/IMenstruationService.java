package helper.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import helper.entity.Menstruation;
import helper.vo.more.MenstruationQueryVO;
import helper.vo.more.MenstruationVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2019-11-19
 */
public interface IMenstruationService extends IService<Menstruation> {

    /**
     * 新增或更新信息
     *
     * @param menstruationVo
     */
    void addOrUpdate(MenstruationVO menstruationVo);

    /**
     * 分页查询
     *
     * @param queryVO
     * @return
     */
    IPage<Menstruation> list(MenstruationQueryVO queryVO);

    /**
     * 定时提醒
     */
    void taskMenstruationRemind();
}
