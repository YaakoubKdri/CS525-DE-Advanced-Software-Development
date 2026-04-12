package bank.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingProxy implements InvocationHandler {
    private Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Calling method: " + method.getName());
        if(args != null){
            for (int i = 0; i < args.length; i++) {
                System.out.println("Param[" + i + "] = " + args[i]);
            }
        }
        Object result = method.invoke(target, args);
        return result;
    }
}
