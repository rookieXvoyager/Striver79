//Given an array of integers nums, find a peak element, and return its index. A peak element is an element that is strictly greater than its neighbors. If the array contains multiple peaks, return the index to any of the peaks.
//You may imagine that nums[-1] = nums[n] = -∞.
//You must write an algorithm that runs in O(log n) time.
import java.util.Scanner;
class FindPeakElement {
    public static int findPeakElement(int[] arr) {
        int n =arr.length;
        if(n==0) return -1;
        if(n==1) return 0;
        if(arr[0]>arr[1])return 0;
        if(arr[n-1]>arr[n-2])return n-1;

        int left =1, right=n-2;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {return mid;}
            else if(arr[mid]<arr[mid+1]){left=mid+1;}
            else{right=mid;}
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int result = findPeakElement(arr);
        if (result != -1) {
            System.out.println("Peak element found at index: " + result);
        } else {
            System.out.println("No peak element found.");
        }

        scanner.close();
    }
}