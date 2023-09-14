package zfz.com.singleton;

public class HungrySingleton {
    /**
     * 在多线程环境下，如果多个线程同时调用 getInstance() 方法，可能会导致多个实例被创建。这是因为在多线程环境下，每个线程都有自己的工作内存，可能会将 singleton 变量的值缓存在自己的工作内存中，而不是从主内存中读取最新的值。
     * 为了解决这个问题，可以使用双重检查锁定来保证线程安全性。在 getInstance() 方法中，首先检查 singleton 是否为 null，如果为 null，则进入同步代码块。在同步代码块中再次检查 singleton 是否为 null，如果为 null，才创建实例。这样可以确保只有一个线程能够创建实例，其他线程在同步代码块外等待，避免了多个实例被创建的问题。
     * 使用双重检查锁定可以提高性能，因为只有在第一次创建实例时才需要进入同步代码块，后续调用 getInstance() 方法时直接返回已创建的实例，不需要再进入同步代码块。
     * 需要注意的是，在使用双重检查锁定时，要将 singleton 变量声明为 volatile，以保证在多线程环境下的可见性。这是因为在某些情况下，指令重排序可能会导致线程获取到一个未完全初始化的实例。通过使用 volatile 关键字修饰 singleton 变量，可以禁止指令重排序，保证在实例完全初始化之前，不会有其他线程获取到未完全初始化的实例。
     */
    private static volatile HungrySingleton instance;

    private HungrySingleton() {
        // 私有构造方法，防止外部实例化
    }

    public static HungrySingleton getInstance() {
        if (instance == null) {
            synchronized (HungrySingleton.class) {
                if (instance == null) {
                    instance = new HungrySingleton();
                }
            }
        }
        return instance;
    }
}
