package RemoteReg;

public class RemoteCatalogueFactory {

    private int defaultPort;
    private  AtomicRemoteCatalogueProxy atomicRemoteCatalogueProxy;

    RemoteCatalogueFactory(int port){
        this.defaultPort = port;
    }

    public RemoteCatalogueProxy create(String host){
       atomicRemoteCatalogueProxy = new AtomicRemoteCatalogueProxy(host,defaultPort);
       return atomicRemoteCatalogueProxy;
    }


}
