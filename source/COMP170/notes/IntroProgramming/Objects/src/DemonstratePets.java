public class DemonstratePets {
    public static void main(String[] args) {

        // create a simple object:
        Pet puppy = new Pet();
        puppy.describePet(); // will give message incomplete description
        // let's update some values:
        puppy.setName("Obi");
        puppy.setGender("male");
        puppy.setExcitementSound("shriek"); // Obi was a Shiba Inu.
        // and try the description again
        puppy.describePet();

        // let's create a more defined object
        Pet anotherPuppy = new Pet("Dog","Mina","female");
        anotherPuppy.describePet();
        // Modify the sounds it makes
        anotherPuppy.setExcitementSound("woof");
        // try description above
        anotherPuppy.describePet();

        //We can even create arrays of objects
        Pet COMP170Pets[] = new Pet[3]; // array with three elements
        // populate the array

        COMP170Pets[0] = new Pet("dog","Scruffy","female"); // Use parameterised constructor
        COMP170Pets[0].setExcitementSound("woof"); // then supplement missing data

        COMP170Pets[1] = new Pet(); // use default constructor, then
        COMP170Pets[1].setName("Nala"); // use setters to update the
        COMP170Pets[1].setSpecies("cat"); // values of this object
        COMP170Pets[1].setGender("female"); // as needed
        COMP170Pets[1].setExcitementSound("meow");

        COMP170Pets[2] = new Pet(); // use default constructor, no additional data

        // And we can use a loop for various operations

        System.out.printf("\n\nArray of objects and enhanced loop demonstration\n");
        for (Pet p : COMP170Pets) { // use enhanced for-loop (fun!)
            String pName = p.getName();
            String pSpecies = p.getSpecies();
            System.out.printf("\n%s is a %s",pName,pSpecies);
        }
        System.out.printf("\n\n");

    } // method main
} // Class DemonstratePets
