package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        // 공동 로직1 시작
        log.info("start");
        String result1 = target.callA(); // 호출하는 메서드만 다름
        log.info("result={}", result1);
        // 공통 로직2 종료

        // 공동 로직2 시작
        log.info("start");
        String result2 = target.callB(); // 호출하는 메서드만 다름
        log.info("result={}", result2);
        // 공통 로직2 종료
    }

    @Test
    void reflection1() throws Exception {
        // 클래스 정보
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();

        // callA 메서드 정보
        Method methodCallA = classHello.getMethod("callA"); // callA의 메서드 정보를 얻음
        Object result1 = methodCallA.invoke(target); // target instance 에 있는 'methodCallA' 를 호출(invoke)한다.
        log.info("result1={}", result1);

        // callB 메서드 정보
        Method methodCallB = classHello.getMethod("callB"); // callB의 메서드 정보를 얻음
        Object result2 = methodCallB.invoke(target); // target instance 에 있는 'methodCallB' 를 호출(invoke)한다.
        log.info("result2={}", result2);
    }

    @Test
    void reflection2() throws Exception {
        Class classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCallA = classHello.getMethod("callA"); // callA의 메서드 정보를 얻음
        dynamicCall(methodCallA, target);

        Method methodCallB = classHello.getMethod("callB"); // callB의 메서드 정보를 얻음
        dynamicCall(methodCallB, target);
    }

    // callA 든, callB 든 상관없이 target에 넣고 실행 가능
    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        Object result = method.invoke(target); // 재밌는게 Target이 Method를 호출함
        log.info("result={}", result);
    }

    @Slf4j
    static class Hello {

        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}
