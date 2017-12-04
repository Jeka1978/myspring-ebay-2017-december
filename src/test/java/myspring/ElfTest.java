package myspring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import taxes.TaxCalculator;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */

public class ElfTest {


    @Test
    public void testThatInjectRandomIntIsWorking() throws Exception {
        Elf elf = ObjectFactory.getInstance().createObject(Elf.class);
        System.out.println(elf);
        Assert.assertNotEquals(0,elf.getPower());
        Assert.assertNotEquals(0,elf.getDexterity());

    }

}




