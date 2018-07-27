package loader;

public class TestClass implements TestInterface {

    public static String publicField = "Successful test of getting publicField";
    private String message = "Successful test of invoking getPrivateField method";

    static {
        System.out.println("Static block of initialization was loaded");
    }

    public TestClass() {
        System.out.println("Constructor was used");
    }

    public String getPrivateField() {
        return message;
    }

    @Override
    public void interfaceMethod() {
        System.out.println("InterfaceMethod is used!");
    }
}
