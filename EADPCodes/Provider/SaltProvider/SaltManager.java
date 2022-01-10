import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SaltManager {
 

    private static final Map<String, SaltProvider> providers = new ConcurrentHashMap<String, SaltProvider>();

    public static void registerProvider(String name, SaltProvider p) {
        providers.put(name, p);
    }
 
    public static Salt getSalt(String name) {
 
        SaltProvider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException(
                    "No SaltProvider registered with name:" + name);
        }
        return p.getSalt();
 
    }
}
