package screen_saver;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * @author Evgeny Borisov
 */
@Component
@RequiredArgsConstructor
public class ColorFrame extends JFrame {
    private Random random = new Random();
    private final Color color;


    @PostConstruct
    private void init() throws HeadlessException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }

    public void moveToRandomLocation() {
        setLocation(random.nextInt(1200),random.nextInt(900));

        getContentPane().setBackground(color);
        repaint();
    }



}
