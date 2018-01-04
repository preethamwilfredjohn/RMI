import java.rmi.*;
import java.rmi.server.*;   
public class johnP2Server {
	   public static void main (String[] argv) 
	   {
		   try 
		   {
			   System.setSecurityManager(new RMISecurityManager());
			   
			   johnP2Service server = new johnP2Service();
			   // Creating RMI Registry and binding
			   Naming.rebind("rmi://localhost/AOSProject2", server);
			   System.out.println("Server is ready.");
		   	}
		   catch (Exception e) 
		   {
				   System.out.println("Server failed: " + e);
		   }
	}
}