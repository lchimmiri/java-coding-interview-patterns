package arr;

public class MonotonicArr {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,2,2,3}));
        System.out.println(isMonotonic(new int[]{6,5,4,4}));
        System.out.println(isMonotonic(new int[]{1,3,2}));
    }

    // TC O(n) SC : O(1)
    public static boolean isMonotonic(int[] arr){
        boolean incFlag = true;
        boolean decFalg = true;
        for(int i=1 ; i<arr.length;i++){
            if(arr[i-1] < arr[i]){
                decFalg = false;
            }

            if(arr[i-1] > arr[i]){
                incFlag = false;
            }
        }

        return incFlag || decFalg;
    }
}
