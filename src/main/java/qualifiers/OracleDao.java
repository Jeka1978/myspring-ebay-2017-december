package qualifiers;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

/**
 * @author Evgeny Borisov
 */

@Db(Type.BACKUP)
public class OracleDao implements Dao {
    @Override
    @SneakyThrows
    public void save() {
        Thread.sleep(100);
        System.out.println("saving to ORACLE....");
    }
}
