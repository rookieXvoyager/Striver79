import java.util.Scanner;

// find an element in a rotated sorted array with duplicates
// Approach: binary search
// search condition:
// find the mid element to decide which half is sorted
// check if the target is in the sorted half, if yes, search in that half, otherwise search in the other half
// review the edge cases where elements are equal, move the pointers and continue
// return false if the target is not found

class RotatedSortedArray {
    public boolean search(int[] arr, int target) {
        if(arr.length==0) return false;
        int n =arr.length;
        int left =0, right =arr.length-1;
        while (left<=right){
            int mid =left + (right-left)/2;
            if (arr[mid]==target)return true;
            // if the current range is duplicated(repeated elements exist)
            if(arr[left]==arr[mid]&& arr[mid]==arr[right]){
                left++;
                right--;
                continue;
            }
            // if the left half is sorted
            if (arr[left]<=arr[mid]){
                // check if the target lies in this sorted range
                if(arr[left]<=target && target<=arr[mid]){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            else{
                if(arr[mid]<=target && target<=arr[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        boolean result = solution.search(arr, target);
        System.out.println("\nResult: " + (result ? "Target found in the array" : "Target not found in the array"));

        scanner.close();
    }
}