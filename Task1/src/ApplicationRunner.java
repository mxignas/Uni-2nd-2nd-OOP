
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) throws FileNotFoundException {

        String dataFile = System.getProperty("user.dir") + File.separator + "traders.txt";
        Scanner input = new Scanner(new File(dataFile)); // scanner for file
        Scanner userinp = new Scanner(System.in);  // scanner for user input

        //////////////// READING FILE DATA AND CREATING OBJECT ///////////////////////////
        input.useDelimiter(":|\n");
        // creating array list
        ArrayList<Company> companiesList = new ArrayList<>();
        // variables for creating unique id
        int id = 1;
        int count = 1;

        // while there is something in a file
        while (input.hasNext()) {
            String companyName = input.next();
            String location = input.next();
            String services = input.next();
            int numEmployees = input.nextInt();
            double dailyRate = Double.valueOf(input.next().substring(1));
            String description = input.next();

            // giving unique id for each company created
            id = count;
            count++;
            //creating company with given parameters
            Company newCompany = new Company(companyName, location, services, numEmployees, dailyRate, description, id);
            //adding to an arraylist
            companiesList.add(newCompany);
        }
        //////////////// END OF READING FILE DATA AND CREATING OBJECT ///////////////////////////

        // Variables for menu
        String exit = "0";
        String list = "1";
        String selectTrader = "2";
        String selectLocation = "3";
        String searchServices = "4";

        // Menu for first time
        GUI();
        // User choice
        String userChoice = userinp.next();

        // Main loop
        // while user input is not equal to 0
        while (!userChoice.equals(exit)) {
            if (userChoice.equals(list)) {
                // calling method and passing parameters
                ListTraders(companiesList);
                System.out.println("");
                // Getting menu once again
                GUI();
                // waiting for user input
                userChoice = userinp.next();
            }
            if (userChoice.equals(selectTrader)) {
                System.out.println("Enter trader ID from list [1-25]: ");
                userChoice = userinp.next();
                System.out.println("");
                SelectTrader(companiesList, userChoice);
                System.out.println("");
                GUI();
                userChoice = userinp.next();
            }
            if (userChoice.equals(selectLocation)) {
                System.out.println("Enter search text: ");
                userChoice = userinp.next();
                System.out.println("");
                SelectLocation(companiesList, userChoice);
                System.out.println("");
                GUI();
                userChoice = userinp.next();
            }
            if (userChoice.equals(searchServices)) {
                System.out.println("Enter search text: ");
                userChoice = userinp.next();
                System.out.println("");
                SearchServices(companiesList, userChoice);
                System.out.println("");
                GUI();
                userChoice = userinp.next();
            }
        }
    }

    public static void GUI() {
        System.out.println("List traders.......1");
        System.out.println("Select trader......2");
        System.out.println("Search locations...3");
        System.out.println("Search services....4");
        System.out.println("Exit...............0");
        System.out.println("");
        System.out.println("Enter choice: ");
    }

    public static void ListTraders(ArrayList<Company> companies) {
        // specifying length of table
        int LengthOfTable = 127;
        for (int i = 0; i < LengthOfTable; i++) 
            System.out.print("-");

        // printing out first line
        System.out.println("");
        System.out.format("|%-4s|", " ID ");
        System.out.format("%-25s|", " Company name ");
        System.out.format("%-18s|", " Location ");
        System.out.format("%-75s|", " Services ");
        System.out.println("");

        for (int i = 0; i < LengthOfTable; i++) 
            System.out.print("-");

        System.out.println("");
        // for each loop for displaying each company information
        for (Company c : companies) {
            System.out.format("|%-4s|", " " + c.getID() + " ");
            System.out.format("%-25s|", " " + c.getCompanyName() + " ");
            System.out.format("%-18s|", " " + c.getLocation() + " ");
            System.out.format("%-75s|", " " + c.getServices() + " ");
            System.out.println("");
        }
        for (int i = 0; i < LengthOfTable; i++) 
            System.out.print("-");
    }

    public static void SelectTrader(ArrayList<Company> companies, String input) {
        // Converting string to integer
        int ID = Integer.parseInt(input);
        for (int i = 0; i < 70; i++) 
            System.out.print("-");
        System.out.println("");
        
        for (Company c : companies) {
            if (c.getID() == ID) {
                Company company = companies.get(ID);
                System.out.print(company);
            }
        }
        
        for (int i = 0; i < 70; i++) 
            System.out.print("-");
    }

    public static void SelectLocation(ArrayList<Company> companies, String input) {
        // getting user input
        String Location = input;
        // specifying length of table
        int LengthOfTable = 127;
        for (int i = 0; i < LengthOfTable; i++) {
            System.out.print("-");
        }

        // printing out first line
        System.out.println("");
        System.out.format("|%-4s|", " ID ");
        System.out.format("%-25s|", " Company name ");
        System.out.format("%-18s|", " Location ");
        System.out.format("%-75s|", " Services ");
        System.out.println("");

        for (int i = 0; i < LengthOfTable; i++) {
            System.out.print("-");
        }
        System.out.println("");

        for (Company c : companies) {
            if (c.getLocation().toLowerCase().contains(Location.toLowerCase())) {
                System.out.format("|%-4s|", " " + c.getID() + " ");
                System.out.format("%-25s|", " " + c.getCompanyName() + " ");
                System.out.format("%-18s|", " " + c.getLocation() + " ");
                System.out.format("%-75s|", " " + c.getServices() + " ");
                System.out.println("");
            }
        }
        for (int i = 0; i < LengthOfTable; i++) {
            System.out.print("-");
        }
    }

    public static void SearchServices(ArrayList<Company> companies, String input) {
        // getting user input
        String service = input;
        // specifying length of table
        int LengthOfTable = 127;
        for (int i = 0; i < LengthOfTable; i++) {
            System.out.print("-");
        }

        // printing out first line
        System.out.println("");
        System.out.format("|%-4s|", " ID ");
        System.out.format("%-25s|", " Company name ");
        System.out.format("%-18s|", " Location ");
        System.out.format("%-75s|", " Services ");
        System.out.println("");

        for (int i = 0; i < LengthOfTable; i++) {
            System.out.print("-");
        }
        System.out.println("");

        for (Company c : companies) {
            if (c.getServices().toLowerCase().contains(service.toLowerCase())) {
                System.out.format("|%-4s|", " " + c.getID() + " ");
                System.out.format("%-25s|", " " + c.getCompanyName() + " ");
                System.out.format("%-18s|", " " + c.getLocation() + " ");
                System.out.format("%-75s|", " " + c.getServices() + " ");
                System.out.println("");
            }
        }
        for (int i = 0; i < LengthOfTable; i++) {
            System.out.print("-");
        }
    }
}
