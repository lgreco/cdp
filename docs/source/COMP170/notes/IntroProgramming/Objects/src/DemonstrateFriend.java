public class DemonstrateFriend {

    public static void main(String[] args) {

        Friend[] leoFriends = new Friend[4];

        leoFriends[0] = new Friend("Jean Luc","Picard");
        leoFriends[0].setPhone("5555551212");

        leoFriends[1] = new Friend("Geordi", "Laforge");
        leoFriends[1].setPhone("(773) 555-1212");

        leoFriends[2] = new Friend("Wiliam", "Riker");
        leoFriends[2].setPhone("+1 630 555 1212");


        leoFriends[3] = new Friend("deanna","troy");
        leoFriends[3].setPhone("001 312 555 1212");

        System.out.println("\nArea codes where my friends are (using enhanced for-loop):\n");

        for (Friend f:leoFriends) { // Enhanced for-loop
            String areaCode = f.getPhone().substring(0,3);
            String name = f.getFirstName();
            System.out.printf("%12s is in area code %3s\n",name,areaCode);
        }

        // Loop above same as:

        System.out.println("\nArea codes where my friends are (using plain for-loop):\n");

        for (int i=0; i < leoFriends.length; i++) {
            String areaCode = leoFriends[i].getPhone().substring(0,3);
            String name = leoFriends[i].getFirstName();
            System.out.printf("%12s is in area code %3s\n",name,areaCode);
        }
    }
}
