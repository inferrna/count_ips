import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
    static Integer ipToInt(String ip) {
        String[] parts = ip.split("\\.");
        return parseInt(parts[0]) << 24 | parseInt(parts[1]) << 16
             | parseInt(parts[2]) <<  8 | parseInt(parts[3]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        if(args.length>0) {
            String filename = args[0];
            System.out.printf("Read from '%s'\n", filename);
            reader = new BufferedReader(new FileReader(filename));
        } else {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        final BitSet counterNegative = new BitSet(Integer.MAX_VALUE);
        final BitSet counterPositive = new BitSet(Integer.MAX_VALUE);
        AtomicInteger res = new AtomicInteger();
        reader.lines()
              .parallel()
              .unordered()
              .map(CNT::ipToInt)
              .forEach(ip -> {
                  if (ip>-1) {
                      if(!counterPositive.get(ip)) {
                          res.getAndIncrement();
                          counterPositive.set(ip);
                      }
                  } else if(!counterNegative.get(-ip)) {
                      res.getAndIncrement();
                      counterNegative.set(-ip);
                  }
              });

        System.out.printf("%d unique ips\n", res.get());
        reader.close();
    }
}
