package myspring;

import lombok.Data;

import java.util.Random;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
@Data
public class Elf {

    @InjectRandomInt(min = 30,max = 50)
    private int power;
    @InjectRandomInt(min = 500,max = 700)
    private int dexterity;


}











