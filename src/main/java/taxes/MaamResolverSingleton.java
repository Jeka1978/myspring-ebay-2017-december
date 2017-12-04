package taxes;

import lombok.SneakyThrows;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class MaamResolverSingleton {
    private static MaamResolverSingleton ourInstance = new MaamResolverSingleton();

    public static MaamResolverSingleton getInstance() {
        return ourInstance;
    }

    private MaamResolverSingleton() {
    }


    @SneakyThrows
    public double getMaam() {
        Thread.sleep(3000);
        return 0.16;
    }
}
