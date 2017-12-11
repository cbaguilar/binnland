package christian.binnland.items;

import christian.binnland.Response;

public class TrigBook extends Item {

	
	public TrigBook(){
		this.grabable=true;
		this.DAMAGE = 3;
	}
	
	public String getName() {
		
		return "Textbook";
	};
	
	public Response read() {
		return new Response("You read the book.\nYou now know trigonometry and how to ride a bike",1);
	}
	
}
