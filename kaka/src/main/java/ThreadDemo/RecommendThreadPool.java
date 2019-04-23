package ThreadDemo;

import java.util.concurrent.*;

public class RecommendThreadPool {

    private static ExecutorService pool = new ThreadPoolExecutor(5, 5,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
