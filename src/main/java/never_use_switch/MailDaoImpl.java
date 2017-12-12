package never_use_switch;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @author Evgeny Borisov
 */
@Repository
public class MailDaoImpl implements MailDao {
    private Random random = new Random();
    @Override
    public MailInfo getMailInfo() {
        return new MailInfo(random.nextInt(3)+1);
    }
}
