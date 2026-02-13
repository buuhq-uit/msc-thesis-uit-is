package dpl.be.process.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("sampleServiceTask")
@Slf4j
public class SampleServiceTask {
    public void hello(String lang) {
        //flowable bpmn:${sampleServiceTask.hello(lang)}
        log.info("Language = {} - Hello from Flowable Service Task expression call!", lang);
    }
    //bonjour
    public void bonjour(String lang) {
        //flowable bpmn:${sampleServiceTask.bonjour(lang)}
        log.info("Language = {} - Bonjour from Flowable Service Task expression call!", lang);
    }
}
