package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class unionIntersection {
    /**
     * Union & intersection of two unsorted arrays
     * https://www.geeksforgeeks.org/find-union-and-intersection-of-two-unsorted-arrays/
     */

    /**
     * Using hash set
     * O(N+M) | O(N+M)
     */
    public static void unionUnsorted1(int a[], int b[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : a)
            set.add(x);
        for (int x : b)
            set.add(x);
        System.out.println(set);
    }

    /**
     * Using sorting for distinct elements only
     * O(M*LogM + N*LogN) | O(1)
     * for intersection print only if they are same i.e, in else part
     */
    public static void unionUnsorted2(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        int n = a.length;
        int m = b.length;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (b[j] < a[i]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i]+ " ");
                i++;
                j++;
            }
        }

        while (i < n) {
            System.out.print(a[i] + " ");
            i++;
        }

        while (j < m) {
            System.out.print(b[j] + " ");
            j++;
        }
        System.out.println("");
    }

    /**
     * Using two hash sets and java has functions
     * for all types - distinct or indistinct | sorted or unsorted
     * O(M+N) | O(M+N)
     * https://leetcode.com/problems/intersection-of-two-arrays/
     */
    public static void solution(int a[], int b[]) {
        HashSet<Integer> l = new HashSet<>();
        HashSet<Integer> r = new HashSet<>();
        for(int x : a)
            l.add(x);
        for(int x : b)
            r.add(x);
        //System.out.println("UNION: " + l.addAll(r) + " " + l);
        System.out.println("INTERSECTION: " + l.retainAll(r) + " " + l);
    }




}
