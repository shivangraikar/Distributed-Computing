import java.io.*; import java.net.*;

public class DemoS
{

public static void main(String[] args)
{

try
{
ServerSocket ss = new ServerSocket(2000); Socket s = ss.accept();
DataInputStream dis = new
DataInputStream(s.getInputStream());
System.out.println("Server is waiting for the client..."); System.out.println("Message sent by the client is = " + (String)dis.readUTF());
ss.close();

}
catch(Exception e)
{

System.out.println(e);
}
}
 
}
