package SortLibrary;

import StdLibrary.*;

public class QuickSort {
    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while(true) {
            while(less(a[++ i], v)) if(i == hi) break;
            while(less(v, a[-- j])) if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);

        return j;
    }

    public static void sort (Comparable[] a) {
        StdRandom.shuffle(a); //消除对输入的依赖性
        sort(a, 0, a.length - 1);
    }

    public static void sort (Comparable[] a, int lo, int hi) {
        if(lo >= hi) return ;

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch (Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show (Comparable[] a) {
        for(int i = 0; i < a.length; i ++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    private static boolean isSorted (Comparable[] a) {
        for(int i = 0; i < a.length; i ++)
            if(less(a[i], a[i - 1]))
                return false;
        return true;
    }

    public static void main (String[] args) {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

} 