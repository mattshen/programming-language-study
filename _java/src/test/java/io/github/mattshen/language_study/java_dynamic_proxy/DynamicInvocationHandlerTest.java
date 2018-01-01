package io.github.mattshen.language_study.java_dynamic_proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Map;

import static org.junit.Assert.*;

public class DynamicInvocationHandlerTest {

    @Test
    public void map_put() {
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                DynamicInvocationHandlerTest.class.getClassLoader(),
                new Class[]{Map.class},
                new DynamicInvocationHandler());
        proxyInstance.put("hello", "world");
    }

    @Test
    public void map_get() {
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                DynamicInvocationHandlerTest.class.getClassLoader(),
                new Class[]{Map.class},
                (proxy, method, methodArgs) -> {
                    if (method.getName().equals("get")) {
                        return 42;
                    } else {
                        throw new UnsupportedOperationException(
                                "Unsupported method: " + method.getName());
                    }
                });
        assertEquals(42, proxyInstance.get("hello"));
        try {
            proxyInstance.put("hello", "world");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }
}