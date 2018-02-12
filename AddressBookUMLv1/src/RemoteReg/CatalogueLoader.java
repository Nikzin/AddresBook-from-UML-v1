package RemoteReg;

import Registry.Registry;

public class CatalogueLoader {
    private RemoteRegistry registry;
    private RemoteCatalogueFactory factory;

    public CatalogueLoader(){}

    public CatalogueLoader(RemoteRegistry remoteregistry){
        this.registry = remoteregistry;
    }

    public void run() {
        registry = new RemoteRegistry();
        factory = new RemoteCatalogueFactory(61616);//Vi osäkra på om port-nr ska skrivas här...
    }
}
