Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are valid IPv4 addresses but "192.168.01.1", while "192.168.1.00" and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal string which may contain digits, lower-case English letter ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.

 

Example 1:

Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:

Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:

Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
 

Constraints:

queryIP consists only of English letters, digits and the characters '.' and ':'.
```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidIPAddress {
    private static final Set<Character> validChars = new HashSet<>();
    static {
        validChars.addAll(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
                'A', 'B', 'C', 'D', 'E', 'F'));
    }

    public static String validIPAddress(String queryIP) {
        String[] strsIPv4 = queryIP.split("\\.", -1);
        String[] strsIPv6 = queryIP.split("\\:", -1);
        if (strsIPv4.length == 4) {
            for (String str : strsIPv4) {
                if (!isValidIPv4(str)) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (strsIPv6.length == 8) {
            for (String str : strsIPv6) {
                if (!isValidIPv6(str)) {
                    return "Neither";
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }

    private static boolean isValidIPv4(String str) {
        try {
            int n = Integer.parseInt(str);
            if (n == 0)
                return str.length() == 1;

            if (str.charAt(0) == '0' && str.length() > 1) {
                return false;
            }

            return n > 0 && n < 256;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isValidIPv6(String str) {
        try {
            if (str.length() > 4) {
                return false;
            }
            if (str == null || str.isEmpty()) {
                return false;
            }
            for (Character ch : str.toCharArray()) {
                if (!validChars.contains(ch)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("2001:db8:85a3:0::8a2E:0370:7334"));
    }

}

```
