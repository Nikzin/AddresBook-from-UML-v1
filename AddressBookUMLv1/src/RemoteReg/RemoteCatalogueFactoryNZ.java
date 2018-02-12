package RemoteReg;



public class RemoteCatalogueFactoryNZ {

    private int defaultPort;
    private CatalogueLoaderNZ catalogueLoader;

    public RemoteCatalogueFactoryNZ(CatalogueLoaderNZ catalogueLoader) {
        this.catalogueLoader = catalogueLoader;
        RemoteCatalogueFactory(61616);
        create("localhost", defaultPort);
        create("172.20.200.157", defaultPort);
    }

    public void RemoteCatalogueFactory(int port) {
        defaultPort=port;
    }

    public void create(String host, int port) {
        AtomicRemoteCatalogueProxyNZ atomicRemoteCatalogueProxy = new AtomicRemoteCatalogueProxyNZ(host, port);
        catalogueLoader.loadRemoteContacts(atomicRemoteCatalogueProxy.getContacts());
    }

}
