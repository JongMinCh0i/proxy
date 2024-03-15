package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

// Component 의 구현체
@Slf4j
public class RealComponent implements Component {

    @Override
    public String operation() {
        log.info("RealComponent 실행");
        return "data";
    }
}
