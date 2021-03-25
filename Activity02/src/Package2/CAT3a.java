package Package2;
import Package1.LockDownActivities;

class BodyCare implements LockDownActivities {
    public void Yoga() { System.out.println("Yoga is body care"); }
    public void Pilates() { System.out.println("Pilates is body care"); }
    public void Meditation() { System.out.println("Meditation is NOT body care"); }
    public void Sleep() { System.out.println("Sleep is NOT body care"); }
}

class MindCare implements LockDownActivities {
    public void Yoga() { System.out.println("Yoga is NOT mind care"); }
    public void Pilates() { System.out.println("Pilates is NOT mind care"); }
    public void Meditation() { System.out.println("Meditation is mind care"); }
    public void Sleep() { System.out.println("Sleep is mind care"); }
}

public class CAT3a {
    public static void main(String[] args) {
        System.out.println("SHREYAANS NAHATA: 19BCE2686\n");
        BodyCare body = new BodyCare();
        MindCare mind = new MindCare();

        System.out.println("-------- LockDownActivities implemented by BodyCare --------");
        body.Yoga(); body.Pilates(); body.Meditation(); body.Sleep();

        System.out.println("\n-------- LockDownActivities implememted by MindCare --------");
        mind.Yoga(); mind.Pilates(); mind.Meditation(); mind.Sleep();
    }
}
