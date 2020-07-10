
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ApplicationRunner {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main dum = new Main();
        int choice = dum.ask();
        switch (choice) {
            case 1:
                dum.listeventinfo();
                break;
            case 2:
                dum.listcompetitorevents();
                break;
            case 3:
                dum.listeventsattempts();
                break;
            default:
                System.out.println("Your choice doesnt exist.\n");
                Main.main(null);
        }
    }
}
