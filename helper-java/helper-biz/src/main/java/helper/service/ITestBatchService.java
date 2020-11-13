package helper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import helper.entity.TestBatch;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-03-08
 */
public interface ITestBatchService extends IService<TestBatch> {

    /**
     * 测试批量保存返回主键id
     */
    void testInsertBatch();

    /**
     * 批量更新非数据库字段保存后不丢失
     */
    void testUpdateBatch();
}
