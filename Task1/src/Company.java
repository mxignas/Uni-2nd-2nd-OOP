public class Company{

    private final String companyName;
    private final String location;
    private final String services;
    private final int numEmployees;
    private final double dailyRate;
    private final String description;
    private final int ID;

    // object for company
    public Company(String cName, String loc, String serv, int employ, double rate, String descrip, int id){
        companyName = cName;
        location = loc;
        services = serv;
        numEmployees = employ;
        dailyRate = rate;
        description = descrip;
        ID = id;
    }
    
    @Override
    public String toString() {
        return String.format("Company Name: %s\r\nLocation: %s\r\nServices: %s\r\nDescription: %s\r\nNumber of Employees: %s\r\nDaily Rate: %s\r\n", 
                companyName, location, services, description, numEmployees, dailyRate);
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getLocation() {
        return location;
    }

    public String getServices() {
        return services;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public String getDescription() {
        return description;
    }
    
    public int getID() {
        return ID;
    }
}