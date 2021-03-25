package Package2;
import Package1.LockDownActivities1;

class IndoorSportsActivities extends LockDownActivities1 {
    public void Chess() { System.out.println("Chess is an Indoor Sports Activity"); }
    public void PingPong() { System.out.println("Ping Pong is an Indoor Sports Activity"); }
    public void Binge() { System.out.println("Binging is NOT an Indoor Sports Activity"); }
    public void Browse() { System.out.println("Browsing is NOT an Indoor Sports Activity"); }
}

class OnlineActivities extends LockDownActivities1 {
    public void Chess() { System.out.println("Chess is NOT an Online Activity"); }
    public void PingPong() { System.out.println("Ping Pong NOT is an Online Activity"); }
    public void Binge() { System.out.println("Binging is an Online Activity"); }
    public void Browse() { System.out.println("Browsing is an Online Activity"); }
}

public class CAT3b {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        IndoorSportsActivities indoor = new IndoorSportsActivities();
        OnlineActivities online = new OnlineActivities();

        System.out.println("-------- LockDownActivities implemented by IndoorSportsActivities --------");
        indoor.Chess(); indoor.PingPong(); indoor.Binge(); indoor.Browse();

        System.out.println("\n-------- LockDownActivities implememted by OnlineActivities --------");
        online.Chess(); online.PingPong(); online.Binge(); online.Browse();
    }
}
