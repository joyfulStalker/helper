package helper.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.common.enums.JobStatusEnum;
import helper.entity.Task;
import helper.mapper.TaskMapper;
import helper.quartz.QuartzManager;
import helper.quartz.TaskDO;
import helper.service.ITaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 定时任务  服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-01-22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

    @Autowired
    private QuartzManager quartzManager;

    @Override
    public void initSchedule() {
        List<Task> list = baseMapper.selectList(null);
        for (Task ttTask : list) {
            if (!ttTask.getIsDelete() && JobStatusEnum.RUNNING.getVal().equals(ttTask.getJobStatus())) {
                TaskDO taskDO = new TaskDO();
                BeanUtils.copyProperties(ttTask, taskDO);
                quartzManager.addJob(taskDO);
            }
        }

    }
}
