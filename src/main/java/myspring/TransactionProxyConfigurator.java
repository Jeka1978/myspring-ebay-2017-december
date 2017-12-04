package myspring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class TransactionProxyConfigurator implements ProxyConfigurator {
    @Override
    public Object wrapWithProxy(Object t, Class type) {
        if (type.isAnnotationPresent(Transactional.class)) {
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("************TRANSACTION OPENED *************");
                    Object retVal = null;
                    try {
                        retVal = method.invoke(t, args);
                        System.out.println("*********** TRANSACTION CLOSED ****************");
                    } catch (Exception e) {
                        System.out.println("***ROLLED BACK*********");
                    }
                    return retVal;
                }
            });
        } else {
            return t;
        }
    }
}
