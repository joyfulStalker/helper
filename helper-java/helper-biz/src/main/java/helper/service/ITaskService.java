package helper.service;

import com.baomidou.mybatisplus.extension.service.IService;
import helper.entity.Task;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-01-22
 */
public interface ITaskService extends IService<Task> {

    /**
     * 定时任务初始化、启动时加载
     */
    void initSchedule();
}
