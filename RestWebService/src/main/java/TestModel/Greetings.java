package TestModel;

public class Greetings {
	
	private final Long id;
	private final String context;
	public Greetings(Long id, String context) {
		this.id = id;
		this.context = context;
	}
	public Long getId() {
		return id;
	}
	public String getContext() {
		return context;
	} 
	
}
