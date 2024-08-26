import net.bytebuddy.asm.Advice
import net.bytebuddy.asm.Advice.OnMethodExit


class HelperAdvice {

    @OnMethodExit
    fun exit(@Advice.Return(readOnly = false) returnValue: Boolean) {
        var returnValue = returnValue
        returnValue = true
    }
}