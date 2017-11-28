package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class Main {
    public static void main(String[] args) {
       /* IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();*/
        EbayService ebayService = ObjectFactory.getInstance().createObject(EbayService.class);
        ebayService.doWork();
        ebayService.playTennis();
    }
}
