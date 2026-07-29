import java.util.Scanner;

public class RemoveComments {

    public static String removeComments(String source) {
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;
        boolean inLine = false;
        boolean inString = false;
        boolean inChar = false;
        
        int n = source.length();
        for (int i = 0; i < n; i++) {
            char c = source.charAt(i);
            
            if (inBlock) {
                if (c == '*' && i + 1 < n && source.charAt(i + 1) == '/') {
                    inBlock = false;
                    i++; 
                }
            } else if (inLine) {
                if (c == '\n') {
                    inLine = false;
                    sb.append(c);
                }
            } else if (inString) {
                sb.append(c);
                if (c == '\\' && i + 1 < n) {
                    sb.append(source.charAt(i + 1));
                    i++;
                } else if (c == '"') {
                    inString = false;
                }
            } else if (inChar) {
                sb.append(c);
                if (c == '\\' && i + 1 < n) {
                    sb.append(source.charAt(i + 1));
                    i++;
                } else if (c == '\'') {
                    inChar = false;
                }
            } else {
                if (c == '/' && i + 1 < n && source.charAt(i + 1) == '*') {
                    inBlock = true;
                    i++;
                } else if (c == '/' && i + 1 < n && source.charAt(i + 1) == '/') {
                    inLine = true;
                    i++;
                } else {
                    sb.append(c);
                    if (c == '"') {
                        inString = true;
                    } else if (c == '\'') {
                        inChar = true;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String testInput = 
            "#include <stdio.h>\n" +
            "/* This is a multi-line \n" +
            "   comment block */\n" +
            "int main() {\n" +
            "    // This is a single line comment\n" +
            "    printf(\"Hello, /*World*/!\\n\"); // comment inside string is ignored\n" +
            "    char c = '/*'; // comment inside char constant is ignored\n" +
            "    int a = 5; /* trailing block */\n" +
            "    return 0;\n" +
            "}";

        System.out.println("--- Original Code ---");
        System.out.println(testInput);
        System.out.println("\n--- Code Without Comments ---");
        System.out.println(removeComments(testInput));
    }
}
