package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class EbayServiceImpl implements EbayService {
    @Override
    public void doWork() {
        System.out.println("Working hard with a spark spring and mongo...");
    }

    @Override
    @Benchmark
    public void playTennis() {
        System.out.println("don't forget OREN to take your ROCKET");
    }
}
