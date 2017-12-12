package screen_saver;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
public class ScreenSaverConf {
    private Random random = new Random();

    @Value("${OS}")
    private String os;

    @Bean
    public ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            protected Color getColorBean() {
                return color();
            }
        };
    }



    @Bean
    @Scope(value = "prototype")
    public Color color() {
        if (os.toLowerCase().contains("unix")) {
            return Color.GRAY;
        }
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }


    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenSaverConf.class);
        while (true) {
            context.getBean(ColorFrame.class).moveToRandomLocation();
            Thread.sleep(80);
        }
    }
}
















