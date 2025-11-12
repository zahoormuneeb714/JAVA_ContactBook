package Contact_Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.JOptionPane;

public class ContactBook {
    // ! Main variable of Addressbook in which person object will be added
    ArrayList contacts;

    // ! Consturcture
    public ContactBook() {
        this.contacts = new ArrayList();
        this.loadContacts();
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

    // ! ListTotalContacts Method
    public void listTotalContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            Person p = (Person) contacts.get(i);
            System.out.println(
                    (i + 1) + " [NAME] " + p.getName() + " [NUMBER] " + p.getNumber() + " [ADDRESS] " + p.getAddress());
        }
    }

    // ! LoadContacts Methods
    public void loadContacts() {
        try {
            FileReader fr = new FileReader("contacts.txt");
            BufferedReader br = new BufferedReader(fr);
            String entry = br.readLine();
            while (entry != null) {
                String tokens[] = entry.split(",");
                // breaks or splits the string form provided regex and return arry of tokens
                // words
                Person p = new Person(tokens[0], tokens[1], tokens[2]);
                // adding the p to ArrayList variable
                this.contacts.add(p);
                // reading new line after reading one line and adding object to array list
                entry = br.readLine();
            }
            fr.close();
            br.close();

        } catch (Exception e) {
            System.out.println("Exception in ContactBook::loadContacts: " + e);
        }

    }

    // ! SaveContacts Method
    public void saveContacts() {
        try {
            FileWriter fw = new FileWriter("contacts.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < contacts.size(); i++) {
                Person p = (Person) contacts.get(i);
                String line = p.getName() + "," + p.getNumber() + "," + p.getAddress();
                pw.println(line);
            }

            pw.flush();
            fw.close();
            pw.close();

        } catch (Exception e) {
            System.out.println("Exception in the ContactBook::saveContacts " + e);
        }
    }
}
