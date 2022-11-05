package clienteSocket;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteSocket {
	static final String HOST = "localhost";

	   static final int PUERTO=5000;
	   static Socket sc;
	   static DataOutputStream mensaje;

	    public static void main(String[] args) {
	        System.out.println("Iniciando cliente\n");
	        iniciarCliente();
	    }

	public static void iniciarCliente(){
	     try{ 
	sc = new Socket(HOST,PUERTO);

	DataInputStream entrada = new DataInputStream(sc.getInputStream());
	int mensajeServidor=entrada.readInt();
	System.out.println("Confirmacion recibida: "+mensajeServidor);

	   System.out.println("Presione <enter> para enviar mensaje");
	   Scanner teclado = new Scanner(System.in);
	teclado.nextLine();

	mensaje = new DataOutputStream(sc.getOutputStream());

	System.out.println("Enviando mensaje: " );
	      mensaje.writeUTF("catarinaa \n"); 
	      
	    boolean tam_vocales=entrada.readBoolean();
	    
	    if(tam_vocales==true)
	        System.out.println("\tEl numero de vocales es mayor que las consonantes: "+tam_vocales);	    
	   else
	         System.out.println("\tEl numero de vocales es menor que las consonantes: "+tam_vocales);
	          
	  int totalVocal=entrada.readInt();
	  int totalConsonante=entrada.readInt();
	 System.out.println("\tEl total de vocales son: "+totalVocal + "\n \tEl total de consonantes son: "+totalConsonante);  
	 
	//TimeUnit.SECONDS.sleep(3);
	sc.close();//
	teclado.close();
	//}
	}
	catch (Exception e){
	System.out.println("Error"+e.getMessage());
	}
	}
}
