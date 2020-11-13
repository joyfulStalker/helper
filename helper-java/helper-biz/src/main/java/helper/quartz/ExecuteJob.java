package helper.quartz;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

/**
 * 执行任务的job
 * DisallowConcurrentExecution 作业不并发
 *
 * @author liuSonglin
 */
@Slf4j
@Component
@DisallowConcurrentExecution
public class ExecuteJob implements Job {

    @Override
    public void execute(JobExecutionContext arg0) {
        JobDataMap map = arg0.getJobDetail().getJobDataMap();
        String url = (String) map.get("url");
        log.info("开始执行调：" + url);
        HttpUtil.get(url);
        log.info("执行结束：" + url);
    }

}