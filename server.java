package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) throws ClassNotFoundException {
        String send, res;
        try {
            ServerSocket s = new ServerSocket(5555);
            //  System.out.println("im here");
            Socket soc = s.accept();
            OutputStream os = soc.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            InputStream is = soc.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Sender: ");
            send = br.readLine();
            oos.writeObject(send);
            while (true) {
                if ((res = (String) ois.readObject()) != null) {
                    System.out.println("\nResever: " + res);
                }
                System.out.print("Sender: ");
                send = br.readLine();
                oos.writeObject(send);
                //      System.out.println("Wait .....");

            }

        } catch (IOException ex) {
        }
    }

}
