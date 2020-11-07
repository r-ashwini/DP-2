class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        ArrayList<String> colors = new ArrayList<String>(Arrays.asList("0","1","2"));
        return helper (costs, 0 , colors , 0); 
    }
    
    private int helper (int[][] costs, int house, ArrayList<String> colors , int amount){
        //base 
        if (house > costs.length -1 && amount >= 0) return amount; 
        if (house > costs.length - 1 && amount < 0) return -1;
        
        //logic
        
        //choose
        if (colors.contains("0")){
        colors.remove("0");
        int red = helper(costs, house + 1, colors, amount + costs[house][0] );
        }
        if (colors.contains("1")){
        colors.remove("1");
        int blue = helper(costs, house + 1, colors, amount + costs[house][1] );
        }
        if (colors.contains("2")){
        colors.remove("2");
        int green = helper(costs, house + 1, colors, amount + costs[house][2] );
        }
        System.out.println("red " + red + " blue " + blue + " green " + green);
        if (red == -1 && blue == -1) return green; 
        if (red == -1 && green == -1) return blue;
        if (green == -1 && blue == -1) return red;
        
        if (red == -1) return Math.min(blue,green); 
        if (blue == -1) return Math.min(red, green);
        if (green == -1) return Math.min(red, blue);
        System.out.println(Math.min(Math.min(red, blue), green));
        return Math.min(Math.min(red, blue), green); 
        
    }
}
