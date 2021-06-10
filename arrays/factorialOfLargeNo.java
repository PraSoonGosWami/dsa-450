package dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class factorialOfLargeNo {

    /**
     * Factorials of large numbers
     * https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
     */

    private static void multiply(int x, ArrayList<Integer> res) {
        int carry = 0;
        for (int i = 0; i < res.size(); i++) {
            int prod = res.get(i) * x + carry;
            res.set(i, prod % 10);
            carry = prod / 10;
        }
        while (carry != 0) {
            res.add(carry % 10);
            carry = carry / 10;
        }
    }

    public static void solution(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        for (int x = 2; x <= N; x++)
            multiply(x, res);
        Collections.reverse(res);
        System.out.println(res);
    }
}
