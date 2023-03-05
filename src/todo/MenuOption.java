package todo;

public enum MenuOption {
	EXIT(0, "Exit"),
	ADDTODO(1, "Add item"), 
	REMOVETODO(2, "Remove item");
	
	
	private int id;
	private String name;

	MenuOption(int id, String name) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
