/**
 * A simple class to demonstrate how objects capture state and behavior.
 * State is captured by class variables. Behavior by class methods.
 *
 * This class is a model for a pet. A pet is described by its species, name,
 * gender, name of its guardian, and the excitement sounds it makes. (There
 * are other attributes that describe a bet, but five are enough to get us
 * started.
 *
 * Notice that the class below does not have a main() method. The class can
 * be accessed by other programs (classes) that will instantiate its objects
 * (ie, will create objects using this class). The easiest way for another
 * class to access this class, is for both to be in the same folder.
 *
 * This class includes a full complement of accessors and mutators (ie
 * methods that return the value of a variable and methods that change
 * that value). For clarity, these methods are the last 8 methods of
 * the class. Accessors and mutators go hand-in-hand with private method
 * variables. The restricted access to these variables means that we can
 * manipulate them only through methods within their originating class.
 *
 * The class also comes with two constructors, to demonstrate their role
 * and importance. Constructors are method-like parts of a class that
 * describe how to instantiate an object. In other words, constructors
 * determine how a class copies itself to a new object.
 *
 * In addition to constructors, accessors, and mutators, the class comprises
 * a few methods that demonstrate how behavior is captured and executed in
 * an object. These methods can be found immediately after the constructors.
 *
 */
public class Pet {

    private String species; // dog, cat, fish, etc
    private String name; // the name of the pet
    private String gender; // the gender of the pet
    private String excitementSound; // woof, meow, oink, etc

    /**
     * Default constructor. It creates the simplest instance of a Pet object,
     * assuming it will be a dog and assigns it a "woof" sound of excitement.
     */
    public Pet() {
        species = "Dog";
        excitementSound = "woof";
    } // constructor Pet

    /**
     * A more specific constructor that requires three field. This constructor
     * leaves the excitementSound null. We can always change it later using the
     * appropriate mutator.
     * @param species
     * @param name
     * @param gender
     */
    public Pet(String species, String name, String gender) {
        this.species = species;
        this.name = name;
        this.gender = gender;
    } // constructor Pet

    /**
     * Method to describe a pet
     */
    public void describePet() {
        if (gender==null || name==null || species==null) {
            System.out.printf("\n\n\tThere is incomplete information for this pet.\n");
        }
        if (gender!=null && name!=null && species!=null) {
            String sheHe = (gender.equalsIgnoreCase("female")) ? "she" : "he"; // gender pronoun
            System.out.printf("\n\n\t%s is a %s.\n\tWhen %s is excited, %s says \"%s\".\n", name, species, sheHe, sheHe, excitementSound);
        }
    } // method describePet

    /**
     * Method to make a pet speak.
     */
    public void speak() {
        System.out.printf("\n\n\t%s %S %s\n", excitementSound,excitementSound,excitementSound);
    }

    /*
    SETter methods are used to change the value of a variable for an existing
    object. Technically, we need on set method (aka setter) for each class
    variable. But this may not be always necessary. The formal term for a setter
    is mutator.
     */

    /** Method to change (set) value for species */
    public void setSpecies(String species) {
        this.species = species;
    } // method setSpecies

    /** Method to change (set) value for name */
    public void setName(String name) {
        this.name = name;
    } // method setName

    /** Method to change (set) value for gender */
    public void setGender(String gender) {
        this.gender = gender;
    } // method setGender

    /** Method to change (set) value for excitementSound */
    public void setExcitementSound(String excitementSound) {
        this.excitementSound = excitementSound;
    } // method setExcitementSound

    /*
    Complementing the setters of a class, are its getters (formally called
    accessors). An accessor (aka getter) is a method that gets and returns the
    value a variable. Technically, again, we need one getter for each variable
    but this may not be always necessary.
     */

    /** Method to get and return the value of species */
    public String getSpecies() {
        return species;
    } // method getSpecies

    /** Method to get and return the value of name */
    public String getName() {
        return name;
    } // method getName

    /** Method to get and return the value of specgenderies */
    public String getGender() {
        return gender;
    } // method getGender

    /** Method to get and return the value of excitementSound */
    public String getExcitementSound() {
        return excitementSound;
    } // method getExcitementSound

} // class Pet
