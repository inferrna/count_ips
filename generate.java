import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import java.net.SocketException;

class Generate {
  public static void main(String[] args) throws SocketException {
    //long count = Integer.MAX_VALUE; // Number of random IPs to generate
    long count = 1000000; // Number of random IPs to generate
    for (long i = 0; i < count; i++) {
      // Generate random bytes for the IP address
      byte[] ipAddress = new byte[4];
      new Random().nextBytes(ipAddress);
      // Convert byte array to string representation of IP address
      System.out.printf("%s.%d.%d.%d\n", ipAddress[0]+128, ipAddress[1]+128, ipAddress[2]+128, ipAddress[3]+128);
    }
  }
}
