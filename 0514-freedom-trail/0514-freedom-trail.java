public class Solution {
    private int[][] t = new int[101][101];

    int countSteps(int ringIndex, int i, int n) {
        int dist       = Math.abs(i - ringIndex);
        int wrapAround =  n - dist;
        
        return Math.min(dist, wrapAround);
    }
    
    private int solve(int ringIndex, int keyIndex, String ring, String key) {
        
        if (keyIndex == key.length()) {
            return 0;
        }
        
        if (t[ringIndex][keyIndex] != -1) {
            return t[ringIndex][keyIndex];
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == key.charAt(keyIndex)) {
                int totalSteps = countSteps(ringIndex, i, ring.length()) + 1 +
                        solve(i, keyIndex + 1, ring, key);
                result = Math.min(result, totalSteps);
            }
        }
        
        return t[ringIndex][keyIndex] = result;
    }
    
    public int findRotateSteps(String ring, String key) {
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, ring, key);
    }
}
