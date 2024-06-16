import java.net.SocketException;
import java.util.SplittableRandom;
import java.util.stream.LongStream;

class Generate {
  public static void main(String[] args) throws SocketException {
    //long count = Integer.MAX_VALUE; // Number of random IPs to generate
    long count = 100000000; // Number of random IPs to generate
    SplittableRandom rnd = new SplittableRandom();
    LongStream.range(0, count)
            .parallel()
            .unordered()
            .forEach(i -> {
      // Generate random bytes for the IP address
      byte[] ipAddress = new byte[4];
      rnd.nextBytes(ipAddress);
      // Convert byte array to string representation of IP address
      System.out.printf("%d.%d.%d.%d\n", ipAddress[0]+128, ipAddress[1]+128, ipAddress[2]+128, ipAddress[3]+128);
    });
  }
}
