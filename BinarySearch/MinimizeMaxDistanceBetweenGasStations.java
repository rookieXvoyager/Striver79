import java.util.PriorityQueue;
import java.util.Scanner;
class MinimizeMaxDistanceBetweenGasStations{
// // Brute force approach
// public double minimiseMaxDistance(int[] arr, int k) {
// int [] how_many = new int[arr.length-1];
// for(int j=1;j<=k;j++)
// {
//     double maxDistance = Double.MIN_VALUE;
//     int maxIndex=-1;

//     for(int i=0;i<arr.length-1;i++){
//         int dist =arr[i+1]-arr[i];
//         double secLen=(double)(dist)/(1+how_many[i]);
//         if(maxDistance<secLen){
//             maxDistance=secLen;
//             maxIndex=i;

//         }
       
    
// }

//     how_many[maxIndex]++;

// }
// double maxMinDist=0;
// for(int i=0;i<arr.length-1;i++){
//     double dist = (double)(arr[i+1]-arr[i])/(how_many[i]+1);
//     if(dist>maxMinDist){
//         maxMinDist=dist;
//     }
// }
// return maxMinDist;


// }

// 

// Best approach using binary search
public int gasStationsReq(int [] arr, double dist){
    int count =0;
    for(int i=0;i<arr.length-1;i++){
        int req=(int)((arr[i+1]-arr[i])/dist);
        if( arr[i + 1] - arr[i]==req*dist)
            req--;
        count+=req;
    }
    return count;
}
public double minimiseMaxDistance(int [] arr, int k){
int n =arr.length;
double low=0, high =Double.MIN_VALUE;
for(int i=0;i<arr.length-1;i++){
    high=Math.max(arr[i+1]-arr[i], high);
}
    double res =-1;

while(high-low>1e-6){
    double mid =(low+high)/2.0;
    if(gasStationsReq(arr, mid)>k){
        low=mid;
    }else{
        high=mid;
        res=high;
    }
}
return res;
}

public static void main(String[] args) {
    MinimizeMaxDistanceBetweenGasStations obj = new MinimizeMaxDistanceBetweenGasStations();
   Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of gas stations: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the positions of the gaxs stations: ");
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.print("Enter the number of additional gas stations to add: ");
    int k = sc.nextInt();   
    double result = obj.minimiseMaxDistance(arr, k);
    System.out.println("The minimized maximum distance is: " + result);
}
}