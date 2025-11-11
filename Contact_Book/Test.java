import javax.swing.JOptionPane;

public class Test {

    public static void main(String[] args) {
        // ! Main Address Book Instances or Object
        ContactBook myContactBook = new ContactBook();

        // ! Showing Options
        while (true) {
            String input = JOptionPane
                    .showInputDialog("1. Add\n2. Search\n3. Delete\n4. Check Total Contacts\n5. Exit");
            int operation = Integer.parseInt(input);

            // ! Handling UserInput
            switch (operation) {
                case 1:
                    myContactBook.addContact();
                    break;

                case 2:
                    String searchName = JOptionPane.showInputDialog("Enter Contact Name to Search");
                    myContactBook.searchContact(searchName);
                    break;

                case 3:
                    String deleteName = JOptionPane.showInputDialog("Enter Contact Name to Delete");
                    myContactBook.deleteContact(deleteName);
                    break;

                case 4:
                    myContactBook.checkTotalContacts();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Thanks for using JAVA Address Book");
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid Operation Please Enter Relative Operation");
                    break;

            }
        }
    }
}
