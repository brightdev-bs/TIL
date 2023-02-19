package til.logback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j(topic = "SQL_LOG1")
@RestController
public class QueryController1 {

    @GetMapping("query1")
    public String query1() {
        log.trace("[trace] trace mode");
        log.debug("[debug] debug mode");
        log.info("[info] info mode");
        log.warn("[warn] debug mode");
        log.error("[error] debug mode");
        return "query1";
    }
}
