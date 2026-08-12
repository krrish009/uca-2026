// package JAVA.Base64;

public class encoding {
   public static String encoding(String a) {
    if (a.equals("")) return "";

    char[] map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
                    .toCharArray();

    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < a.length(); i += 3) {

        int byte1 = a.charAt(i);
        int byte2 = (i + 1 < a.length()) ? a.charAt(i + 1) : 0;
        int byte3 = (i + 2 < a.length()) ? a.charAt(i + 2) : 0;

        int num1 = byte1 >> 2;
        int num2 = ((byte1 & 3) << 4) | (byte2 >> 4);
        int num3 = ((byte2 & 15) << 2) | (byte3 >> 6);
        int num4 = byte3 & 63;

        ans.append(map[num1]);
        ans.append(map[num2]);

        if (i + 1 < a.length())
            ans.append(map[num3]);
        else
            ans.append('=');

        if (i + 2 < a.length())
            ans.append(map[num4]);
        else
            ans.append('=');
    }

    return ans.toString();
}
   public static String decoding(String a) {
    if (a.equals("")) return "";

    String map = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < a.length(); i += 4) {

        char c1 = a.charAt(i);
        char c2 = a.charAt(i + 1);
        char c3 = a.charAt(i + 2);
        char c4 = a.charAt(i + 3);

        int num1 = map.indexOf(c1);
        int num2 = map.indexOf(c2);

        int num3 = (c3 == '=') ? 0 : map.indexOf(c3);
        int num4 = (c4 == '=') ? 0 : map.indexOf(c4);

        int byte1 = (num1 << 2) | (num2 >> 4);
        int byte2 = ((num2 & 15) << 4) | (num3 >> 2);
        int byte3 = ((num3 & 3) << 6) | num4;

        ans.append((char) byte1);

        if (c3 != '=')
            ans.append((char) byte2);

        if (c4 != '=')
            ans.append((char) byte3);
    }

    return ans.toString();
}    
public static void main(String[] args) {
        System.out.println(encoding("Man"));
        System.out.println(decoding("TWFu"));
    }
}
