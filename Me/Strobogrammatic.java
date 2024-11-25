package Me;
import java.util.*;

public class Strobogrammatic {
    public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            
            if (!map.containsKey(leftChar)) return false;  //not a symmetric digit
            else if (map.get(leftChar) != rightChar) return false;  // is symmetric , so check if it matches with right side

            left++;
            right--;
        }

        return true; //otherwise true
    }

    public static void main(String[] args) {
        String num = "609"; // Example input
        System.out.println(num + " is strobogrammatic: " + isStrobogrammatic(num));
    }
}
