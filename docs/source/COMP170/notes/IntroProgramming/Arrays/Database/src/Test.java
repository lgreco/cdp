public class Test {

    private int testInt;
    private char testChar;
    private boolean testBoolean;
    private int i;

    public Test(int i, char c, boolean b) {
        testInt = i;
        testBoolean = b;
        testChar = c;
    }

    public Test(int i) {
        this.testInt = i;
    }

    public Test(int i, boolean b) {
        this.testInt = i;
        this.testBoolean = b;
    }
}
