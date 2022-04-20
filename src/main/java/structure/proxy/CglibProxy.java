package structure.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiongwenwen
 * @since 2022/4/20 2:13 下午
 */
public class CglibProxy implements MethodInterceptor {
    private Subject target;

    public CglibProxy(Subject target) {
        this.target = target;
    }

    /**
     * 为目标主体生成代理主体
     */
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        preRequest();

        Object result = method.invoke(target, args);

        afterRequest();
        return result;
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void afterRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
