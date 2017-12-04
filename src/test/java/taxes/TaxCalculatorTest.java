package taxes;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class TaxCalculatorTest {
    @Test
    public void withMaam() throws Exception {
        TaxCalculator taxCalculator = new TaxCalculator();
        MaamResolver mock = Mockito.mock(MaamResolver.class);
        Mockito.when(mock.getMaam()).thenReturn(0.2);

//        taxCalculator.setMaamResolver(mock);

        double withMaam = taxCalculator.withMaam(100);
        Assert.assertEquals(120,withMaam,0.00001);
    }

}