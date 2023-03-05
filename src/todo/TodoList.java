package todo;

import java.util.ArrayList;
import java.util.Scanner;


public class TodoList {
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> todos = new ArrayList<>();
	String stop = "Done";

	public void menu() {
		
		
		boolean termination = false;
		while(!termination) {
			System.out.println();
			System.out.println("Please select menu number.");
			printMenu();
			int selection = getNextIntFromUser();
			if(selection == MenuOption.EXIT.getId()) {
				exit();
				termination = true;
			} else if(selection == MenuOption.ADDTODO.getId()) {
				enterTodo();
			} else if(selection == MenuOption.REMOVETODO.getId()) {
				removeTodo();
			} 
		}
		
		
	}
	
	public void printMenu() {
		System.out.println("--Menu options--");
		for(MenuOption option : MenuOption.values()) {
			System.out.println(String.format("Id %d - %s", option.getId(), option.getName()));
		}
		
	}

	public void enterTodo() {
		System.out.println("Enter new todo: ");
	    System.out.println("When you finished, enter the word: " + stop);
	    scanner.nextLine(); // clear input buffer
	    while (scanner.hasNextLine()) {
	        String input = scanner.nextLine();
	        if (input.equalsIgnoreCase(stop)) {
	        	System.out.println("Your list of Todos:");
			    for (int i = 0; i < todos.size(); i++) {
			        System.out.println(i + " - " + todos.get(i));
			    }
	            return;
	        }
	            System.out.println(input + " has been added to the list");
	            todos.add(input);
	            System.out.println();
	            System.out.println("Enter next todo:");
	       
	    }
	    
	}

	public void removeTodo() {
		System.out.println("Remove any todo? Yes/No");
		String input = scanner.next();
		String yeString = "Yes";
		String noString = "No";

		if (!(input.equalsIgnoreCase(noString) || input.equalsIgnoreCase(yeString))) {
			System.out.println("Yes/No only.");
			input = scanner.next();

		}

		if (input.equalsIgnoreCase(yeString)) {
			System.out.println("Enter the index you like to remove or done to exit.");
			for (int i = 0; i < todos.size(); i++) {
				System.out.println(i + " - " + todos.get(i));
			}
			while (scanner.hasNext()) {
				input = scanner.next();
				if (input.equalsIgnoreCase(stop)) {
					System.out.println("Reminding, this is the remains of the Todos List:");
					for (int i = 0; i < todos.size(); i++) {
						System.out.println("Id: " + i + " - " + todos.get(i));
					}
					break;
				} else if (input.matches("\\d+")) {
					int selection = Integer.parseInt(input);
					if (selection >= 0 && selection < todos.size()) {
						todos.remove(selection);
						if (todos.size() == 0) {
							System.out.println("No todo left.");
							break;
						}
						System.out.println("Remaining Todos List:");
						for (int i = 0; i < todos.size(); i++) {
							System.out.println("Id: " + i + " - " + todos.get(i));
						}
						System.out.println("Enter the index you'd like to remove or done to exit:");
					} else {
						System.out.println(
								"Invalid selection. Please enter a number between 0 and " + (todos.size() - 1) + ".");
					}
				} else {
					System.out.println("Invalid input. Please enter a number or 'done' to exit.");
//				        input = scanner.next();
				}
			}
		}

		if (input.equalsIgnoreCase(noString)) {
			System.out.println(String.format("You choose No to remove item. You have %d of todos left.", todos.size()));
			for (int i = 0; i < todos.size(); i++) {
				System.out.println(i + " - " + todos.get(i));
			}

		}

//		System.out.println("Goodbye.");

	}
	
    private int getNextIntFromUser() {
    	while (!scanner.hasNextInt()) {
			 System.out.println("Wrong type of input. Enter interger only.");
			 scanner.next();
		}
		return scanner.nextInt();
    }
    
    private void exit() {
    	System.out.println("GoodBye!");
		scanner.close();
	}


	public static void main(String[] args) {
		TodoList todo = new TodoList();
		todo.menu();
	}
}
