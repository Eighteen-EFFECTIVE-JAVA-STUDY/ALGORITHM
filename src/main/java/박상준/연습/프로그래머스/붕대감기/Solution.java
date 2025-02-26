package 박상준.연습.프로그래머스.붕대감기;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        /*bandage	health	attacks	result [5, 1, 5]	30	[[2, 10], [9, 15], [10, 5], [11, 5]]	5*/
        System.out.println(solution.solution(new int[]{5, 1, 5}, 30, new int[][]{{2, 10}, {9, 15}, {10, 5}, {11, 5}}));
        
        /*[3, 2, 7]	20	[[1, 15], [5, 16], [8, 6]]	-1*/
        System.out.println(solution.solution(new int[]{3, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        
        // [4, 2, 7]	20	[[1, 15], [5, 16], [8, 6]]	-1
        System.out.println(solution.solution(new int[]{4, 2, 7}, 20, new int[][]{{1, 15}, {5, 16}, {8, 6}}));
        
        //[1, 1, 1]	5	[[1, 2], [3, 2]]	3
        System.out.println(solution.solution(new int[]{1, 1, 1}, 5, new int[][]{{1, 2}, {3, 2}}));
    }
    
    public int solution(int[] bandage, int maxHealth, int[][] attacks) {
        //붕대의 기술 시전 시간, 초당회복량 ,추가회복량
        int bandageTime = bandage[0];
        int bandageRecoveryPerSeconds = bandage[1];
        int bandageAddRecovery = bandage[2];
        
        int consecutiveTime = 0;
        
        int currentHealth = maxHealth;
        
        int lastAttackTime = attacks[attacks.length - 1][0];
        int attackIndex = 0;
        
        for (int time = 1; time <= lastAttackTime; time++) {
            //현재 시간이 공격 시간이면 공격
            if (attacks[attackIndex][0] == time) {
                currentHealth -= attacks[attackIndex][1];
                if (currentHealth <= 0) {
                    return -1;
                }
                
                consecutiveTime = 0;
                attackIndex++;
            } else {
                //공격이 없는 경우
                consecutiveTime++;
                //1초마다  bandageRecoveryPerSeconds 회복
                
                currentHealth += bandageRecoveryPerSeconds;
                if(currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
                
                // t 초 연속으로 붕대 감는 데 성공 y 만큼의 추가 회복
                if (consecutiveTime == bandageTime) {
                    currentHealth += bandageAddRecovery;
                    if(currentHealth > maxHealth) {
                        currentHealth = maxHealth;
                    }
                    consecutiveTime = 0;
                }
            }
        }
        
        return currentHealth;
    }
}
