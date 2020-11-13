package helper.service;

public interface RedisExampleService {

    /**
     * 分布式id
     *
     * @param type
     * @return
     */
    String generateDistributeId(String type);
}
