import java.util.Scanner;

public class S5_030725 {
    public static void main(String[] args) {
        // Insert in a sorted array
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k =  sc.nextInt();

        for(int i = n-1;i>=0;i--){
            if(arr[i]>k){
                arr[i+1] = arr[i];
            }
            else {
                arr[i+1] = k;
                break;
            }
        }

        for(int i : arr) System.out.println(i);
    }
}
