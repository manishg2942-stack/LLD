
//Eager Initialization this is the simplest way to create a singleton class.
//  In this approach, the instance of the singleton class is created at the time of class
//  loading. This ensures that the instance is created before any thread accesses it, making it thread-safe without requiring synchronization.

class Singleton {
    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
//Lazy Initialization in this approach, the instance of the singleton class is created only when it is requested for the first time.
// This can save resources if the instance is not needed immediately, but it requires careful handling to ensure thread safety, especially in a multi-threaded environment.
class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

//Thread-Safe Singleton using Synchronized Method in this approach, the getInstance() method is synchronized to ensure that only one thread can access it at a time. This guarantees that only one instance of the singleton class is created, even in a multi-threaded environment. However, this approach can lead to performance issues due to the overhead of synchronization, especially if the getInstance() method is called frequently.
class Singletonsynchronized {
    private static Singletonsynchronized instance;

    private Singletonsynchronized() {}

    public static synchronized Singletonsynchronized getInstance() {
        if (instance == null) {
            instance = new Singletonsynchronized();
        }
        return instance;
    }
} 


class SingletonsynchronizedDoubleChecked {
    private static volatile SingletonsynchronizedDoubleChecked instance;

    private SingletonsynchronizedDoubleChecked() {}

    public static SingletonsynchronizedDoubleChecked getInstance() {
        if (instance == null) {
            synchronized (SingletonsynchronizedDoubleChecked.class) {
                if (instance == null) {
                    instance = new SingletonsynchronizedDoubleChecked();
                }
            }
        }
        return instance;
    }
}

class SingletonBillPugh {

    private SingletonBillPugh() {}

    private static class Helper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return Helper.INSTANCE;
    }
}

public class SingletonDesign {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        System.out.println(singleton1 == singleton2); // Output: true
        System.out.println(singletonLazy1 == singletonLazy2); // Output: true
    }
}