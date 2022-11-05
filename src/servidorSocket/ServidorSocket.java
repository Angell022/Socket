package servidorSocket;

import java.io.*;
import java.net.*;

public class ServidorSocket {
	static final int PUERTO=5000;
	   static ServerSocket sc;
	   static Socket so;
	   static DataOutputStream salidaCliente;
	   static String mensajeRecibido;
	    
	    public static void main(String[] args) {
	        iniciarServidor();
	    }
	    
	    public static void iniciarServidor(){
	    try{
	    sc= new ServerSocket(PUERTO);
	    so = new Socket();
	        System.out.println("Esperando conexion...");

	            so= sc.accept();
	            System.out.println("Un cliente se ha conectado");
	            salidaCliente= new DataOutputStream(so.getOutputStream());
	            //salidaCliente.writeUTF("Peticion recibida y aceptada ");
	            salidaCliente.writeInt(3);
	            BufferedReader entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));

	            while((mensajeRecibido=entrada.readLine())!=null){
	            System.out.println("El Mensaje Recibido Fue: "+mensajeRecibido);
	                   String vocales = "aAeEiIoOuU";
	    		String consonantes = "bBcCdDfFgGhHjJkKlLmMnNpPqQrRsStTvVwWxXyYzZ";
	    		int cantidadVocales = 0;
	    		int cantidadConsonantes = 0;
	    		for (int i = 0; i < mensajeRecibido.length(); i++) {
	    			char letter =  mensajeRecibido.charAt(i);
	    			if(vocales.contains(letter+"")){
	    				cantidadVocales++;
	    			}
	    		}
	    		for (int i = 0; i < mensajeRecibido.length(); i++) {
	    			char letter =  mensajeRecibido.charAt(i);
	    			if(consonantes.contains(letter+"")){
	    				cantidadConsonantes++;
	    			}
	    		}
	                
	                if(cantidadVocales<cantidadConsonantes)
	                salidaCliente.writeBoolean(false);
	              
	                else 
	                salidaCliente.writeBoolean(true);
	                salidaCliente.writeInt(cantidadVocales);
	                salidaCliente.writeInt(cantidadConsonantes);
	            }
	            System.out.println("Fin de la conexion");
	            sc.close();
	        }
	            catch (Exception e){
	                System.out.println("Error: "+e.getMessage());
	            }
	        }
}
