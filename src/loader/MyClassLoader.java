package loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

class MyClassLoader extends ClassLoader {

    private HashMap<String, String> mappings;

    MyClassLoader(HashMap<String, String> mappings) {
        this.mappings = mappings;
    }

    @Override
    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            if (!mappings.containsKey(name)) {
                System.out.println("Parent ClassLoader loads Class (" + name + ") or returns it, if it has been loaded earlier");
                return super.findSystemClass(name);
            }
            System.out.println("MyClassLoader loads Class (" + name + ")");
            String fileName = mappings.get(name);
            FileInputStream fin = new FileInputStream(fileName);
            byte[] bytes = new byte[(int) (new File(fileName).length())];
            fin.read(bytes);
            fin.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(e.getMessage(), e);
        }
    }
}
