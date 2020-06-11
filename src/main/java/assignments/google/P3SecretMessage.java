package assignments.google;

public class P3SecretMessage {

    public String encode(String s, int offset) {
        if (offset == 0) {
            return s;
        }
        char[] secret = new char[s.length()];
        int idx = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = encodeChar(c, 'a', offset);
            } else if (c >= 'A' && c <= 'Z') {
                c = encodeChar(c, 'A', offset);
            }
            secret[idx++] = c;
        }
        return new String(secret);
    }

    private static char encodeChar(char current, char start, int offset) {
        return (char) (((current - start + offset) % 26) + start);
    }

    public String decode(String ciphertext, String mustOccur) {
        for (int i = 0; i < 26; ++i) {
            String decoded = encode(ciphertext, i);
            if (decoded.contains(mustOccur)) {
                return decoded;
            }
        }
        return "Not found!";
    }
}