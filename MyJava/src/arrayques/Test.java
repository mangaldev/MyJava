package arrayques;

/**
 * Created by mdev on 4/19/15.
 */
public class Test {

    public static void main(String[] args) {
        String input = "";
        input = input.toLowerCase();
        int result = get(input);
        System.out.println("result = " + result);
    }
    public static int get(String input){
        boolean[] result = new boolean[26];
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) >=97 && input.charAt(i)<=122){
                if(!result[input.charAt(i)-97])
                    result[input.charAt(i)-97] = true;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if(!result[i]){
                return 0;
            }
        }
        return 1;
    }

}
