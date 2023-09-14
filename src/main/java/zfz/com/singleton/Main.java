package zfz.com.singleton;

import java.util.Objects;

/**
 * 1. 当一个类只需要存在一个实例，并且需要提供全局访问点时，可以使用单例模式。例如，数据库连接池、线程池、日志记录器等。
 * 2. 当实例化一个类的过程比较耗费资源，或者需要频繁实例化时，可以使用单例模式来复用实例，减少资源消耗。例如，配置文件读取器、缓存管理器等。
 */
public class Main {
    public static void main(String[] args) {
        BumSingleton bumSingleton1 = BumSingleton.getInstance();
        BumSingleton bumSingleton2 = BumSingleton.getInstance();
        //这里是同一个对象
        System.out.println("Objects.equals(singleton1,singleton2) = " + Objects.equals(bumSingleton1, bumSingleton2));

        HungrySingleton hungrySingleton1=HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2=HungrySingleton.getInstance();
        System.out.println("Objects.equals(hungrySingleton1,hungrySingleton2) = " + Objects.equals(hungrySingleton1, hungrySingleton2));

    }
}
