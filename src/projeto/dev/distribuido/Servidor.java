package projeto.dev.distribuido;
import java.util.Scanner;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;

public class Servidor{
    int porta = 1234;
    Date d = new Date();
    public Servidor(){
        try{
            //escuta
            ServerSocket ss = new ServerSocket(porta);
            System.out.println("Servidor Iniciado");
            //canal de comunicação
            Socket s = ss.accept();
            System.out.println("Cliente do IP:" + s.getInetAddress().getHostAddress());
          
            Scanner entrada = new Scanner(s.getInputStream());
            
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }
            
            entrada.close();
            ss.close();
            
            OutputStream os = s.getOutputStream();
            os.write(d.toString().getBytes());
            os.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void main(String args[]){
        Servidor s = new Servidor();
    }
}
