package farmaceutica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EnvLoader {

    private static final Map<String, String> env = new HashMap<>();

    static {
        try {
            // Lê o arquivo .env a partir do classpath
            InputStream input = EnvLoader.class.getClassLoader().getResourceAsStream(".env");

            if (input == null) {
                System.err.println("Arquivo .env não encontrado no classpath!");
                
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    if (!line.startsWith("#") && line.contains("=")) {
                        String[] parts = line.split("=", 2);
                        env.put(parts[0].trim(), parts[1].trim());
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao carregar .env: " + e.getMessage());
        }
    }

    public static String get(String key) {
        return env.get(key);
    }
}
