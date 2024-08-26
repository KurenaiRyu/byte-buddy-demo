package moe.kurenai.demo;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class HelperAgent {

    public static void premain(String args, Instrumentation inst) {
        System.out.println("Starting the agent...");
        new AgentBuilder.Default()
                .type(ElementMatchers.nameContains("ActivationManager"))
                .transform((builder, typeDescription, classLoader, module, domain) ->
                        builder.method(ElementMatchers.any())
                                .intercept(MethodDelegation.to(HelperInterceptor.class)
//                        builder.visit(Advice.to(HelperAdvice.class).on(ElementMatchers.named("isActivated"))
                                )).installOn(inst);
        new AgentBuilder.Default()
                .type(ElementMatchers.nameContains("ActivationManager"))
                .transform((builder, typeDescription, classLoader, module, domain) ->
                        builder.method(ElementMatchers.any())
                                .intercept(MethodDelegation.to(HelperInterceptorVoid.class)
                                )).installOn(inst);
        new AgentBuilder.Default()
                .type(ElementMatchers.nameContains("RSAUtils"))
                .transform((builder, typeDescription, classLoader, module, domain) ->
                        builder.method(ElementMatchers.any())
                                .intercept(MethodDelegation.to(HelperInterceptor.class)
                                )).installOn(inst);
    }

}
