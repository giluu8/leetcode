class Solution {
    public int maxProfit(int[] a) {
        int maxProfit=0;
        int minSofar=a[0];
        for(int i=0;i<a.length;i++){
            minSofar=Math.min(minSofar,a[i]);
            int profit=a[i]-minSofar;
            maxProfit=Math.max(maxProfit,profit);
        }
        return maxProfit;
        
        
    }
}