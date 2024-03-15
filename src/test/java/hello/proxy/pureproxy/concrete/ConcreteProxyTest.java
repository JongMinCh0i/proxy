package hello.proxy.pureproxy.concrete;

import hello.proxy.pureproxy.concrete.code.ConcreteClient;
import hello.proxy.pureproxy.concrete.code.ConcreteLogic;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteClient concreteClient = new ConcreteClient(new ConcreteLogic());
        concreteClient.execute();
    }
}
