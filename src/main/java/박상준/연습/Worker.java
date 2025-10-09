package 박상준.연습;

public class Worker implements Runnable {
    // '영업 종료' 팻말 역할을 하는 변수 (가시성 보장)
    private volatile boolean shutdownRequested;

    public void shutdown() {
        // 사장님이 팻말을 겁니다. (쓰기 연산)
        shutdownRequested = true;
    }

    public void doWork() {
        // 손님들은 팻말을 계속 확인합니다. (읽기 연산)
        // 가시성 테스트를 위해 루프 안의 모든 IO/동기화를 제거하고 바쁜 대기만 수행
        while (!shutdownRequested) {
            // JDK 9+: 스핀 대기 힌트. 없으면 빈 루프가 되어도 무방
            Thread.onSpinWait();
        }
        // 종료 시점의 메시지 출력은 하지 않는다 (측정 출력만 메인에서 수행)
    }

    @Override
    public void run() {
        doWork();
    }
}
