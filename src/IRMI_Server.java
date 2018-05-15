import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMI_Server extends Remote {

	public void updateStateService(String incomigMessage) throws RemoteException;
	public String returnState() throws RemoteException;
	void connectionInfo(String incomigMessage)  throws RemoteException;
	void pickUp(String incomigMessage) throws RemoteException;
	void destructor() throws RemoteException ;
}
