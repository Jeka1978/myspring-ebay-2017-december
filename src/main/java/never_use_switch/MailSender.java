package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */

@Service
public class MailSender {
    private final MailDao dao;
    private final   Map<String, MailGenerator> map;

    @Autowired
    public MailSender(MailDao dao, Map<String, MailGenerator> map) {
        this.dao = dao;
        this.map = map;
    }


    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        MailInfo mailInfo = dao.getMailInfo();
        String mailCode = String.valueOf(mailInfo.getMailCode());
        MailGenerator mailGenerator = map.get(mailCode);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException("mailcode " + mailCode + " not supported yet");
        }
        String html = mailGenerator.generate(mailInfo);
        send(html);

    }

    private void send(String html) {
        System.out.println("html = " + html);
    }
}









