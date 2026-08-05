class Solution {
    public boolean check(int current , int[] gas,int[] cost){

        int avail = 0;
        int n = 0;

        int len = gas.length;

        while(n<gas.length){
            
            avail += gas[current % len];
            avail -= cost[current % len];

            if(avail<0){
                return false;
            }

            n++;
            current ++;

            if(n == gas.length){
                break;
            }
        }
        
        return true;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        for(int i=0;i<gas.length;i++){

            if(gas[i] >= cost[i]){
                if(check(i,gas,cost)){
                    return i;
                };
            }
        }

        return -1;
    }
}
