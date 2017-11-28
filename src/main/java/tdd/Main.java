package tdd;

/**
 * @author Evgeny Borisov
 * @since 3.2
 */
public class Main {
    public static void main(String[] args) {
        TestClass testObject = new TestClass();
        TestRunner testRunner = new TestRunner();
        testRunner.runAllTestsMethods(testObject);
    }
}
