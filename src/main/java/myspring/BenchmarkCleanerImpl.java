package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */

public class BenchmarkCleanerImpl implements Cleaner{

    @InjectByType
    private CleanerImpl cleaner;

    @Override
    @Benchmark
    public void clean() {
        long start = System.nanoTime();
        cleaner.clean();
        long end = System.nanoTime();
        System.out.println(end-start);
    }
}
