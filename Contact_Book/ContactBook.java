package Contact_Book;

import java.util.*;
import javax.swing.JOptionPane;

public class ContactBook {
    // ! Main variable of Addressbook in which person object will be added
    ArrayList contacts;

    // ! Consturcture
    public ContactBook() {
        this.contacts = new ArrayList();
    }

    // ! AddContact Method
    public void addContact() {
        String contactName = JOptionPane.showInputDialog("Enter Contact Name");
        String contactNumber = JOptionPane.showInputDialog("Enter Contact Number");
        String contactAddress = JOptionPane.showInputDialog("Enter Contact Address");
        Person p = new Person(contactName, contactNumber, contactAddress);
        contacts.add(p);
        System.out.println("Contact " + p.getName() + " added successfully");
    }

    // ! SearchContact Method
    public void searchContact(String n) {

        for (int i = 0; i < contacts.size(); i++) {

            Person p = (Person) contacts.get(i);

            if (n.equals(p.getName())) {
                System.out.println("Contact is Present");
                p.printPersonInfo();
                p.printPersonInfoUI();
            }

        }
    }

    // ! DeleteContact Method
    public void deleteContact(String n) {

        for (int i = 0; i < contacts.size(); i++) {

            Person p = (Person) contacts.get(i);

            if (n.equals(p.getName())) {
                contacts.remove(i);
                JOptionPane.showMessageDialog(null, p.getName() + " Deleted");
            }

        }

    }

    // ! CheckTotalContacts Method
    public void checkTotalContacts() {
        JOptionPane.showMessageDialog(null,
                "You have " + contacts.size() + " contacts in JAVA Address Book");
    }
}