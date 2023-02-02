package til.logback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo() {
        log.trace("[TRACE] trace mode");
        log.debug("[DEBUG] debug mode");
        log.info("[info] info mode");
        log.warn("[DEBUG] debug mode");
        log.error("[DEBUG] debug mode");
        return "demo";
    }
}
