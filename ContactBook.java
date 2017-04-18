
import java.io.*;
import java.util.ArrayList;

public class ContactBook {
    private ArrayList<Contact> contacts;

    public ContactBook(){
        this.unserializeContacts();
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(String name, String lastname, String phoneNumber){
        Contact contact = new Contact();

        contact.setName(name);
        contact.setLastname(lastname);
        contact.setPhoneNumber(phoneNumber);

        this.contacts.add(contact);

        serializeContacts();
    }

    public void modifyContact(int contactID, String name, String lastname, String phoneNumber){
        for(int i = 0; i < this.contacts.size(); i++){
            if(i == contactID){
                this.contacts.get(i).setName(name);
                this.contacts.get(i).setLastname(lastname);
                this.contacts.get(i).setPhoneNumber(phoneNumber);
            }
        }

        serializeContacts();
    }

    public void deleteContact(int contactID){
        for(int i = 0; i < this.contacts.size(); i++){
            if(i == contactID){
                this.contacts.remove(contactID);
            }
        }

        serializeContacts();
    }

    private void serializeContacts(){
        try {
            FileOutputStream  fileOutputStream = new FileOutputStream("contacts/contacts.bat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(this.contacts);
            objectOutputStream.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private void unserializeContacts(){
        try {
            FileInputStream fileInputStream = new FileInputStream("contacts/contacts.bat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            this.contacts = (ArrayList<Contact>) objectInputStream.readObject();

            objectInputStream.close();
        } catch(FileNotFoundException e){
            this.contacts = new ArrayList<>();
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
