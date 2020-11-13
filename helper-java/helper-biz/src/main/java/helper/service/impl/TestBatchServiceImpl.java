package helper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import helper.entity.TestBatch;
import helper.mapper.TestBatchMapper;
import helper.service.ITestBatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-03-08
 */
@Slf4j
@Service
public class TestBatchServiceImpl extends ServiceImpl<TestBatchMapper, TestBatch> implements ITestBatchService {

    @Override
    public void testInsertBatch() {
        List<TestBatch> testBatches = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            TestBatch testBatch = new TestBatch();
            testBatch.setUuid(UUID.randomUUID().toString());
            testBatch.setOtherColumn("OtherColumn");
            testBatches.add(testBatch);
        }

        this.saveBatch(testBatches);
        log.info(testBatches.toString());
    }

    @Override
    public void testUpdateBatch() {
        List<TestBatch> testBatches = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            TestBatch testBatch = new TestBatch();
            testBatch.setId(i + 1);
            testBatch.setUuid(UUID.randomUUID().toString());
            testBatch.setOtherColumn("OtherColumn");
            testBatches.add(testBatch);
        }
        this.updateBatchById(testBatches);
        log.info(testBatches.toString());
    }
}
