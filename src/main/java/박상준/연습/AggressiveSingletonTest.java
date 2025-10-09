package 박상준.연습;

/**
 * 더 공격적인 테스트로 volatile 없이 문제 재현 시도
 */
public class AggressiveSingletonTest {

    static class UnsafeSingleton {
        private static UnsafeSingleton instance; // volatile 없음
        private int value1;
        private int value2;
        private int value3;

        private UnsafeSingleton() {
            // 복잡한 초기화로 재정렬 가능성 증가
            this.value1 = 1;
            this.value2 = 2;
            this.value3 = 3;

            // 긴 초기화 시간
            for (int i = 0; i < 1000000; i++) {
                Math.random();
            }
        }

        public static UnsafeSingleton getInstance() {
            if (instance == null) {
                synchronized (UnsafeSingleton.class) {
                    if (instance == null) {
                        instance = new UnsafeSingleton();
                    }
                }
            }
            return instance;
        }

        public boolean isConsistent() {
            return value1 == 1 && value2 == 2 && value3 == 3;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 공격적인 Singleton 테스트 (수백만 번 반복) ===");

        int inconsistentCount = 0;
        int totalTests = 1000000;

        for (int test = 0; test < totalTests; test++) {
            // 여러 스레드가 동시 접근
            Thread[] threads = new Thread[4];
            boolean[] foundInconsistent = { false };

            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(() -> {
                    UnsafeSingleton s = UnsafeSingleton.getInstance();
                    if (!s.isConsistent()) {
                        foundInconsistent[0] = true;
                    }
                });
            }

            for (Thread t : threads) {
                t.start();
            }

            for (Thread t : threads) {
                t.join();
            }

            if (foundInconsistent[0]) {
                inconsistentCount++;
            }

            // 테스트 중간 진행상황 출력
            if (test % 100000 == 0 && test > 0) {
                System.out.println("진행: " + test + "/" + totalTests +
                        ", 불일치: " + inconsistentCount);
            }
        }

        System.out.println("=== 결과 ===");
        System.out.println("총 테스트: " + totalTests);
        System.out.println("불일치 발견: " + inconsistentCount);
        System.out.println("불일치 비율: " + (inconsistentCount * 100.0 / totalTests) + "%");

        if (inconsistentCount == 0) {
            System.out.println("\n현대 JVM에서는 volatile 없어도 안전합니다!");
            System.out.println("하지만 이는 JVM 구현에 의존적이므로 volatile을 사용하는 것이 좋습니다.");
        }
    }
}

