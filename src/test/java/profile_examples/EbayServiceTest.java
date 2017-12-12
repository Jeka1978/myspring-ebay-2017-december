package profile_examples;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@ActiveProfiles("DEV")
public class EbayServiceTest {

    @Autowired
    private EbayService ebayService;

    @Test
    public void getTotalSalary() throws Exception {
        Assert.assertEquals(50,ebayService.getTotalSalary(),0.0001);
    }

}