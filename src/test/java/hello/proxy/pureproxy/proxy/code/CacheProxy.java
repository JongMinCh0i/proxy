package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

    private Subject target; // 생성자로 받는다.
    private String cacheValue; // 저장 후 바로 반환

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if (cacheValue == null) {
            cacheValue = target.operation(); // realSubject 호출
        }
        return cacheValue;
    }
}
