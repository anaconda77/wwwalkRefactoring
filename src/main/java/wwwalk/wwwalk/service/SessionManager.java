package wwwalk.wwwalk.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SessionManager {

    private Map<String, String> sessionManager = new HashMap<>();

    public String getId(String uuid) {
        return sessionManager.get(uuid);
    }

    public void putId(String uuid, String id) {
        sessionManager.put(uuid, id);
    }

}
