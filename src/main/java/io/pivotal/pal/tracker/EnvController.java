package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private final String port;
    private final String memoryLimit;
    private final String CFInstanceIndex;
    private final String CFInstanceADDR;

    public EnvController(@Value("${port:NOT SET}") String port,
                         @Value("${memory.limit:NOT SET}") String memoryLimit,
                         @Value("${cf.instance.index:NOT SET}") String CFInstanceIndex,
                         @Value("${cf.instance.addr:NOT SET}") String CFInstanceADDR) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.CFInstanceIndex = CFInstanceIndex;
        this.CFInstanceADDR = CFInstanceADDR;
    }
    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", this.port);
        env.put("MEMORY_LIMIT", this.memoryLimit);
        env.put("CF_INSTANCE_INDEX", this.CFInstanceIndex);
        env.put("CF_INSTANCE_ADDR", this.CFInstanceADDR);

        return env;
    }
}
