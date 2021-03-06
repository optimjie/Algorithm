package com.leetcode.DailyChallenge._2021_10;

public class _14_剑指OfferII069山峰数组的顶部 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int[] l = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) l[i] = arr[i];
            else l[i] = Math.max(l[i - 1], arr[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) r[i] = arr[i];
            else r[i] = Math.max(r[i + 1], arr[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > l[i - 1] && arr[i] > r[i + 1]) return i;
        }
        return -1;
    }
    public int peakIndexInMountainArrayBinarySearch(int[] arr) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] < arr[mid + 1]) l = mid + 1; // 因为下取整所以mid+1不会越界
            else r = mid;
        }
        return l;
    }
}
