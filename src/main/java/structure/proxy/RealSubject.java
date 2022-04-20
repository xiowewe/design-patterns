package structure.proxy;

/**
 * 真实主体
 * @author xiongwenwen
 * @since 2022/4/20 1:43 下午
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("访问真实主题方法...");
    }
}
