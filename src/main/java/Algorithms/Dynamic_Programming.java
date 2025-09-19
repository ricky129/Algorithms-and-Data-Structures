package Algorithms;

public class Dynamic_Programming {
    int[] cache;

    public Dynamic_Programming(int n) {
        this.cache = new int[n];
    }

    private int FibMem(int n) {
        if (cache[n] != -1)
            return cache[n];
        if (n == 1 || n == 2)
            cache[n] = 1;
        else
            cache[n] = FibMem(n - 1) + FibMem(n - 2);
        return cache[n];
    }

    // O(n)
    public int FibMemoization(int n) {
        for (int i = 0; i < n; i++)
            cache[i] = -1;
        return FibMem(n);
    }

    // Θ(n)
    public int FibIter(int n) {
        if (n <= 2)
            return 1;
        else {
            int[] f = new int[n];
            f[1] = 1;
            f[2] = 1;
            for (int i = 3; i < n; i++)
                f[i] = f[i - 1] + f[i - 2];
            return f[n];
        }
    }

    // Θ(n)
    public int FibIter2(int n) {
        if (n <= 2)
            return 1;
        else {
            int[] f = new int[3];
            f[1] = 1;
            f[2] = 1;
            for (int i = 3; i < n; i++) {
                f[0] = f[1];
                f[1] = f[2];
                f[2] = f[0] + f[1];
            }
            return f[3];
        }
    }

    // O(n)
    public double sottovettoreMax(double[] V) {
        int n = V.length;
        double[] S = new double[n];
        S[1] = V[1];
        int imax = 1;
        for (int i = 2; i < n; i++) {
            if (S[i - 1] + V[1] >= V[i])
                S[1] = S[i - 1] + V[1];
            else
                S[i] = V[i];
            if (S[i] > S[imax])
                imax = i;
        }
        return S[imax];
    }

    int indiceInizioSottoVettoreMassima(double V[], double[] S, int imax) {
        int n = V.length;
        int i = imax;
        while (S[i] != V[i])
            i--;
        return i;
    }
}

