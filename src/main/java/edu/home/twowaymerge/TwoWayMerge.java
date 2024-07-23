package edu.home.twowaymerge;

import java.util.Arrays;

public class TwoWayMerge {

    public static void main(String[] args){

        int[] a = {2,4,6,9};
        int[] b = {1,3,5,7,9,12,15};
        int[] c = twoWayMerge(a,b);
        System.out.println(Arrays.toString(c));
        int[] d = {16,20,22,27};
        int[] e = twoWayMerge(c,d);
        System.out.println(Arrays.toString(e));

    }

    private static int[] twoWayMerge(int[] a, int[] b){
        int[] c = new int [a.length+b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i< a.length && j<b.length){
            if(a[i]<b[j]){
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }
        while (i<a.length){
            c[k] = a[i];
            i++;
            k++;
        }
        while (j<b.length){
            c[k] = b[j];
            j++;
            k++;
        }
        return c;
    }


}
