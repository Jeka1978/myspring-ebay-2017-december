package taxes;

import myspring.InjectByType;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class TaxCalculator {

    @InjectByType
    private MaamResolver maamResolver  = new MaamResolverImpl();

    public double withMaam(double price) {
        return maamResolver.getMaam() * price + price;
    }

}
