package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws ClassNotFoundException {

        Socket soc;
        String send, res;
        try {
            soc = new Socket("localhost", 5555);
            OutputStream os = soc.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            InputStream is = soc.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Resever: ");
                send = br.readLine();
                oos.writeObject(send);
                if ((res = (String) ois.readObject()) != null) {
                    System.out.println("Sender: " + res);
                }
            }
        } catch (IOException ex) {
        }

    }
}
