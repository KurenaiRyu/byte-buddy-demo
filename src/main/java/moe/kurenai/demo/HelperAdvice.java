package moe.kurenai.demo;

import net.bytebuddy.asm.Advice;

public class HelperAdvice {

    @Advice.OnMethodExit
    public void exit(@Advice.Return(readOnly = false) boolean returnValue) {
        returnValue = true;
    }

}
