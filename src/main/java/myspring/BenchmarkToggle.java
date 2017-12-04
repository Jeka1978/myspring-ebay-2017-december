package myspring;

import lombok.Data;
import lombok.SneakyThrows;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
@Data
public class BenchmarkToggle implements BenchmarkToggleMBean{
    private boolean enabled;

    @SneakyThrows
    public BenchmarkToggle() {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(this,new ObjectName("eBayMBEANS","name","benchmark"));
    }

    @Override
    public void killAll() {
        System.out.println("Lets go to the break");
        System.exit(666);
    }
}
