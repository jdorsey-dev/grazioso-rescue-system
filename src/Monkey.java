// Monkey.java
// This class represents a monkey trained for search and rescue.
// This class will inherit from RescueAnimal and adds monkey-specific attributes.

public class Monkey extends RescueAnimal {

    // Unique attributes for Monkey
    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;

    // Default constructor
    public Monkey() {

    }

    //Full constructor that takes all values as parameters and assigns them to the class attributes
    // includes attributes from RescueAnimal
    public Monkey(String name, String species, String gender, String age, String weight,
              String acquisitionDate, String acquisitionLocation, String trainingStatus,
              boolean reserved, String inServiceCountry,
              String tailLength, String height, String bodyLength) {

        setName(name);
        setGender(gender);
        setAge(age);    
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionLocation);
        setTrainingStatus(trainingStatus.trim());
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setAnimalType("monkey");

        // Set monkey-specific attributes
        this.species = species;
        this.tailLength = tailLength;
        this.height = height;
        this.bodyLength = bodyLength;
    }

    // Accessor and getter for species
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    // Accessor and getter for tailLength
    public String getTailLength() {
        return tailLength;
    }

    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    // Accessor and getter for height
    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    // Accessor and getter for bodyLength
    public String getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }
}
