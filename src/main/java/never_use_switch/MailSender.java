package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */

@Service
public class MailSender {
    private final MailDao dao;
    private Map<Integer, MailGenerator> map = new HashMap<>();

    @Autowired
    public MailSender(MailDao dao,List<MailGenerator> mailGenerators) {
        this.dao = dao;
        for (MailGenerator mailGenerator : mailGenerators) {
            if (map.containsKey(mailGenerator.myCode())) {
                throw new IllegalStateException(mailGenerator.myCode() + " already in use");
            }
            map.put(mailGenerator.myCode(), mailGenerator);
        }

    }


    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        MailInfo mailInfo = dao.getMailInfo();
        int mailCode = mailInfo.getMailCode();
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









