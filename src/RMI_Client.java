import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RMI_Client {
	

	 
	public static void main(String[] args) {
		IRMI_Server remoteServer = null ;
		String incomigMessage = "";
		String outgoingMessage = "";
		String serverIp = null;
		int serverPort= 0;
		long startTime = 0; // = System.nanoTime();
		long endTime = 0;
	//	BasicModel model = new BasicModel();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Server IP and Server PortNumber");
		serverIp = scan.next();
		serverPort = scan.nextInt();
		
		Registry myReg;
		try {
			myReg = LocateRegistry.getRegistry  (serverIp, serverPort);
			remoteServer = (IRMI_Server) myReg.lookup("Bootstrap");
			String plyaerIp = InetAddress.getLocalHost().getHostName();
			remoteServer.connectionInfo(plyaerIp);
			while(true) {
				System.out.println("\nPlease select an option");
				System.out.println("Move");
				System.out.println("Status");
				System.out.println("Quit");
				System.out.println("PickUp");
			String requestType = scan.next();
			switch (requestType) {
			case "Move":
				//model.setRequestType("play");
				System.out.println("    Press 1) to move up, 2)to move down, 3)to move left, 4) to move right");
				String choice = scan.next();
				switch (choice) {
				case "1":
					outgoingMessage = "up";
					break;
				case "2":
					outgoingMessage = "down";
					break;
				case "3":
					outgoingMessage = "left";
					break;
				case "4":
					outgoingMessage = "right";
					break;
					
				default:
					System.out.println("Please enter a valid option");
					break;
				}
				if(outgoingMessage.equals("up")||outgoingMessage.equals("down")
						||outgoingMessage.equals("left")||outgoingMessage.equals("right")) {
				startTime = System.nanoTime();
				remoteServer.updateStateService(outgoingMessage);
				endTime = System.nanoTime();
				System.out.println("Time Taken in RMI to Update State is : "+(endTime-startTime)+" nanoseconds");
				}
				break;
			
			case "PickUp":
				System.out.println("    Press 1) to pick food, 2)to pick medicine");
				String object = scan.next();
				switch (object) {
				case "1":
					outgoingMessage ="food";
					break;
				case "2":
					outgoingMessage = "medicine";
					break;
				default:
					System.out.println("Please enter a valid option");
					break;
				}
				if(outgoingMessage.equals("food")||outgoingMessage.equals("medicine")) {
					startTime = System.nanoTime();
				remoteServer.pickUp(outgoingMessage);
				endTime = System.nanoTime();
				System.out.println("Time Taken in RMI to Pickup is : "+(endTime-startTime)+" nanoseconds");
				}
				break;
				
			case "Status":
				startTime = System.nanoTime();
				String res =remoteServer.returnState();
				endTime = System.nanoTime();
				System.out.println("Time Taken in RMI to get State is : "+(endTime-startTime)+" nanoseconds");
				System.out.println(res);
				break;	

			case "Quit":
				remoteServer.destructor();
				System.out.println("Exiting...");
				System.exit(0);
				break;	
				
			default:
				System.out.println("Please enter a valid option");
				break;
			}
			
		} 
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			
			
		}
	}

}
