package loader;

import java.util.HashMap;

public class LoaderDemo {

    public static void main(String[] args) throws Exception {
        HashMap<String, String> mappings = new HashMap<>();
        mappings.put("loader.TestClass", "D:\\Учеба Java\\probation\\out\\production\\probation\\loader\\TestClass.class");
        MyClassLoader myClassLoader = new MyClassLoader(mappings);
        Class<?> testClass = myClassLoader.loadClass("loader.TestClass");
        System.out.println("Just for testing: TestClass was loaded by (testClass.getClassLoader()) " + testClass.getClassLoader());
        System.out.println("Begin object creation");
        TestInterface testObject = (TestInterface) testClass.newInstance();
        testObject.interfaceMethod();
        System.out.println("TestClass object was created");
        System.out.println("Invoke: getPrivateField - " + testClass.getMethod("getPrivateField").invoke(testObject));
        System.out.println("Get: publicField - " + testClass.getField("publicField").get(testObject));
    }
}
