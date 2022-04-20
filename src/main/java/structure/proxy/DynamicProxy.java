package structure.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理主体
 *
 * @author xiongwenwen
 * @since 2022/4/20 1:54 下午
 */
public class DynamicProxy {

    private Subject target;

    public DynamicProxy(Subject target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    preRequest();

                    Object result = method.invoke(target, args);

                    afterRequest();
                    return result;
                });
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void afterRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
