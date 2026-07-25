import java.util.Arrays;
import java.util.Scanner;

public class BookAllocationProblem {
    public int findPages(int[] arr, int k) {
        // code here
        // the idea is to search from max(arr) to sum(arr)
        //  the min val at which the students can be allocated is answer
        
        //performing a brute force linear search for pages from max(pages)->sum(pages)
        long max=0, sum=0;
        for(int el:arr){
            if(max<el)max=el;
            sum+=el;
        }
        
        // perform binary search for least accepted value 
        if(k>arr.length)return -1;
        long ans=-1;
        long minPages=max, maxPages=sum;
        while(minPages<=maxPages){
            long mid =minPages+(maxPages-minPages)/2;
            if (studentsAllocated(mid,arr)<=k){
                ans=mid;
                maxPages=mid-1;
                
            }else{
                minPages=mid+1;
            }
            
        }
        return (int) ans;
        
    }
        
         int studentsAllocated(long pages, int [] arr){
            int pagesAllocated=0, stud=1;
            for(int i=0;i<arr.length;i++){
                if(arr[i]+pagesAllocated<=pages){
                    pagesAllocated+=arr[i];
                }else{
                    stud++;
                    pagesAllocated=arr[i];
                }
            }
            return stud;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            BookAllocationProblem solution = new BookAllocationProblem();

            System.out.print("Enter the number of books: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter the number of pages in each book:");
            for (int i = 0; i < n; i++) {
                System.out.print("Book " + (i + 1) + ": ");
                arr[i] = scanner.nextInt();
            }

            System.out.print("Enter the number of students: ");
            int k = scanner.nextInt();

            int minPages = solution.findPages(arr, k);
            if (minPages == -1) {
                System.out.println("It is not possible to allocate books to students.");
            } else {
                System.out.println("The minimum number of pages that can be allocated to a student is: " + minPages);
            }
        }
    
}
