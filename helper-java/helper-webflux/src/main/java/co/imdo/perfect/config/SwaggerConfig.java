package co.imdo.perfect.config;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableOpenApi
@EnableSwagger2
public class SwaggerConfig {


    @Value("${swagger.path-name}")
    private String pathName;

    @Value("${swagger.package-name}")
    private String packageName;

    @Value("${swagger.application-name}")
    private String applicationName;

    private final TypeResolver resolver;

    @Autowired
    public SwaggerConfig(TypeResolver resolver) {
        this.resolver = resolver;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Collections.singleton("application/json"))
                .consumes(Collections.singleton("application/json"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("co.imdo.perfect"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()).alternateTypeRules(
                        new RecursiveAlternateTypeRule(resolver,
                                Arrays.asList(
                                        AlternateTypeRules.newRule(
                                                resolver.resolve(Mono.class, WildcardType.class),
                                                resolver.resolve(WildcardType.class)),
                                        AlternateTypeRules.newRule(
                                                resolver.resolve(ResponseEntity.class, WildcardType.class),
                                                resolver.resolve(WildcardType.class))
                                )))
                .alternateTypeRules(new RecursiveAlternateTypeRule(resolver,
                        Arrays.asList(
                                AlternateTypeRules.newRule(
                                        resolver.resolve(Flux.class, WildcardType.class),
                                        resolver.resolve(List.class, WildcardType.class)),
                                AlternateTypeRules.newRule(
                                        resolver.resolve(ResponseEntity.class, WildcardType.class),
                                        resolver.resolve(WildcardType.class))
                        ))
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(applicationName)
                .description("遇见Ø生活")
                .termsOfServiceUrl("https://github.com/joyfulStalker/helper")
                .version("1.0.0")
                .contact(new Contact("songLin", "https://github.com/joyfulStalker", "songlin-liu@foxmail.com"))
                .build();
    }

}

class RecursiveAlternateTypeRule extends AlternateTypeRule {

    private List<AlternateTypeRule> rules;

    public RecursiveAlternateTypeRule(TypeResolver typeResolver, List<AlternateTypeRule> rules) {
        // Unused but cannot be null
        super(typeResolver.resolve(Object.class), typeResolver.resolve(Object.class));
        this.rules = rules;
    }

    @Override
    public ResolvedType alternateFor(ResolvedType type) {
        ResolvedType newType = rules.stream().flatMap(rule -> Arrays.asList(rule.alternateFor(type))
                .stream().filter(alternateType -> alternateType != type)).findFirst()
                .orElse(type);
        if (appliesTo(newType)) {
            // Recursion happens here
            return alternateFor(newType);
        }

        return newType;
    }

    @Override
    public boolean appliesTo(ResolvedType type) {
        return rules.stream().anyMatch(rule -> rule.appliesTo(type));
    }
}

