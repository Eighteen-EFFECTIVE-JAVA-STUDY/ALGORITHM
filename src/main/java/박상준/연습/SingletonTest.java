package 박상준.연습;

/**
 * volatile이 없는 Singleton의 문제점을 보여주는 테스트
 */
public class SingletonTest {

    // volatile이 없는 잘못된 Singleton
    static class BadSingleton {
        private static BadSingleton instance; // volatile 없음!
        private final int initValue;

        private BadSingleton() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            initValue = 42;
        }

        public static BadSingleton getInstance() {
            if (instance == null) {
                synchronized (BadSingleton.class) {
                    if (instance == null) {
                        instance = new BadSingleton();
                    }
                }
            }
            return instance;
        }

        public int getInitValue() {
            return initValue;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== volatile 없는 Singleton 테스트 ===");

        // 여러 스레드가 동시에 getInstance() 호출
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                BadSingleton bad = BadSingleton.getInstance();
                int value = bad.getInitValue();

                // 0이면 부분 초기화된 객체 (일부 JVM에서 발생 가능)
                if (value == 0) {
                    System.out.println("경고: 부분 초기화된 객체 감지! initValue=" + value);
                }
            });
        }

        // 모든 스레드 시작
        for (Thread t : threads) {
            t.start();
        }

        // 모든 스레드 완료 대기
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("=== volatile 있는 올바른 Singleton 테스트 ===");

        // volatile이 있는 올바른 Singleton 테스트
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                Singleton good = Singleton.getInstance();
                int value = good.getInitValue();
                // 올바른 Singleton은 항상 42 반환
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("테스트 완료");
    }
}
