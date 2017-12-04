package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class MondayServiceImpl implements Comparable {
    @Benchmark
    public void doStuff() {
        System.out.println("playing tennis....");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
