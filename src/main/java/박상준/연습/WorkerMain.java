package 박상준.연습;

public class WorkerMain {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t = new Thread(worker, "worker-thread");

        long startNanos = System.nanoTime();
        t.start();

        // 1초 후 영업 종료 팻말을 건다.
        Thread.sleep(1000);
        worker.shutdown();

        // 정상 종료 대기
        t.join();

        long elapsedNanos = System.nanoTime() - startNanos;
        long elapsedMillis = elapsedNanos / 1_000_000; // 포맷터 사용 없이 정수 밀리초만 출력
        System.out.println("소요 시간(ms): " + elapsedMillis);
    }
}
