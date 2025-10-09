package 박상준.연습;

/**
 * volatile 변수 증가 연산 테스트
 *
 * - 목적: volatile이 가시성은 보장하지만 ++ 같은 복합 연산의 원자성(atomicity)은 보장하지 않음을 실험으로 확인
 * - 방법: 여러 스레드가 같은 정적 변수(race)를 1씩 증가시키는 작업을 반복하고,
 * 모든 스레드가 끝난 후 최종 값을 출력한다.
 * - 기대: 이론상 최종값은 THREADS_COUNT * 10000 이어야 하지만, 증가 연산이 원자적이지 않아
 * 경쟁 상태(race condition)가 발생하므로 더 작은 값이 출력될 수 있다.
 */
public class VolatileTest {

    // 가시성은 보장되지만 ++의 원자성은 보장되지 않는다
    public static volatile int race = 0;

    /**
     * race 값을 1 증가시킨다.
     *
     * 주의: 'race++'는 (읽기 -> +1 -> 쓰기) 3단계로 분리되는 복합 연산이라
     * 여러 스레드가 동시에 실행하면 값이 유실될 수 있다.
     */
    public static void increase() {
        race++;
    }

    // 생성할 스레드 개수
    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];

        // 20개의 작업 스레드 생성 및 시작
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(() -> {
                // 각 스레드는 10,000번 증가 시도
                for (int i1 = 0; i1 < 10000; i1++) {
                    increase();
                }
            });
            threads[i].start();
        }

        // 모든 작업 스레드가 종료할 때까지 안전하게 대기
        // activeCount()는 JVM/IDE 보조 스레드까지 포함될 수 있어 무한 대기 위험이 있다.
        // 따라서 각 스레드에 대해 join()을 호출해 명시적으로 종료를 기다린다.
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                // 인터럽트가 걸리면 현재 스레드의 인터럽트 상태를 복원하고 루프를 계속 진행
                Thread.currentThread().interrupt();
            }
        }

        // 이론상 기대값: 20 * 10000 = 200,000
        // 실제 출력은 더 작을 수 있다 (원자성 미보장으로 인한 레이스 컨디션)
        System.out.println(race);
    }
}
