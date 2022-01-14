import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KthPermutation {
    int x =0;
    public String getPermutation(int n, int k) {
        int i = 1;
        int[] input = new int[n];
        int j = 0;
        while (i <= n) {
            input[j++] = i++;
        }

        Map<Integer, String> result = new HashMap<>();
        solve(input, 0, 0, result);
        System.out.println(result);
        return result.get(k);
    }

    void solve(int[] input, int index, int k, Map<Integer, String> result) {

        if (index == input.length - 1) {
            x += 1;
            String s ="";
            for(int  i : input){
                s+=i;
            }
            result.put(x, s);
            return;
        }

        for (int i = index; i < input.length; i++) {
            moveRight(input, i-1);
            solve(input, index + 1, k, result);
            moveLeft(input, i-1);
        }
    }

    void moveRight(int[] nums , int index){
        int temp = nums[index];
        while(index>=1){
            nums[index] = nums[index-1];
            index--;
        }
        nums[0]= temp;
    }


    void moveLeft(int[] nums , int index){
        int temp = nums[0];
        int x = 0;
        while(x<index){
            nums[x] = nums[x+1];
            x++;
        }
        nums[index]= temp;
    }

    public static void main(String[] args) {
        KthPermutation kthPermutation = new KthPermutation();
        System.out.println(kthPermutation.getPermutation(3,3));
    }
}

