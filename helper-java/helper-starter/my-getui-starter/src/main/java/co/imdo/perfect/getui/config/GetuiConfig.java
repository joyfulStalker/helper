package co.imdo.perfect.getui.config;

import com.getui.push.v2.sdk.ApiHelper;
import com.getui.push.v2.sdk.GtApiConfiguration;
import com.getui.push.v2.sdk.api.PushApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

@Slf4j
public class GetuiConfig {

    @Value("${getui.app-id:LjGybTzggW8QJ60lmE4O8}")
    private String appId;
    @Value("${getui.app-key:uQGF2JjdTk6oE3kbhkaG81}")
    private String appKey;
    @Value("${getui.master-secret:C6iWwp7je38qK73JN5pR12}")
    private String masterSecret;
    @Value("${getui.domain:https://restapi.getui.com/v2/}")
    private String domain;

    private GtApiConfiguration employeeApiConfiguration() {
        GtApiConfiguration apiConfiguration = new GtApiConfiguration();
        //填写应用配置
        apiConfiguration.setAppId(appId);
        apiConfiguration.setAppKey(appKey);
        apiConfiguration.setMasterSecret(masterSecret);
        // 接口调用前缀，请查看文档: 接口调用规范 -> 接口前缀, 可不填写appId
        apiConfiguration.setDomain(domain);
        return apiConfiguration;
    }

    @Bean
    public PushApi getPushApi() throws Exception {
        // 实例化ApiHelper对象，用于创建接口对象
        ApiHelper apiHelperEmp = ApiHelper.build(employeeApiConfiguration());
        // 创建对象，建议复用。
        return apiHelperEmp.creatApi(PushApi.class);
    }
}
