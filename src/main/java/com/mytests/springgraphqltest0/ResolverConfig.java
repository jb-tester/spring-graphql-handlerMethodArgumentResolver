package com.mytests.springgraphqltest0;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.data.method.annotation.support.AnnotatedControllerConfigurer;

@Configuration
public class ResolverConfig {
    @Bean
    public AnnotatedControllerConfigurer annotatedControllerConfigurer() {
        AnnotatedControllerConfigurer controllerConfigurer = new AnnotatedControllerConfigurer();
        controllerConfigurer.addCustomArgumentResolver(new MyMutationArgumentResolver());
        controllerConfigurer.addCustomArgumentResolver(new MyQueryArgumentResolver());
        return controllerConfigurer;
    }
}
