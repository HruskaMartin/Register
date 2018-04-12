package register;

/**
 * Created by jaro on 3.2.2014.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Register register = new Register(20);

        register.addPerson(new Person("Janko Hrasko", "0900123456"));
        register.addPerson(new Person("Janko Hrusko", "0900123789"));
        register.addPerson(new Person("Maros Hrach1", "0900123789"));
        
        
        ConsoleUI ui = new ConsoleUI(register);
        ui.run();
        
        Person person = new Person("as", "0218");
        person.isValidPhoneNumber("0945987463");
    }
}
