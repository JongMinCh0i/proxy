package hello.proxy.pureproxy.concrete;

import hello.proxy.pureproxy.concrete.code.ConcreteClient;
import hello.proxy.pureproxy.concrete.code.ConcreteLogic;
import hello.proxy.pureproxy.concrete.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteClient concreteClient = new ConcreteClient(new ConcreteLogic());
        concreteClient.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
