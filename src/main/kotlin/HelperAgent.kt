import net.bytebuddy.agent.builder.AgentBuilder
import net.bytebuddy.asm.Advice
import net.bytebuddy.description.NamedElement
import net.bytebuddy.description.method.MethodDescription
import net.bytebuddy.description.type.TypeDescription
import net.bytebuddy.dynamic.DynamicType
import net.bytebuddy.matcher.ElementMatchers
import net.bytebuddy.utility.JavaModule
import java.lang.instrument.Instrumentation

object HelperAgent {

    fun premain(agentArgs: String?, inst: Instrumentation) {
        println("Starting the agent...")
        AgentBuilder.Default()
            .type(ElementMatchers.nameContains("ActivationManager"))
            .transform { builder, typeDescription, classLoader, module, protectionDomain ->
                builder.visit(
                    Advice.to(
                        HelperAdvice::class.java
                    ).on(
                        ElementMatchers.named<NamedElement>("isActivated")
                    )
                )
            }.installOn(inst)
    }

}