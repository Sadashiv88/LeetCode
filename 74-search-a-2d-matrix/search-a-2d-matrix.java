class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int start=0;
        int end=(n*m)-1;
        while(start<=end){
            int mid=(start+end)/2;
            int ele=matrix[mid/m][mid%m];
            if(ele==target){
                return true;
            }else if(target>ele){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
}