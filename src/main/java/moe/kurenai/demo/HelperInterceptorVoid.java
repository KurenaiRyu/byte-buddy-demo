package moe.kurenai.demo;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class HelperInterceptorVoid {

    @RuntimeType
    public static void intercept(@Origin Method method,
                                   @SuperCall Runnable runnable) {
        System.out.println("intercept void " + method);
        System.out.println("Method name " + method.getName());
    }

}
