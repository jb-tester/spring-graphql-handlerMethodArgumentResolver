package com.mytests.springgraphqltest0;

import com.mytests.springgraphqltest0.model.Person;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.core.MethodParameter;
import org.springframework.graphql.data.method.HandlerMethodArgumentResolver;

import java.util.Random;

public class MyMutationArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getGenericParameterType().equals(Person.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, DataFetchingEnvironment environment) throws Exception {
        int randomId = new Random().nextInt(1,100);
        return new Person(randomId, "john","smith",18);
    }
}
