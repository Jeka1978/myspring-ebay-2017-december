package quoters;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * @author Evgeny Borisov
 */
public class IntegerFactory implements FactoryBean<Integer>{

    @Nullable
    @Override
    public Integer getObject() throws Exception {
        return 120;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
