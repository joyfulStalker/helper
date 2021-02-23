package helper.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import common.common.base.BaseQuery;
import helper.entity.TtNotice;
import helper.vo.notice.NoticeListVo;
import helper.vo.notice.SendNoticeVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2021-02-23
 */
public interface ITtNoticeService extends IService<TtNotice> {

    /**
     * 发送消息
     *
     * @param queryVo
     */
    void send(SendNoticeVo queryVo);

    /**
     * 消息列表
     *
     * @param queryVo
     * @return
     */
    IPage<TtNotice> noticeList(BaseQuery queryVo);
}
