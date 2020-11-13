package common.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Desc swagger2配置 EnableSwaggerBootstrapUI //开启BootstrapUI 可以与 swagger-UI 共存
 * @Author liuSongLin
 * @Date 2019/6/2 10:34
 * @Version 1.0v
 **/
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Value("${swagger.path-name}")
    private String pathName;

    @Value("${swagger.package-name}")
    private String packageName;

    @Value("${swagger.application-name}")
    private String applicationName;

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(packageName + ".web"))
                .paths(PathSelectors.any())
                .build()
                //下面这个设置就是在接口的path前加上project-name,每个项目的项目名路径不同，不加这个的话，发布到服务器请求接口会报404
                .pathMapping("/" + pathName);
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(applicationName)
                .description("遇见Ø生活")
                .termsOfServiceUrl("https://github.com/joyfulStalker/helper")
                .contact(new Contact("songLin", "https://github.com/joyfulStalker", "songlin-liu@foxmail.com"))
                .version("1.0")
                .build();
    }
}
