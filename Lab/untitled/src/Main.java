import java.util.*;
import java.lang.*;


public class Main {
    /** 主方法 */
    public static void main(String[] args) {
        String q = "originally designed for computer clusters built from commodity hardware it has also found use on clusters of higher end hardware. hadoop is a part of apache foundation.";


        System.out.println(Arrays.toString(ngrams(q, 2)));
    }

    /** 返回两个整数变量较大的值 */
    public static String[] ngrams(String s, int len) {
        String[] parts = s.split(" ");
        String[] result = new String[parts.length - len + 1];
        for(int i = 0; i < parts.length - len + 1; i++) {
            StringBuilder sb = new StringBuilder();
            int k = 0;
            do {
                if(k > 0) sb.append(' ');
                sb.append(parts[i+k]);
                k++;
            }while (k < len);
            result[i] = sb.toString();
        }
        return result;
    }
}


//            for(int k = 0; k < len; k++) {
//                if(k > 0) sb.append(' ');
//                sb.append(parts[i+k]);
