package RemoteReg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CatalogueClient {

    private String host;
    private int port;

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    CatalogueClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    public void connect() {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            String msg = "Servern går inte att nå";
            System.out.println(msg);
        }
    }

    public void sendRequest(String getAll) {
        try {
            writer = new PrintWriter(socket.getOutputStream());
            writer.println(getAll);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Kunde skriva in texten i filen...");
        }
    }

    public String waitForResponse() {

        String fileContentStr = "";

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            for (String line = reader.readLine(); line != null; reader.readLine()) {
                String record = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((record = reader.readLine()) != null) {//Nikolay tycker det ska stå !=""
                    stringBuilder.append(record + "\n");
                }
                fileContentStr = stringBuilder.toString();
                writer.println("exit");
                writer.flush();
                socket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContentStr;
    }

    public void disconnect(String exit){
        try {
            writer = new PrintWriter(socket.getOutputStream());
            writer.println(exit);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Kunde inte disconnecta..");
        }
    }
}





