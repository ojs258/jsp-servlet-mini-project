package jsp.servlet.api;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/")
public class RestConfig extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> servlet = new HashMap<>();
        servlet.put("jersey.config.server.provider.packages", "api");
        return servlet;
    }
}
