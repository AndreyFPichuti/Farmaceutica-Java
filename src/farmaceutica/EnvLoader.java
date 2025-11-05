package farmaceutica;

import java.io.*;
import java.util.*;

public class EnvLoader {
    private static final Map<String, String> env = new HashMap<>();
    
    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(".env"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.startsWith("#") && line.contains("=")) {
                String[] parts = line.split("=", 2);
                env.put(parts[0].trim(), parts[1].trim());
            }
        }
        } catch (IOException e) {
            System.err.println("Não foi possível carregar o arquivo .env!");
        }
    }
    
    public static String get(String key) {
        return env.get(key);
    }
}