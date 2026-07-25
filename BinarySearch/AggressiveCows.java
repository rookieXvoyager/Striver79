import java.util.*;
class AggressiveCows {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        // brute force approach
        // the idea is to place the first cow at the first shed and check if
        // all the cows can be placed for some min distance
        // keep increasing min until u can check
        //  return the max min dist value
        
        // the range of min dist can range from 1 to max- min
       Arrays.sort(arr);
       for(int dist =1; dist<=arr[arr.length-1]-arr[0];dist++){
           if(canBePlaced(arr, dist, k)){
               continue;
           }else{
               return dist-1;
           }
           
           
       }return arr[arr.length-1]-arr[0];
        
        
    }
    
    static boolean canBePlaced(int [] arr, int dist, int k){
        // keep a count of cows placed
        int placed =1;
        int last =0;// assuming the first one is always placed 
        // keep a track at which last cow was placed 
        for(int i=1;i<arr.length;i++){
            if (arr[i]-arr[last]>=dist){
                placed++;
                last=i;
                
            }
            
        }
        return placed>=k;
    }
//optimal approach using binary search
public int aggressiveCowsOptimal(int[] arr, int k) {
        // code here
        // brute force approach
        // the idea is to place the first cow at the first shed and check if
        // all the cows can be placed for some min distance
        // keep increasing min until u can check
        //  return the max min dist value
        
        // the range of min dist can range from 1 to max- min
       Arrays.sort(arr);
       
       int left=1, right=arr[arr.length-1]-arr[0];
    
    while(left<=right){
        int mid =left +(right-left)/2;
        if (canBePlaced(arr, mid, k)){
            left=mid+1;
        }else{
            right=mid-1;
        }
    }
    return left-1;
        
        
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        AggressiveCows solution = new AggressiveCows();

        System.out.print("Enter the number of sheds: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the positions of the sheds:");
        for (int i = 0; i < n; i++) {
            System.out.print("Shed " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of cows: ");
        int k = scanner.nextInt();

        // int maxMinDistance = solution.aggressiveCows(arr, k);
        int maxMinDistance = solution.aggressiveCowsOptimal(arr, k);
        System.out.println("The largest minimum distance between any two cows is: " + maxMinDistance);
        scanner.close();
    }
}