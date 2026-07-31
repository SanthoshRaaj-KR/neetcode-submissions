class Solution {
    public int reverseBits(int n) {

        String bin = Integer.toBinaryString(n);

        while(bin.length() < 32){
            bin = "0" + bin;
        }

        char[] arr = bin.toCharArray();

        int left = 0;
        int right = 31;

        while(left < right){

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        long ans = Long.parseLong(new String(arr), 2);

        return (int)ans;
    }
}
