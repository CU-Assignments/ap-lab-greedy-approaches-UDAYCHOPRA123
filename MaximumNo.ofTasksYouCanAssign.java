import java.util.*;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int low = 0, high = tasks.length, ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                ans = mid;  
                low = mid + 1;  
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }

    private boolean canAssign(int[] tasks, int[] workers, int pills, int strength, int n) {
        int i = n - 1;  
        int j = workers.length - 1;  
        int remainingPills = pills;

        while (i >= 0) {
            if (j >= 0 && workers[j] >= tasks[i]) {
                
                j--; 
            } else if (j >= 0 && remainingPills > 0 && workers[j] + strength >= tasks[i]) {
                
                j--;
                remainingPills--;
            } else {
                return false; 
            }
            i--;
        }
        return true;
    }
}
