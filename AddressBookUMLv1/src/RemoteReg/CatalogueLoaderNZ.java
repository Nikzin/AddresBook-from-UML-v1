package RemoteReg;

import java.util.List;


public class CatalogueLoaderNZ  {

    private RemoteRegistry remoteRegistry;

    public CatalogueLoaderNZ(RemoteRegistry remoteRegistry) {
        this.remoteRegistry = remoteRegistry;
    }

  public void runLoader() {

        /*new Thread(() -> {
            new RemoteCatalogueFactoryNZ(this);
        }).start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                new RemoteCatalogueFactoryNZ(CatalogueLoaderNZ.this);
            }
        }).start();
    }


    public void loadRemoteContacts(List<String> remoteContacts) {
        String[] words;
        for (String line : remoteContacts) {
            try {
                words = line.split(" ");
                remoteRegistry.add(words[0], words[1], words[2], words[3]);
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }
}
