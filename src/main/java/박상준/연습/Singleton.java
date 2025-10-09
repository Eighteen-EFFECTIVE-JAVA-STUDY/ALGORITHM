package 박상준.연습;

/**
 * Double-Checked Locking 패턴의 Singleton
 * 
 * volatile이 필요한 이유:
 * 1. 가시성 문제: instance = new Singleton() 할당 시
 * 생성자 실행과 필드 할당이 재정렬될 수 있음
 * 2. 부분 초기화된 객체 노출: 다른 스레드가 완전히 초기화되지 않은
 * 객체를 참조할 수 있는 위험 존재
 */
public class Singleton {
    // volatile 없으면: 부분 초기화된 객체가 다른 스레드에 보일 수 있음
    private static volatile Singleton instance;

    // 초기화 상태를 확인하기 위한 필드
    private final int initValue;

    private Singleton() {
        // 초기화 로직: 시간이 걸리는 작업 시뮬레이션
        try {
            Thread.sleep(10); // 생성자 실행 시간
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        initValue = 42; // 필드 초기화
    }

    public static Singleton getInstance() {
        // 1. 첫 번째 체크 (잠금 없이)
        if (instance == null) {
            // 2. 잠금 실행
            synchronized (Singleton.class) {
                // 3. 두 번째 체크 (잠금 후)
                if (instance == null) {
                    // 4. 객체 생성
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public int getInitValue() {
        return initValue;
    }
}

