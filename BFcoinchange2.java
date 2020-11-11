class Solution {
    public int change(int amount, int[] coins) {
        //edge case 
        return helper (coins, amount, 0 , 0);
    }
     private int helper(int[] coins, int amount, int index, int path){
        
        //base 
        
        if(amount == 0) return 1;
        if(index > coins.length - 1 || amount < 0) return 0; 
        
        
        //logic 
        //choose 
    
        int ch = helper(coins, amount - coins[index], index, path);
        //not choosse 
        int notch = helper(coins, amount, index+1, path);
         
        
        
        return ch + notch;     
        
    }
}

//Time complexity exponential
//space complexity O(1)
