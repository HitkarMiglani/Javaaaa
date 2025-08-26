import java.util.*;


public class Linear_Probing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int modValue = 11;
        int defValue = -1;
        int[] mp = new int[modValue];

        Arrays.fill(mp,defValue);

        for(int i = 0;i<n;i++) {
            int x = sc.nextInt();

            int idx = x%modValue;
            while (mp[idx]!=defValue){
                idx = (idx+1)%modValue;
                if(idx==x%modValue) {
                System.out.println("Hash table is full!");
                return;
                }
            }

            mp[idx] = x;
        }

        for(int i = 0;i<modValue;i++) {
            if(i!=modValue-1) System.out.print(mp[i]+" ");
            else System.out.print(mp[i]);
        }

        sc.close();
    }    

}
