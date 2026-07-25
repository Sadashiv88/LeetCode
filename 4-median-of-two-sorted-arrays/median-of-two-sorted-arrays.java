class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int arr[]=new int[m+n];
        int n1=0;
        int n2=0;
        int temp=0;
        while(n1<n && n2<m){
            if(nums1[n1]>nums2[n2]){
                arr[temp++]=nums2[n2];
                n2++;
            }else{
                arr[temp++]=nums1[n1];
                n1++;
            }
        }
        while(n1<n){
            arr[temp++]=nums1[n1];
            n1++;
        }
        while(n2<m){
            arr[temp++]=nums2[n2];
            n2++;
        }
        if((m+n)%2==1) return (double)arr[(m+n)/2];
        int a1=(m+n)/2;
        int t=arr[a1];
        t+=arr[a1-1];
        return (double)t/2;
    }
}