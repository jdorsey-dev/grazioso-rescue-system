import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<>();
    // Created a list to store Monkey objects
    private static ArrayList<Monkey> monkeyList = new ArrayList<>();

    public static void main(String[] args) {

        // initialized the default list of dogs and monkeys
        initializeDogList();
        // added this to initialize monkeys
        initializeMonkeyList();

        // Created a scanner object to read user input and a variable to store user's menu selection
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        // Created a loop that validates input, and runs until user enters 'q' or 'Q' to quit
        while (!userInput.equalsIgnoreCase("q")) {
            displayMenu(); // prints menu
            userInput = scanner.nextLine(); // reads input from user

            // if-else loop to handle menu selection
            if (userInput.equals("1")) {
                intakeNewDog(scanner); // call method to intake new dog
            } else if (userInput.equals("2")) {
                intakeNewMonkey(scanner); // call method to intake new monkey
            } else if (userInput.equals("3")) {
                reserveAnimal(scanner); // Call method to reserve an animal
            } else if (userInput.equals("4") || userInput.equals("5") || userInput.equals("6")) {
                printAnimals(userInput); // Call method to printAnimals
            } else if (!userInput.equalsIgnoreCase("q")) {
                System.out.println("Invalid selection. Please try again."); //validates selection
            }
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", 
        "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", 
        "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", 
        "Canada", "in service", false, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Added monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey( "George", "Capuchin", "male", "2", "15.0", "03-22-2021", 
        "Brazil", "in service", false, "Brazil", "24", "18", "16");
        Monkey monkey2 = new Monkey("Luna", "Marmoset", "female", "3", "12.5", "06-15-2020", 
        "Colombia", "Phase II", false, "Colombia", "20", "16", "14");
        Monkey monkey3 = new Monkey("Zeke", "Tamarin", "male", "4", "13.0", "01-11-2022", 
        "India", "in service", true, "India", "23", "17", "15");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }


    // This method intakes a new dog and adds it to the dogList
    // Validates for duplicate names
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for (Dog dog: dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }

        // Prompts for attributes for the dog
        System.out.println("Enter the dog's breed:");
        String breed = scanner.nextLine().trim();

        System.out.println("Enter the dog's gender (M or F)");
        String gender = scanner.nextLine().trim();

        System.out.println("Enter the dog's age:");
        String age = scanner.nextLine().trim();

        System.out.println("Enter the dog's weight (in lbs): ");
        String weight = scanner.nextLine().trim();

        System.out.println("Enter the acquisition date (MM-DD-YYYY):");
        String acquisitionDate = scanner.nextLine().trim();

        System.out.println("Enter the acquisition location:");
        String acquisitionLocation = scanner.nextLine().trim();

        System.out.println(" Enter the training status (intake, Phase I-V, in service, farm)");
        String trainingStatus = scanner.nextLine().trim();

        System.out.println("Is the dog reserved? (true/false):");
        boolean reserved = Boolean.parseBoolean(scanner.nextLine().trim());

        System.out.println("Enter the in-service country location (if applicable, or 'none')");
        String inServiceLocation = scanner.nextLine().trim();

        // Create the dog object
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionLocation, trainingStatus, reserved, inServiceLocation);

        // Add the new dog to the dogList
        dogList.add(newDog);
        System.out.println("New dog successfully added to the system!");
    }


    // This method was added to create a new Monkey object and adds it to the monkeyList.
    // this has validation to prevent duplicate names and makes sure the species is correct.
    public static void intakeNewMonkey(Scanner scanner) {
        // Prompts for Monkey name
        System.out.println("Enter the monkey's name:");
        String name = scanner.nextLine().trim();

        // Checks if a monkey with this name already exists.
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system.\n\n");
                return; //returns to the menu
            }
        }

        // Prompts for and validates species
        // loops until correct species
        String[] validSpecies = {"Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
        String species = "";
        boolean isValidSpecies = false;
        
        // validation loop for species
        while (!isValidSpecies) {
            System.out.println("Enter the monkey's species (Capuchin, Guenon, Macaque, Marmoset, Squirrel monkey, Tamarin): ");
            species = scanner.nextLine().trim();

            for (String s : validSpecies) {
                if (s.equalsIgnoreCase(species)) {
                    isValidSpecies = true;
                    break;
                }
            }
            if (!isValidSpecies) {
                System.out.println("Invalid species entered. Please try again.");
                System.out.println("--------------------------------------");
            }
        }

        // Prompts for remaining required attributes for monkey
        // Validates input for gender
        String gender = "";
        while (true) {
            System.out.println("Enter the monkey's gender (M/F):");
            gender = scanner.nextLine().trim().toUpperCase();
            if (gender.equals("M") || gender.equals("F")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'M' or 'F'.");
            }
        }
        // Validates input for age
        String age = "";
        while (true) {
            System.out.println("Enter the monkey's age (years):");
            age = scanner.nextLine().trim();

            try {
                int ageNum = Integer.parseInt(age);
                if (ageNum > 0) {
                    break;
                } else {
                    System.out.println("Age must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid inpute. Please enter a whole number for age.");
            }
        }
        // Validates input for weight
        String weight = "";
        while (true) {
            System.out.println("Enter the monkey's weight (in lbs):");
            weight = scanner.nextLine().trim();

            try {
                int weightNum = Integer.parseInt(weight);
                if (weightNum > 0) {
                    break;
                } else {
                    System.out.println("Weight must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number for weight.");
            }
        }
        // Validates if the format is MM-DD-YYYY
        // DOES NOT VALIDATE IF THE DATE ITSELF IS REAL!!
        String acquisitionDate = "";
        while (true) {
            System.out.println("Enter the acquisition date (MM-DD-YYYY):");
            acquisitionDate = scanner.nextLine().trim();

            if (acquisitionDate.matches("\\d{2}-\\d{2}-\\d{4}")) {
                break;
            } else {
                System.out.println("Invalid format. Please enter the date as MM-DD-YYYY.");
            }
        }
        // Validates if acquisitionLocation is an empty field.
        String acquisitionLocation = "";
        while (true) { 
            System.out.println("Enter the acquisition location (country):");
            acquisitionLocation = scanner.nextLine().trim();

            if(!acquisitionLocation.isEmpty()) {
                break;
            } else {
                System.out.println("Acquisition country cannot be empty.");
            }
        }

        // Validates input for training status
        String trainingStatus = "";
        while (true) {
            System.out.println("Enter the training status (intake, Phase I-V, in service, farm)");
            trainingStatus = scanner.nextLine().trim();

            if (trainingStatus.equalsIgnoreCase("intake") ||
                trainingStatus.equalsIgnoreCase("Phase I") ||
                trainingStatus.equalsIgnoreCase("Phase II") ||
                trainingStatus.equalsIgnoreCase("Phase III") ||
                trainingStatus.equalsIgnoreCase("Phase IV") ||
                trainingStatus.equalsIgnoreCase("Phase V") ||
                trainingStatus.equalsIgnoreCase("in service") ||
                trainingStatus.equalsIgnoreCase("farm")) {
                    break;
            } else {
                System.out.println("Invalid training status. Please enter one of the following:");
                System.out.println("intake, Phase I, Phase II, Phase III, Phase IV, Phase V, in service, farm.");
            }
        }
        
        // validates whether input is true or false
        boolean reserved = false;
        while (true) {
            System.out.println("Is the monkey reserved? (true/false):");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("true")) {
                reserved = true;
                break;
            } else if (input.equals("false")) {
                reserved = false;
                break;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
            }
        }

        // validates input on in-service country location
        String inServiceLocation = "";
        while (true) {
            System.out.println("Enter the in-service country location (if applicable, or 'none')");
            String input = scanner.nextLine().trim();
        
            if (!input.isEmpty()) {
                if (input.equalsIgnoreCase("none")) {
                    inServiceLocation = "";
                } else {
                    inServiceLocation = input;
                }
                break; 
            } else {
                System.out.println("Input cannot be empty. Please enter a country or 'none'.");
            }
        }

        // Below are monkey specific attributes
        // Validates input on tail length
        String tailLength = "";
        while (true) {
            System.out.println("Enter the monkey's tail length (in inches):");
            tailLength = scanner.nextLine().trim();

            try {
                double tailNum = Double.parseDouble(tailLength);
                if (tailNum > 0) {
                    break;
                } else {
                    System.out.println("Tail length must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for tail length.");
            }
        }

        //validates input on monkey's height
        String height = "";
        while(true) {
            System.out.println("Enter the monkey's height (in inches):");
            height = scanner.nextLine().trim();

            try {
                double heightNum = Double.parseDouble(height);
                if (heightNum > 0) {
                    break;
                } else {
                    System.out.println("Height must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for height in inches.");
            }
        }
        //validates input on monkey's body length
        String bodyLength = "";
        while(true) {
            System.out.println("Enter the monkey's body length (in inches):");
            bodyLength = scanner.nextLine().trim();

            try {
                double bodyLengthNum = Double.parseDouble(bodyLength);
                if (bodyLengthNum > 0) {
                    break;
                } else {
                    System.out.println("Body length must be greater than 0. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number for body length in inches.");
            }
        }

            // Instantiate the new Monkey object using the collected data
            Monkey newMonkey = new Monkey(name, species, gender, age, weight, acquisitionDate,
            acquisitionLocation, trainingStatus, reserved, inServiceLocation, 
            tailLength, height, bodyLength);
            
            // Add the new monkey to the monkeyList
            monkeyList.add(newMonkey);
            System.out.println("New monkey successfully added to the system!");
    }

    // This method reserves animal and prompts for animal type and in-service country, then reserves the first available animal
    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter the type of animal to reserve (dog or monkey):");
        String animalType = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter the in-service country of the animal:");
        String country = scanner.nextLine().trim();

        boolean found = false;

        //Validates animal type, and reserves animal requested
        if (animalType.equals("dog")) {
            for(Dog dog : dogList) {
                if (dog.getInServiceCountry().equalsIgnoreCase(country) && dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                    dog.setReserved(true);
                    System.out.println(dog.getName() + " has been reserved.");
                    found = true;
                    break;
                }
            }
        } else if (animalType.equals("monkey")) {
            for (Monkey monkey : monkeyList) {
                if (monkey.getInServiceCountry().equalsIgnoreCase(country) && monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    monkey.setReserved(true);
                    System.out.println(monkey.getName() + " has been reserved.");
                    found = true;
                    break;
                }
            }
        } else {
            //validates animal type
            System.out.println("Invalid animal type. Only 'dog' or 'monkey' are accepted.");
            return;
        }
        
        // displays no animals if none are available
        if (!found) {
            System.out.println("No available " + animalType + " found in " + country + ".");
        }
    }

    // This method displays animal info based on menu selection
    // Accepts a listType to determine which group to print
    // 4 = All dogs, 5 = ALL monkeys, 6 = all animals in service and not reserved (available)
    public static void printAnimals(String listType) {
        if (listType.equals("4")) {
            // this loop iterates through dogList and prints details of all dogs
            for (Dog dog : dogList) {
                System.out.println(dog.getName() + " | " + dog.getTrainingStatus() + " | " + dog.getAcquisitionLocation() + 
                " | Reserved: " + dog.getReserved());
            }
        } else if (listType.equals("5")) {
            // this loop iterates through monkeyList and prints details of all monkeys
            for (Monkey monkey : monkeyList) {
                System.out.println(monkey.getName() + " | " + monkey.getTrainingStatus() + " | " + 
                monkey.getAcquisitionLocation() + " | Reserved: " + monkey.getReserved());
                }
        } else if (listType.equals("6")) {
            // this loops through all dogs and prints those that are in servce and not reserved
            System.out.println("Dogs available:");
            for (Dog dog : dogList) {
                if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                    System.out.println(dog.getName() + " | " + dog.getTrainingStatus() + " | " + 
                    dog.getAcquisitionLocation() + " | Reserved: " + dog.getReserved());
                    }
                }
            
            System.out.println("\n------------------------------\n");

            // this loops through all monkeys and prints those that are in service and not reserved
            System.out.println("Monkeys available:");
            for (Monkey monkey : monkeyList) {
                if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                    System.out.println(monkey.getName() + " | " + monkey.getTrainingStatus() + " | " + 
                    monkey.getAcquisitionLocation() + " | Reserved: " + monkey.getReserved());
                }
            }
        } else {
            // this handles unexpected listType inputs
            System.out.println("Invalid list type! ");
        }

    }
}

