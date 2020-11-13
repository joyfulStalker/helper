package common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import common.common.base.BaseQuery;

/**
 * @author liuSonglin
 */
public class PageUtil {

    /**
     * 获取分页信息
     *
     * @param query
     * @return
     */
    public static Page getPage(BaseQuery query) {
        Page page = new Page<>();
        page.setAscs(query.getAscs());
        page.setDescs(query.getDescs());
        page.setCurrent(query.getCurrent());
        page.setSize(query.getSize());
        return page;
    }
}
