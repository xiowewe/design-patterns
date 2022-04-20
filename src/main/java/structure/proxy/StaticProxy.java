package structure.proxy;

/**
 * 静态代理主体
 *
 * @author xiongwenwen
 * @since 2022/4/20 1:38 下午
 */
public class StaticProxy implements Subject {

    private RealSubject realSubject;

    @Override
    public void request() {
        if(null == realSubject){
            realSubject = new RealSubject();
        }

        preRequest();
        realSubject.request();
        afterRequest();
    }

    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void afterRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
