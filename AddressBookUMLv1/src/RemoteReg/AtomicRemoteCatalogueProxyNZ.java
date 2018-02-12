package RemoteReg;

import java.util.Arrays;
import java.util.List;


public class AtomicRemoteCatalogueProxyNZ implements RemoteCatalogueProxy {

    private String host;
    private int port;
    public String getHost() {return host;}
    public int getPort() {return port;}

    public AtomicRemoteCatalogueProxyNZ(String host, int port) {

        this.host=host;
        this.port=port;
    }
    public List<String> getContacts() {return new CatalogueClientNZ(this).getCatalogueContacts();}
}
