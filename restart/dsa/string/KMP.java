package restart.dsa.string;

public class KMP {

    public int findPattern(String sentence, String pattern) {
        if (pattern.length() == 0) return 0;  // Edge case for empty pattern

        // Build the LPS (Longest Prefix Suffix) array length till that point
        int[] lps = new int[pattern.length()];
        int len = 0;  // Length of the previous longest prefix suffix
        lps[0] = len; // Because longest prefix including first letter is 0 since there's no suffix letter there
        int i = 1;

        while (i < pattern.length()) {
            char c = pattern.charAt(i);
            if (c == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // If there's a prefix existing till the prev point which is the longest suffix
                // then check if there's a longest suffix till that point that is also a prefix
                // and continue till that
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    // There's no prefix match till prev point
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Perform the KMP search
        int si = 0;  // Index for sentence
        int pi = 0;  // Index for pattern

        while (si < sentence.length()) {
            if (pattern.charAt(pi) == sentence.charAt(si)) {
                si++;
                pi++;
            } else {
                if (pi != 0) {
                    pi = lps[pi-1];
                } else {
                    si++;
                }
            }

            if (pi == pattern.length()) {
                return si - pi;  // Found the pattern at index si - pi
            }
        }


        return -1;  // No match found
    }

    public static void main(String... args) {
        var kmp = new KMP();
//        System.out.println(kmp.findPattern("abcabcabx","abcab"));
//        System.out.println(kmp.findPattern("",""));
//        System.out.println(kmp.findPattern("a","a"));
//        System.out.println(kmp.findPattern("aaaaaaaaax","aaaax"));
//        System.out.println(kmp.findPattern("aabaaabaaac", "aabaaac"));
//        System.out.println(kmp.findPattern("abcabxbacbaxabcabcabx", "abcabxbacbaxabcabcabx"));
        System.out.println(kmp.findPattern("abababb", "abababb"));
    }
}
