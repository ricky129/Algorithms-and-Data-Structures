package Algorithms;

import Basic_Data_Structures.Stack.StaticStack;

import java.util.Arrays;
import java.util.Collections;

public class Algorithms {

    // O(2^n)
    public void Hanoi(StaticStack p1, StaticStack p2, StaticStack p3, int n) {
        if (n == 1)
            p3.push(p1.pop());
        else {
            Hanoi(p1, p3, p2, n - 1);
            p3.push(p1.pop());
            Hanoi(p2, p1, p3, n - 1);
        }
    }

    // O(n^3)
    public double sumMax1(double[] v) {
        double smax = v[0];
        int n = v.length;

        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                double s = 0;
                for (int k = i; k <= j; k++)
                    s += v[k];
                if (s > smax)
                    smax = s;
            }
        return smax;
    }

    //O(n^3)
    public double sumMax2(double[] v) {
        int n = v.length;
        double smax = v[1];
        for (int i = 0; i < n; i++) {
            double s = 0;
            for (int j = i; j < n; j++) {
                s += v[j];
                if (s > smax)
                    smax = s;
            }
        }
        return smax;
    }

    // O(n log n)
    public double sumMaxDI(double[] v, int i, int j) {
        if (i > j)
            return 0;
        else if (i == j)
            return v[i];
        else {
            int m = (int) Math.floor((double) (i + j) / 2);
            double l = sumMaxDI(v, i, m - 1);
            double r = sumMaxDI(v, m + 1, j);
            double sa = 0, sb = 0, s = 0;
            int k;
            for (k = m - 1; k >= i; k--) {
                s += v[k];
                if (s > sa)
                    sa = s;
            }
            s = 0;
            for (k = m + 1; k <= j; k++) {
                s += v[k];
                if (s > sb)
                    sb = s;
            }
            return Math.max(l, Math.max(r, v[m] + sa + sb));
        }
    }

    // O(n)
    public int greedyChange(int R, Integer[] T) {
        Arrays.sort(T, Collections.reverseOrder());
        int nm = 0;
        int i = 0;
        while (R > 0 && i < T.length) {
            if (R >= T[i]) {
                R -= T[i];
                nm++;
            } else
                i++;
        }
        if (R > 0) {
            System.out.println("Error: change not payable.");
            return -1;
        } else
            return nm;
    }
}
