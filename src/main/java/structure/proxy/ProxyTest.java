package structure.proxy;

/**
 *
 * @author xiongwenwen
 * @since 2022/4/20 1:47 下午
 */
public class ProxyTest {
    public static void main(String[] args) {

        /**
         * 静态代理
         *
         * 优点：可以在不修改目标对象的前提下扩展目标对象的功能
         * 缺点：
         *  -冗余。由于代理对象要实现与目标对象一致的接口，会产生过多的代理类。
         *  -不易维护。一旦接口增加方法，目标对象与代理对象都要进行修改。
         */
        Subject staticProxy = new StaticProxy();
        staticProxy.request();

        /**
         * 动态代理（JDK代理或接口代理）
         *
         * 静态代理在编译完成后代理类是一个实际的class文件。而动态代理是在运行时动态生成的，
         * 即编译完成后没有实际的class文件，而是在运行时动态生成类字节码，并加载到JVM中
         * 缺点：
         *  -动态代理对象不需要实现接口，但是要求目标对象必须实现接口
         */
        Subject realSubject = new RealSubject();
        Subject dynamicProxy = (Subject) new DynamicProxy(realSubject).getProxyInstance();
        dynamicProxy.request();

        /**
         * CGLIB 动态代理
         *
         * 通过cglib是一个第三方代码生成类库，运行时在内存中动态生成一个子类对象从而实现对目标对象功能的扩展。
         * 使用动态代理的对象必须实现一个或多个接口，但cglib代理的对象则无需实现对象接口，达到代理类无侵入。
         */
        Subject cglibProxy = (Subject) new CglibProxy(realSubject).getProxyInstance();
        cglibProxy.request();
    }
}
