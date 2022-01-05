import java.util.ArrayList;
import java.util.List;

public class letterCombinationOfPhoneNumbers {

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] phone = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        getAllPossibleCombination(digits, 0, phone, ans, new StringBuffer());
        return ans;
    }

    void getAllPossibleCombination(String digits, int index, String[] phone, List<String> ans, StringBuffer ds) {
        if (index == digits.length()) {
            if (ds.length() != 0)
                ans.add(ds + "");
            return;
        }
        String chars = phone[Integer.parseInt(digits.charAt(index) + "") - 2];
        for (char c : chars.toCharArray()) {
            ds.append(c);
            getAllPossibleCombination(digits, index + 1, phone, ans, ds);
            ds.setLength(ds.length() - 1);
        }
    }

    public static void main(String[] args) {
        letterCombinationOfPhoneNumbers l =
                new letterCombinationOfPhoneNumbers();
        System.out.println(l.letterCombinations("234"));
    }
}