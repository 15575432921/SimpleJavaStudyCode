package day07;

/*
接口的应用：代理模式
 */
public class ProxyTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface NetWork {
    public void browse();
}

//被代理类
class Server implements NetWork {

    @Override
    public void browse() {
        System.out.println("server browse");
    }
}

class ProxyServer implements NetWork {
    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("check");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}