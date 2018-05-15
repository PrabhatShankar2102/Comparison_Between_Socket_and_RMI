import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;

public class RMI_Server_Impl extends UnicastRemoteObject implements IRMI_Server, Serializable{

	BasicModel model;
	protected RMI_Server_Impl() throws RemoteException {
		super();
		model = new BasicModel();
	}

	@Override
	public void updateStateService(String incomigMessage) {
		System.out.println("Request recived for Update");
		String choice = incomigMessage;
		
		switch (choice) {
		case "up":
				System.out.println("Moving up");
			model.setX(model.getX() +1);
			break;
			
		case "down":
			// Move down the board
			System.out.println("Moving down");
			model.setX(model.getX() -1);
			break;
		case "right":
			//Move right on board
			System.out.println("Moving right");
			model.setY(model.getY() +1);
			break;
			
		case "left":
			// Move left in the board
			System.out.println("Moving left");
			model.setY(model.getY() -1);
			break;
			
		default:
			
			break;
		}
		
	}

	@Override
	public String returnState() {
		System.out.println("Request recived for Status");
		int foodoccurrences = Collections.frequency(model.getList(), "food");
		int medoccurrences = Collections.frequency(model.getList(), "medicine");
		return "Your current location in board is ("+model.getX()+","+model.getY()+") \n You have "+foodoccurrences+" food and "+medoccurrences+" medicines";

	}

	@Override
	public void connectionInfo(String incomigMessage) {
		System.out.println("Connection Request received from "+incomigMessage);
		model.setPlayerIp(incomigMessage);
		System.out.println("Player from address "+model.getPlayerIp()+" is connected...");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pickUp(String incomigMessage) {
		System.out.println("Picking up "+incomigMessage);
		model.getList().add(incomigMessage);
		
	}

	@Override
	public void destructor() throws RemoteException {
		System.out.println("Destructing..");
		model = new BasicModel();
		//return "Player disconnecte;
		
		
	}

}
