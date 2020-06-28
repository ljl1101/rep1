package juc;

/**
 * @Description: 测试类
 * @Author: 敖丙
 * @date: 2020-04-26
 **/
public class Volatile {
    public static void main(String[] args) {
        Aobing a = new Aobing();
        a.start();
        for (; ; ) {
            if (a.isFlag()) {
                System.out.println("有点东西");
            }
        }
    }
}


class Aobing extends Thread {
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + flag);
    }
}

/**
 * @Description: 双重检查单例
 * @Author: 敖丙
 * @date: 2020-04-28
 **/
class Singleton {
    // 可见性和指令重排序都保证
    private volatile static Singleton instance = null;

    // 私有构造
    private Singleton() {
    }

    public static Singleton getInstance() {
        // 第一重检查锁定
        if (instance == null) {
            // 同步锁定代码块
            synchronized (Singleton.class) {
                // 第二重检查锁定
                if (instance == null) {
                    // 注意:非原子操作
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
