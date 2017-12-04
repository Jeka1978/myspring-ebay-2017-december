package myspring;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        IRobot iRobot = null;
        iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        while (true) {
            iRobot.cleanRoom();
            Thread.sleep(2000);
        }
       /* EbayService ebayService = ObjectFactory.getInstance().createObject(EbayService.class);
        ebayService.doWork();
        ebayService.playTennis();*/
        /*MondayServiceImpl mondayService = ObjectFactory.getInstance().createObject(MondayServiceImpl.class);
        mondayService.doStuff();*/
    }
}
