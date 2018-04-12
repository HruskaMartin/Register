package register;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User interface of the application.
 */
public class ConsoleUI {
	/** register.Register of persons. */
	private Register register;

	/**
	 * In JDK 6 use Console class instead.
	 * 
	 * @see readLine()
	 */
	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Menu options.
	 */
	private enum Option {
		PRINT, ADD, UPDATE, REMOVE, FIND, EXIT
	};

	public ConsoleUI(Register register) {
		this.register = register;
	}

	public void run() {
		while (true) {
			switch (showMenu()) {
			case PRINT:
				printRegister();
				break;
			case ADD:
				addToRegister();
				break;
			case UPDATE:
				updateRegister();
				break;
			case REMOVE:
				removeFromRegister();
				break;
			case FIND:
				findInRegister();
				break;
			case EXIT:
				return;
			}
		}
	}

	private String readLine() {
		// In JDK 6.0 and above Console class can be used
		// return System.console().readLine();

		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	// TODO: Implement the method printRegister
	private void printRegister() {

		for (int i = 0; i < register.getCount(); i++) {
			System.out.println(i + 1 + ". " + register.getPerson(i).getName() + register.getPerson(i).getPhoneNumber());
		}
	}

	private void addToRegister() {
		System.out.println("Enter Name: ");
		String name = readLine();
		System.out.println("Enter Phone Number: ");
		String phoneNumber = readLine();
		
		/*
		for (int i = 0; i < register.getCount(); i++) {
			if (register.getPerson(i).getName().equals(name)) {
				if (register.getPerson(i).getPhoneNumber().equals(phoneNumber)) {
					System.out.println("V registri sa takato osoba uz nachadza");
					return;
				}
			} 
		}
		register.addPerson(new Person(name, phoneNumber));
		*/
	}

	// TODO: Implement the method updateRegister
	private void updateRegister() {
		Person person = register.getPerson(0);
		person.setName("jozo luther" + " ");
		person.setPhoneNumber("0908951362");
	}

	// TODO: Implement the method findInRegister
	private void findInRegister() {
		System.out.println("Vloz meno");
		String name = readLine();
		register.findPersonByName(name);
		System.out.println("Vloz cislo");
		String phoneNumber = readLine();
		register.findPersonByPhoneNumber(phoneNumber);
		
	}

	private void removeFromRegister() {
		System.out.println("Enter index: ");
		int index = Integer.parseInt(readLine());
		Person person = register.getPerson(index - 1);
		register.removePerson(person);
	}
	


}
