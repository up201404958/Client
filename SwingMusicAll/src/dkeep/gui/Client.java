package dkeep.gui;

public class Client {

	protected String user;
	protected String password;
	
	public void setStrings(String user,String pass) {
		this.user=user;
		this.password=pass;
	}
	
	public void printClient(){
		System.out.println("USERNAME:"+this.user+" PASSWORD: "+this.password);
	}
	public void sendToServer(){
		//write Strings to file 
		//send thourhg socket 
		//wait response 
	}
	public void checkServerResponse() {
		
		
	}

}