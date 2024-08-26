package moe.kurenai.demo;

import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;

public class HelperInterceptor {

    @RuntimeType
    public static Object intercept(@Origin Method method,
                                   @SuperCall Callable<?> callable) {
        System.out.println("intercept " + method);
        if ("load".equals(method.getName())) {
            return null;
        } else if ("decryptByPublicKey".equals(method.getName())) {
            return "{\"verifyMagic\": \"PeerBanHelper\",\"source\": \"\",\"licenseTo\": \"\",\"createAt\": 1,\"expireAt\": 4859712000000,\"description\": \"0\"}".getBytes(StandardCharsets.UTF_8);
        } else if ("isActivated".equals(method.getName())) {
            return true;
        } else {
            try {
                return callable.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
