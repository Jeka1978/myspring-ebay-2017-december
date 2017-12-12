package never_use_switch;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */

@Service
@RequiredArgsConstructor
public class MailSender {
    private final MailDao dao;



    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        MailInfo mailInfo = dao.getMailInfo();
        int mailCode = mailInfo.getMailCode();
        if (mailCode == 1) {
            // 75 lines of which build welcome mail
            System.out.println("sending Welcome mail..");

        }else if (mailCode == 2) {
            // 64 lines of which build some other mail
            System.out.println("sending: don't call us we call you");
        }
    }
}




