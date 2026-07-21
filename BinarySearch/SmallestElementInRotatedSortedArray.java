import java.util.Scanner;

class SmallestElementInRotatedSortedArray {
    public int findMin(int[] arr) {
        if (arr.length == 0) return -1;
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmallestElementInRotatedSortedArray solution = new SmallestElementInRotatedSortedArray();

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int result = solution.findMin(arr);
        System.out.println("Smallest element: " + result);

        scanner.close();
    }
}