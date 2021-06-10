package dsa.arrays;

import java.util.Arrays;

public class minimzeHeigths {
    /**
     * Minimize the Heights II
     * https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
     * IMPORTANT - THIS SOLUTION DOES NOT WORK
     */

    public static int solution(int arr[], int k){
        Arrays.sort(arr);
        int n = arr.length;
        int min = arr[0] + k;
        int max = arr[n-1] - k;
        for(int i = 1; i < n-1; i++){
            System.out.println("MIN: " + min + " MAX: " + max);
            int curMin = arr[i] - k;
            int curMax = arr[i] + k;
            if(max - curMin <= curMax - min)
                min = curMin;
            else
                max = curMax;

        }
        return (max-min);
    }
    public static int solution2(int arr[], int k, int n){
        if(n <= 0)
            return 0;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int i =0;
        while(i < n){
            if(arr[i] - k < 0){
                arr[i] += k;
                i++;
            }
            else break;
        }
        System.out.println(Arrays.toString(arr));

        int min = arr[0];
        int max = arr[i == 0 ? 0 : i-1];
        while(i < n){
            int sub = arr[i] - k;
            int add = arr[i] + k;
            int curMin = min;
            int curMax = max;
            if(sub < min)
                curMin = sub;
            else if(sub > max)
                curMax = sub;
            int resFromMin = curMax - curMin;
            int resFromMax = add-min;
            if(resFromMin < resFromMax && resFromMin != max-min){
                min = curMin;
                max = curMax;
            }else{
                max = add;
            }
            i++;
        }
        return (max-min);
    }
}
