class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int case0 = costs[0][0] + helper(costs, 0, 0, 0);
        int case1 = costs[0][1] + helper(costs, 0, 0, 1);
        int case2 = costs[0][2] + helper(costs, 0, 0, 2);
        
        return Math.min(Math.min(case0,case1),case2);  
    }
    
    private int helper (int[][] costs, int house,int amount, int lastcolor){
        //base 
        if (house == costs.length - 1) return amount; 
        //logic
        int case0 = Integer.MAX_VALUE;
        int case1 = Integer.MAX_VALUE;
        int case2 = Integer.MAX_VALUE; 
        
        //choose
        if (lastcolor == 0) {
            case0 = Math.min (helper(costs, house + 1, amount + costs[house + 1][1], 1), helper(costs, house + 1, amount + costs[house + 1][2], 2));  
        }
        if (lastcolor == 1) {
            case1 = Math.min (helper(costs, house + 1, amount + costs[house + 1][0], 0), helper(costs, house + 1, amount + costs[house + 1][2], 2));  
        }
         if (lastcolor == 2) {
            case2 = Math.min (helper(costs, house + 1, amount + costs[house + 1][0], 0), helper(costs, house + 1, amount + costs[house + 1][1], 1));  
        }
        
        return Math.min(Math.min(case0, case1), case2); 
        
    }
}




//Successfully running for testcases and gives Time limit exceed error for with 28 rows
//time complexity is 3 * Math.pow(2, n-1)

