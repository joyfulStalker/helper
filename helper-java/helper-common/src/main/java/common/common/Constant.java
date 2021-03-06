package common.common;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 定义常量
 *
 * @author liuSongLin
 */
public class Constant {

    /**
     * 线程池
     * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
     * 说明：Executors返回的线程池对象的弊端如下：
     * 1）FixedThreadPool和SingleThreadPool:
     *   允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
     * 2）CachedThreadPool:
     *   允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。
     */
    public static final ThreadFactory NAMED_THREAD_FACTORY = new ThreadFactoryBuilder().setNameFormat("helper-pool-%d").build();
    public static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(5, 200, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), NAMED_THREAD_FACTORY, new ThreadPoolExecutor.AbortPolicy());

    /**
     * token 前缀
     */
    public static final String TOKEN_PREFIX = "helper.token.";
    /**
     * token user 前缀
     */
    public static final String TOKEN_PREFIX_USER = "helper.user.";

}
