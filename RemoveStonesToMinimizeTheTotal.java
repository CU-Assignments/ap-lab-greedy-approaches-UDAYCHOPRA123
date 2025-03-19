import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 

        for (int pile : piles) {
            maxHeap.offer(pile);
        }

        while (k-- > 0) {
            int stones = maxHeap.poll();
            stones -= stones / 2; 
            maxHeap.offer(stones);
        }

        int total = 0;
        while (!maxHeap.isEmpty()) {
            total += maxHeap.poll();
        }

        return total;
    }
}
