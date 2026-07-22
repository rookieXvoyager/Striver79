import java.util.Scanner;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        // the idea is to find the partition in both the arrays a1, a1 as [l1,r1], [l2,r2] such that
        //  the largest el in l1 is smaller than smallest el in r2
        //  the largest el in l2 is smaller than smallest el in r1
        // we use p1 and p2 to mark the partitions 
        // we use binary search to find these partitions 
        // once partitioned the median for 
        // odd length merged arr is max (l1[el at p1-1], l2[el at p2-1])
        // even length is max ((l1[el at p1-1], l2[el at p2-1])+ min(r1[el at p1], r2[el at p2]))/2

        int n1 =arr1.length,n2=arr2.length;
        // if arr1 is smaller than arr 2
        if (n1>n2) return findMedianSortedArrays(arr2, arr1);// since we find median based on arr1 being smaller 

        int low =0, high =n1;

        while(low<=high){
            // first partition at the mid of n1 
            int p1 =low+(high-low)/2;
            // second parition should contribute to making up half for median
            // i.e. by half of length minus length covered by el before p1
            int p2 =(n1+n2+1)/2-p1;

            int l1= (p1==0)?Integer.MIN_VALUE:arr1[p1-1];
            int r1= (p1==n1)?Integer.MAX_VALUE:arr1[p1];
            int l2=(p2==0)?Integer.MIN_VALUE:arr2[p2-1];
            int r2=(p2==n2)?Integer.MAX_VALUE:arr2[p2];
            // checking if the partitions are made correctly
            if (l1<=r2 && l2<=r1){
                // if the length of combined arrays is odd 
                if((n1+n2)%2!=0){return Math.max(l1, l2);}
                // if the length of combined arrays is even
                else{return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;}
            }else if (l1>r2){
                high=p1-1;
            }else{
                low=p1+1;
            }
        }
        return 0.00;
    }
        

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

        System.out.print("Enter the size of the first array: ");
        int n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n1; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < n2; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr2[i] = scanner.nextInt();
        }

        double median = solution.findMedianSortedArrays(arr1, arr2);
        System.out.println("Median of the two sorted arrays: " + median);

        scanner.close();
    }
}