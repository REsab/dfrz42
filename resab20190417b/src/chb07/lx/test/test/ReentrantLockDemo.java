package chb07.lx.test.test;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ReentrantLockDemo implements Runnable {
    private int number = 0;// 创建一个变量
    private Lock lock = new ReentrantLock();// 创建重入锁对象
    @Override
    public void run() {
        lock.lock();// 打开锁
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);// 线程休眠0.1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
// 输出当前线程的名称和number的值，每次循环之后number的值都会加一
                System.out.println(Thread.currentThread().getName() + ": "
                        + number++);
            }
        } finally {
            lock.unlock();// 释放锁
        }
    }
    public static void main(String[] args) {
        ReentrantLockDemo run = new ReentrantLockDemo();// 获得ReentrantLockDemo对象
        Thread thread1 = new Thread(run);// 创建线程1
        Thread thread2 = new Thread(run);// 创建线程2
        thread1.start();// 运行线程1
        thread2.start();// 运行线程2
    }
}
