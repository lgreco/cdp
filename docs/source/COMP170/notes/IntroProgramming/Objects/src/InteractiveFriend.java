public class InteractiveFriend {

    private String name;

    public InteractiveFriend(String name) {
        this.name = name;
    }

    public void acceptGreeting(InteractiveFriend from) {
        System.out.printf("\n%s: %s just said hi to me! I'll say hi to %s too\n",name,from.name,from.name);
        sayHiTo(from);
    }

    public void sayHiTo(InteractiveFriend friend) {
        System.out.printf("\n%s: I just said hi to %s!\n",name,friend.name);
        friend.acceptGreeting(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        InteractiveFriend leo = new InteractiveFriend("Leo");
        InteractiveFriend tim = new InteractiveFriend("Tim");
        leo.sayHiTo(tim);
    }
}
