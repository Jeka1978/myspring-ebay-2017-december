package taxes;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class MaamResolverImpl implements MaamResolver {
    @Override
    @SneakyThrows
    public double getMaam() {
        Thread.sleep(3000);
        return 0.16;
    }
}
