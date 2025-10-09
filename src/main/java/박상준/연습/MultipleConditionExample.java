package 박상준.연습;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Queue;
import java.util.LinkedList;

/**
 * ReentrantLock과 Condition 다중 조건 예시
 * 우선순위별로 다른 큐를 사용하는 생산자-소비자 패턴
 */
public class MultipleConditionExample {

    private final ReentrantLock lock = new ReentrantLock();

    // 여러 종류의 데이터를 위한 다중 조건
    private final Condition notEmptyHigh = lock.newCondition(); // 고우선순위 데이터용
    private final Condition notEmptyNormal = lock.newCondition(); // 일반 우선순위 데이터용
    private final Condition notEmptyLow = lock.newCondition(); // 저우선순위 데이터용
    private final Condition notFull = lock.newCondition(); // 버퍼 가득참 조건

    private final Queue<DataItem> highPriorityQueue = new LinkedList<>();
    private final Queue<DataItem> normalPriorityQueue = new LinkedList<>();
    private final Queue<DataItem> lowPriorityQueue = new LinkedList<>();

    private final int MAX_BUFFER_SIZE = 5;

    // 데이터 아이템 클래스
    static class DataItem {
        private final String data;
        private final Priority priority;
        private final long timestamp;

        public enum Priority {
            HIGH, NORMAL, LOW
        }

        public DataItem(String data, Priority priority) {
            this.data = data;
            this.priority = priority;
            this.timestamp = System.currentTimeMillis();
        }

        public String getData() {
            return data;
        }

        public Priority getPriority() {
            return priority;
        }

        public long getTimestamp() {
            return timestamp;
        }

        @Override
        public String toString() {
            return String.format("[%s] %s (time: %d)", priority, data, timestamp);
        }
    }

    /**
     * 데이터 생산 (우선순위에 따라 다른 큐에 추가)
     */
    public void produce(DataItem item) throws InterruptedException {
        lock.lock();
        try {
            // 버퍼가 가득 찬 경우 대기
            while (getTotalSize() >= MAX_BUFFER_SIZE) {
                System.out.println("버퍼가 가득참. 생산자 대기 중...");
                notFull.await();
            }

            // 우선순위에 따라 다른 큐에 추가
            switch (item.getPriority()) {
                case HIGH:
                    highPriorityQueue.offer(item);
                    System.out.println("고우선순위 데이터 생산: " + item);
                    notEmptyHigh.signal(); // 고우선순위 소비자에게 알림
                    break;
                case NORMAL:
                    normalPriorityQueue.offer(item);
                    System.out.println("일반 데이터 생산: " + item);
                    notEmptyNormal.signal(); // 일반 소비자에게 알림
                    break;
                case LOW:
                    lowPriorityQueue.offer(item);
                    System.out.println("저우선순위 데이터 생산: " + item);
                    notEmptyLow.signal(); // 저우선순위 소비자에게 알림
                    break;
            }

        } finally {
            lock.unlock();
        }
    }

    /**
     * 고우선순위 데이터 소비
     */
    public DataItem consumeHigh() throws InterruptedException {
        lock.lock();
        try {
            while (highPriorityQueue.isEmpty()) {
                System.out.println("고우선순위 큐가 비어있음. 소비자 대기 중...");
                notEmptyHigh.await();
            }

            DataItem item = highPriorityQueue.poll();
            System.out.println("고우선순위 데이터 소비: " + item);
            notFull.signal(); // 생산자에게 버퍼 공간 확보 알림
            return item;

        } finally {
            lock.unlock();
        }
    }

    /**
     * 일반 우선순위 데이터 소비
     */
    public DataItem consumeNormal() throws InterruptedException {
        lock.lock();
        try {
            while (normalPriorityQueue.isEmpty()) {
                System.out.println("일반 큐가 비어있음. 소비자 대기 중...");
                notEmptyNormal.await();
            }

            DataItem item = normalPriorityQueue.poll();
            System.out.println("일반 데이터 소비: " + item);
            notFull.signal(); // 생산자에게 버퍼 공간 확보 알림
            return item;

        } finally {
            lock.unlock();
        }
    }

    /**
     * 저우선순위 데이터 소비
     */
    public DataItem consumeLow() throws InterruptedException {
        lock.lock();
        try {
            while (lowPriorityQueue.isEmpty()) {
                System.out.println("저우선순위 큐가 비어있음. 소비자 대기 중...");
                notEmptyLow.await();
            }

            DataItem item = lowPriorityQueue.poll();
            System.out.println("저우선순위 데이터 소비: " + item);
            notFull.signal(); // 생산자에게 버퍼 공간 확보 알림
            return item;

        } finally {
            lock.unlock();
        }
    }

    /**
     * 전체 큐 크기 계산
     */
    private int getTotalSize() {
        return highPriorityQueue.size() + normalPriorityQueue.size() + lowPriorityQueue.size();
    }

    /**
     * 현재 상태 출력
     */
    public void printStatus() {
        lock.lock();
        try {
            System.out.println("=== 현재 상태 ===");
            System.out.println("고우선순위 큐: " + highPriorityQueue.size() + "개");
            System.out.println("일반 큐: " + normalPriorityQueue.size() + "개");
            System.out.println("저우선순위 큐: " + lowPriorityQueue.size() + "개");
            System.out.println("전체: " + getTotalSize() + "/" + MAX_BUFFER_SIZE);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultipleConditionExample example = new MultipleConditionExample();

        System.out.println("=== ReentrantLock 다중 조건 예시 시작 ===");

        // 생산자 스레드들
        Thread producer1 = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    example.produce(new DataItem("긴급 메시지 " + (i + 1), DataItem.Priority.HIGH));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread producer2 = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    example.produce(new DataItem("일반 메시지 " + (i + 1), DataItem.Priority.NORMAL));
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread producer3 = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    example.produce(new DataItem("저우선순위 메시지 " + (i + 1), DataItem.Priority.LOW));
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 소비자 스레드들
        Thread consumerHigh = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    example.consumeHigh();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerNormal = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    example.consumeNormal();
                    Thread.sleep(1200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerLow = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    example.consumeLow();
                    Thread.sleep(1800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // 생산자들 시작
        producer1.start();
        producer2.start();
        producer3.start();

        // 잠시 대기 후 소비자들 시작
        Thread.sleep(500);
        consumerHigh.start();
        consumerNormal.start();
        consumerLow.start();

        // 모든 스레드 완료 대기
        producer1.join();
        producer2.join();
        producer3.join();
        consumerHigh.join();
        consumerNormal.join();
        consumerLow.join();

        System.out.println("\n=== 최종 상태 ===");
        example.printStatus();

        System.out.println("\n=== 예시 완료 ===");
        System.out.println("각 우선순위별로 다른 Condition을 사용하여");
        System.out.println("해당 우선순위의 데이터가 있을 때만 해당 소비자를 깨웁니다.");
        System.out.println("이렇게 하면 synchronized의 단일 조건과 달리");
        System.out.println("복잡한 스레드 간 협력 로직을 체계적으로 구현할 수 있습니다.");
    }
}