package dsa;

public class minNumOfJumps {
    /**
     * Minimum number of jumps
     * https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
     */

    //{2,3,1,1,4}
    // O(N^2) | O(1)
    public static int solution1(int arr[]) {
        int i = 0;
        int jump = 0;
        int n = arr.length;
        while (i < n-1) {
            int maxRange = i + arr[i];
            if (maxRange >= n - 1) return ++jump;
            int index = i + 1;
            int j = index;
            int max = 0;
            while(j <= maxRange){
                if(max < j + arr[j]){
                    index = j;
                    max = j + arr[j];
                }
            }
            i = index;
            jump++;

        }
        return jump;
    }


    // O(N) | O(1)
    public static int solution2(int arr[]){
        int jump = 1;
        int steps = arr[0];
        int maxJump = arr[0];
        for(int i = 1; i < arr.length - 1; i++){
            maxJump = Math.max(maxJump, i+arr[i]);
            steps--;
            if(steps == 0){
                jump++;
                steps = maxJump = i;
                if(i >= maxJump)
                    return -1;
            }
        }
        return jump;
    }
}
