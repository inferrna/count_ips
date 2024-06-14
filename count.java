import java.io.*;
import java.util.*;


class CNT {
    static int parseInt(String s) {
        int digit = s.charAt(0) - '0';
        int result = digit;
        for(int i = 1; i < s.length(); ) {
            result *= 10;
            digit = s.charAt(i++) - '0';
            result += digit;
        }
        return result;
    }
    static int ipToInt(String ip) {
        String[] parts = ip.split("\\.");
        return parseInt(parts[0]) << 24 | parseInt(parts[1]) << 16
             | parseInt(parts[2]) << 8 | parseInt(parts[3]);
    }
    public static void main(String[] args) throws IOException {
        //System.out.printf("%d%n", parseInt("2255"));

        BufferedReader reader;
        if(args.length>1) {
            String filename = args[1];
            reader = new BufferedReader(new FileReader(filename));
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }
        long res = reader.lines()
                         .map(CNT::ipToInt)
                         .distinct()
                         .count();
        System.out.printf("%d unique ips", res);
        reader.close();
    }
}
