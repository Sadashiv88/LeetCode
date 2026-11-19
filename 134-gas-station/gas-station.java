class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0;
        int totalcost=0;
        int start=0;
        int costs=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];

            costs+=(gas[i]-cost[i]);
            if(costs<0){
                start=i+1;
                costs=0;
            }
        }
        return totalgas>=totalcost?start:-1;
    }
}