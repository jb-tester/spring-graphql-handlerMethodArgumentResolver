package com.mytests.springgraphqltest0;

import graphql.schema.DataFetchingEnvironment;
import org.springframework.core.MethodParameter;
import org.springframework.graphql.data.method.HandlerMethodArgumentResolver;

import java.util.Random;

public class MyQueryArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getGenericParameterType().equals(NamesHandler.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, DataFetchingEnvironment environment) throws Exception {
        NamesHandler names = new NamesHandler("john", "smith");
        return names;
    }
}
