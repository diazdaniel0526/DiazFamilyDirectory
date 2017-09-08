import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class ContactInfoRequest {
    static Contact [] contacts = new Contact[3];

    public static void createContacts() throws Exception {
        for(int i = 0; i < 3; i++) {
            Scanner systemInScanner = new Scanner(System.in);
            System.out.printf("Enter contact's name:\n");
            String contactName = systemInScanner.nextLine();
            System.out.printf("Enter %s's last name:\n", contactName);
            String contactLastName = systemInScanner.nextLine();
            System.out.printf("Enter %s's phone:\n", contactName);
            String contactPhone = systemInScanner.nextLine();
            System.out.printf("Enter %s's email address:\n", contactName);
            String contactEmailAddress = systemInScanner.nextLine();
            System.out.printf("Enter %s's physical address:\n", contactName);
            String contactAddress = systemInScanner.nextLine();
            System.out.printf("Enter %s's date of birth:\n", contactName);
            String contactDbo = systemInScanner.nextLine();

            Contact newContact = new Contact();
            newContact.name = contactName;
            newContact.lastName = contactLastName;
            newContact.phoneNum = contactPhone;
            newContact.emailAdd = contactEmailAddress;
            newContact.address = contactAddress;
            newContact.dob = contactDbo;
            contacts[i] = newContact;
        }
    }

    public static void saveContacts() throws Exception {
        File contactsFile = new File("contacts.data");
        PrintWriter contactsWriter = new PrintWriter(contactsFile);
        for(int i = 0; i < 3; i++){
            Contact newContactAdded = contacts[i];
            contactsWriter.printf("%s %s %s %s %s %s\n",
                                    newContactAdded.name,
                                    newContactAdded.lastName,
                                    newContactAdded.phoneNum,
                                    newContactAdded.emailAdd,
                                    newContactAdded.address,
                                    newContactAdded.dob);
            contactsWriter.flush();
        }
    }
    public static void main(String[] args) throws Exception {
        createContacts();
        saveContacts();
    }
}
