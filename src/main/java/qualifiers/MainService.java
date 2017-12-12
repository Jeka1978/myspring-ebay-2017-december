package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class MainService {

    private final Dao backupDao;
    private final Dao mainDao;



    @Autowired
    public MainService(Dao backupDao, Dao mainDao) {
        this.backupDao = backupDao;
        this.mainDao = mainDao;
    }

    @Scheduled(cron = "1/1 * * * * ?")
    public void doWork(){
        System.out.println("Working...");
        mainDao.save();
    }

    @Scheduled(cron = "1/3 * * * * ?")
    public void doBackup() {
        System.out.println("backuping");
    }

}









