import java.util.ArrayList;
import java.util.List;

 class Solution2 {

    boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(j>i){
            if(s.charAt(j) != s.charAt(i)){
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionString(s, 0, new ArrayList<>(), ans );
        return ans;
    }

    void partitionString(String s,int index , List ds , List<List<String>> ans ){
        if(index == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i= index ; i< s.length() ;i++){
            if(isPalindrome(s.substring(index,i+1))){
                ds.add(s.substring(index,i+1));
                partitionString(s, index +1 ,ds ,ans);
                ds.remove(ds.size()-1);
            }

        }
    }

     public static void main(String[] args) {
         Solution2 s2  = new Solution2();
         System.out.println(s2.partition("aa"));
     }
}