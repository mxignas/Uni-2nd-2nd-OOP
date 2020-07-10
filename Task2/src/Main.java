
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
class Main is the main class

int total - Total number of contestans

Main() - is the construcor which saves the data into class structure via add function
	- des is for the events a competitor has entered in
	- names are the name of competitor
	- serials are the serial number of that competitor
	- members are the committee members of each event
	- dRating is the difficulty rating for each player with each event
	- pos is the position they have acquired 
	- gender is their gender 
	
int ask() - is the interface of the main program
 */
public class Main {

    static void main(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    final int total = 10;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Competition[] c = new Competition[total];
    int serials[] = {1111, 1211, 1234, 5413, 6753, 1432, 6666, 3521, 8694, 9588};

    Main() {
        String des[][] = {{"floor excercise", "uneven bars"}, {"pommel horse", "vault", "still rings"}, {"still rings"}, {"vault"}, {"parallel bars"}, {"high bar"}, {"vault"}, {"uneven bars"}, {"balance beam"}, {"floor excercise", "pommel horse", "vault"}};
        String names[] = {"Lynda", "Mark", "John", "July", "Tom", "Austin", "Elton", "Taylor", "Selena", "Ben"};
        String members[][] = {{"Hillary", "Mike"}, {"Jim"}, {"Derick", "Peter"}, {"Kim"}, {"Jaton"}, {"Hazel"}, {"Kim"}, {"Truffel"}, {"Sean", "Drake"}, {"Hillary", "Mike"}};
        int dRating[][] = {{3, 2}, {2, 1, 3}, {1}, {2}, {3}, {1}, {2}, {3}, {1}, {3, 2, 2}};
        int pos[][] = {{1, 3}, {2, 2, 3}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10, 4, 7}};
        char gender[] = {'f', 'm', 'm', 'f', 'm', 'm', 'm', 'f', 'f', 'm'};
        for (int i = 0; i < total; i++) {
            c[i] = new Competition();
            c[i].add(names[i], serials[i], members[i], dRating[i], des[i], pos[i], gender[i]);
        }
    }

    int ask() throws Exception {
        System.out.println("1 - Display Event Information.");
        System.out.println("2 - List Competitor Events.");
        System.out.println("3 - List Event's Attempts.");
        System.out.print("Enter serial number: ");
        int choice = Integer.parseInt(br.readLine());
        return choice;
    }

    void listeventinfo() throws Exception {
        System.out.print("Enter Event Name: ");
        String event = br.readLine();
        String woman[] = {"balance beam", "uneven bars"};
        String man[] = {"pommel horse", "still rings", "parallel bars", "high bar"};
        if (event.toLowerCase().equalsIgnoreCase("floor exercise") || event.toLowerCase().equalsIgnoreCase("vault")) {
            System.out.print("Enter gender ('m' or 'f'): ");
            char g = (char) br.read();
            for (int i = 0; i < total; i++) {
                String members[] = new String[2];
                int drating[] = new int[total];
                String[] description = new String[total];
                float stime[] = new float[total];
                float score[] = new float[total];
                c[i].get(members, drating, description, score, stime);
                if (Arrays.asList(description).contains(event.toUpperCase()) && g == c[i].gen) {
                    System.out.println("\n*****************************");
                    System.out.println("Competitor's name: " + c[i].compName);
                    System.out.println("Competitor sieral number: " + c[i].compNumber);
                    System.out.print("Committee Member(s) of the event: ");
                    for (int j = 0; j < members.length; j++) {
                        if (members[j] != null) {
                            System.out.print(members[j] + ". ");
                        }
                    }
                }
                members = null;
                description = null;
            }
        }
        if ((Arrays.asList(man).contains(event.toLowerCase()))) {
            for (int i = 0; i < total; i++) {
                String members[] = new String[2];
                int drating[] = new int[total];
                String[] description = new String[total];
                float stime[] = new float[total];
                float score[] = new float[total];
                c[i].get(members, drating, description, score, stime);
                if (c[i].gen == 'm' && Arrays.asList(description).contains(event.toUpperCase())) {
                    System.out.println("\n*****************************");
                    System.out.println("Competitor's name: " + c[i].compName);
                    System.out.println("Competitor sieral number: " + c[i].compNumber);
                    System.out.print("Committee Member(s) of the event: ");
                    for (int j = 0; j < members.length; j++) {
                        if (members[j] != null) {
                            System.out.print(members[j] + ". ");
                        }
                    }
                }
                description = null;
                members = null;
            }
        }
        if ((Arrays.asList(woman).contains(event.toLowerCase()))) {
            for (int i = 0; i < total; i++) {
                String members[] = new String[2];
                int drating[] = new int[total];
                String[] description = new String[total];
                float stime[] = new float[total];
                float score[] = new float[total];
                c[i].get(members, drating, description, score, stime);
                if (c[i].gen == 'f' && Arrays.asList(description).contains(event.toUpperCase())) {
                    System.out.println("\n*****************************");
                    System.out.println("Competitor's name: " + c[i].compName);
                    System.out.println("Competitor sieral number: " + c[i].compNumber);
                    System.out.print("Committee Member(s) of the event: ");
                    for (int j = 0; j < members.length; j++) {
                        if (members[j] != null) {
                            System.out.print(members[j] + ". ");
                        }
                    }
                }
                description = null;
                members = null;
            }
        }
    }

    void listcompetitorevents() throws Exception {
        System.out.println("All serial numbers of the competitors: " + Arrays.toString(serials));
        System.out.print("Enter Serial number: ");
        int serial = Integer.parseInt(br.readLine());
        for (int i = 0; i < total; i++) {
            String members[] = new String[2];
            int drating[] = new int[total];
            String description[] = new String[total];
            float stime[] = new float[total];
            float score[] = new float[total];
            c[i].get(members, drating, description, score, stime);
            if (c[i].compNumber == serial) {
                System.out.println("\n*****************************");
                System.out.println("Competitor's name: " + c[i].compName);
                for (int j = 0; j < description.length; j++) {
                    if (description[j] != null) {
                        System.out.println("\nEvent name: " + description[j]);
                        System.out.println("Description of the event: " + description[j].toLowerCase());
                        System.out.println("Difficulty Rating: " + drating[j]);
                    }
                }
            }
            description = null;
            drating = null;
        }
    }

    void listeventsattempts() throws Exception {
        System.out.print("Enter Event Name: ");
        String event = br.readLine();
        if (event.toLowerCase().equalsIgnoreCase("floor exercise") || event.toLowerCase().equalsIgnoreCase("vault")) {
            System.out.print("Enter gender ('m' or 'f'): ");
            char g = (char) br.read();
            for (int i = 0; i < total; i++) {
                String members[] = new String[2];
                int drating[] = new int[total];
                String description[] = new String[total];
                float stime[] = new float[total];
                float score[] = new float[total];
                c[i].get(members, drating, description, score, stime);
                if (Arrays.asList(description).contains(event.toUpperCase()) && g == c[i].gen) {
                    System.out.println("\n*****************************");
                    System.out.println("Competitor's name: " + c[i].compName);
                    System.out.println("Competitor's sieral number: " + c[i].compNumber);
                    int arr = Arrays.asList(description).indexOf(event.toUpperCase());
                    System.out.println("\nRoutine: " + description[arr].toLowerCase());
                    System.out.println("Difficulty Rating: " + drating[arr]);
                    System.out.println("Score: " + score[arr]);
                }
                description = null;
                drating = null;
                score = null;
            }
        }
        String man[] = {"pommel horse", "still rings", "parallel bars", "high bar"};
        if ((Arrays.asList(man).contains(event.toLowerCase()))) {
            for (int i = 0; i < total; i++) {
                String members[] = new String[2];
                int drating[] = new int[total];
                String description[] = new String[total];
                float stime[] = new float[total];
                float score[] = new float[total];
                c[i].get(members, drating, description, score, stime);
                if (c[i].gen == 'm' && Arrays.asList(description).contains(event.toUpperCase())) {
                    System.out.println("\n*****************************");
                    System.out.println("Competitor's name: " + c[i].compName);
                    System.out.println("Competitor's sieral number: " + c[i].compNumber);
                    int arr = Arrays.asList(description).indexOf(event.toUpperCase());
                    System.out.println("\nRoutine: " + description[arr].toLowerCase());
                    System.out.println("Difficulty Rating: " + drating[arr]);
                    System.out.println("Score: " + score[arr]);
                }
                description = null;
                drating = null;
                score = null;
            }
        }
        String woman[] = {"balance beam", "uneven bars"};
        if ((Arrays.asList(woman).contains(event.toLowerCase()))) {
            for (int i = 0; i < total; i++) {
                String members[] = new String[2];
                int drating[] = new int[total];
                String description[] = new String[total];
                float stime[] = new float[total];
                float score[] = new float[total];
                c[i].get(members, drating, description, score, stime);
                if (c[i].gen == 'f' && Arrays.asList(description).contains(event.toUpperCase())) {
                    System.out.println("\n*****************************");
                    System.out.println("Competitor's nameame: " + c[i].compName);
                    System.out.println("Competitor's sieral number: " + c[i].compNumber);
                    int arr = Arrays.asList(description).indexOf(event.toUpperCase());
                    System.out.println("\nRoutine: " + description[arr].toLowerCase());
                    System.out.println("Difficulty Rating: " + drating[arr]);
                    System.out.println("Score: " + score[arr]);
                }
                description = null;
                drating = null;
                score = null;
            }
        }
    }
}
