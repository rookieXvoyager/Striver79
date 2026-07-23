import java.util.Scanner;
class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // the minimum eating speed will always lie between 1 and max(piles[i])
        // we need to find the least speed in the range using binary search 
        if (piles.length==0)return 0;
        int max=Integer.MIN_VALUE;
        for(int el:piles)max=Math.max(el,max);
        // the elements are sorted on the basis of whether its possible or not
        //  the speed by default gets sorted, we apply binary search 
        // over the speed, but not the array itself
        int low =1, high=max;
        int res =max;

        while(low<=high){
            int mid =low+(high-low)/2;
            if(isSufficient(piles, mid,h)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }

    static boolean isSufficient(int [] piles, int k,int h){
        double totalTime=0;
        for(int pile:piles)
        totalTime+=(int)Math.ceil(((double)pile/k));
        return totalTime<=h;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KokoEatingBananas solution = new KokoEatingBananas();

        System.out.print("Enter the number of piles: ");
        int n = scanner.nextInt();
        int[] piles = new int[n];
        System.out.println("Enter the number of bananas in each pile:");
        for (int i = 0; i < n; i++) {
            System.out.print("Pile " + (i + 1) + ": ");
            piles[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of hours Koko has to eat: ");
        int h = scanner.nextInt();

        int minSpeed = solution.minEatingSpeed(piles, h);
        System.out.println("The minimum eating speed Koko needs is: " + minSpeed);
    }
}
