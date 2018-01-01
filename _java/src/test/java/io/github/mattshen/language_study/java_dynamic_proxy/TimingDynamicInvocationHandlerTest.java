package io.github.mattshen.language_study.java_dynamic_proxy;

import org.junit.Test;

import static org.junit.Assert.*;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class TimingDynamicInvocationHandlerTest {

    @Test public void quick_test() {
        Map mapProxyInstance = (Map) Proxy.newProxyInstance(
                TimingDynamicInvocationHandler.class.getClassLoader(), new Class[] { Map.class },
                new TimingDynamicInvocationHandler(new HashMap<>()));

        mapProxyInstance.put("hello", "world");
        assertEquals(1, mapProxyInstance.size());

        CharSequence csProxyInstance = (CharSequence) Proxy.newProxyInstance(
                TimingDynamicInvocationHandler.class.getClassLoader(),
                new Class[] { CharSequence.class },
                new TimingDynamicInvocationHandler("Hello World"));

       assertEquals(11, csProxyInstance.length());
    }

}