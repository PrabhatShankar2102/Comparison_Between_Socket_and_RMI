import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BasicModel implements Serializable {

	private int x ;
	private int y ;
	private String choice ;
	private String requestType ;
	private String playerIp; 


	public BasicModel() {
		x =0;
		y =0;
		choice = null ;
		requestType = null;
		playerIp= null;
		list = new ArrayList<String>();
	}

	List<String> list;
	
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	public String getPlayerIp() {
		return playerIp;
	}

	public void setPlayerIp(String playerIp) {
		this.playerIp = playerIp;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

}
