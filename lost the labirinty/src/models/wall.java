package models;

public class wall implements Container{
	private String type = "wall";
	
	public wall() {}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public String msg() {
		// TODO Auto-generated method stub
		return "ohh! uma parede aqui.";
	}

}
