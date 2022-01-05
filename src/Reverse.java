class Solution {
    public char[] reverseString(char[] s) {
        reverse(s, 0 , s.length-1);
        return  s;
    }
    void swap(char[] s, int i , int j){
        char temp = s[i];
        s[i]=s[j];
        s[j]=temp;
    }
    void reverse(char[] s , int i  , int j){

        if(j <i ){
            return ;
        }
        swap(s, i, j);
        reverse(s,i+1,j-1);
    }

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

    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "aaaj";
        System.out.println(s.isPalindrome(ss));

//        System.out.println(s.reverseString(ss.toCharArray()));
    }
}