package com.example.contactsapp;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ContactsAppController {
    private ObservableList<Contacts> contacts = FXCollections.observableArrayList();
    private Contacts contactSelected;

    @FXML
    private ListView<Contacts> ContactsListView;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneNumberTextField;

    public void initialize(){
        contacts.add(new Contacts("Speedwagon","Foundation","speedwagon@gmail.com","+996(102) 201 202"));
        contacts.add(new Contacts("idk","idkov","idk.idkov_2026@ucentralasia.org","+996(304) 111 222"));
        contacts.add(new Contacts("thermos","brandnew","brandnewthermos@mail.ru","+996(405) 333 444"));
        contacts.add(new Contacts("Bang Chan","Christopher","brangchan97@smthmail.kr","+996(506) 555 666"));

        ContactsListView.setItems(contacts);
        ContactsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contacts>() {
            @Override
            public void changed(ObservableValue<? extends Contacts> arg0, Contacts oldValue, Contacts newValue) {
                contactSelected = newValue;
                firstNameTextField.setText(newValue.getFirstName());
                lastNameTextField.setText(newValue.getLastName());
                emailTextField.setText(newValue.getEmail());
                phoneNumberTextField.setText(newValue.getPhoneNumber());
            }
        });
    }

    public boolean validationFailed() {
        return (firstNameTextField.getText().trim().equals("") ||
                lastNameTextField.getText().trim().equals("") ||
                emailTextField.getText().trim().equals("") ||
                phoneNumberTextField.getText().trim().equals(""));
    }
    @FXML
    void addButtonPressed(ActionEvent event) {
        try{
            if (validationFailed()){
                throw new NumberFormatException();
            }
            else{
                Contacts obj1 = new Contacts();
                obj1.setFirstName(firstNameTextField.getText());
                obj1.setLastName(lastNameTextField.getText());
                obj1.setEmail(emailTextField.getText());
                obj1.setPhoneNumber(phoneNumberTextField.getText());
                contacts.add(obj1);
            }
        } catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }

    }

    @FXML
    void deleteButtonPressed(ActionEvent event) {
        try {
            contacts.remove(contactSelected);
        }
        catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }
    }

    @FXML
    void updateButtonPressed(ActionEvent event) {
        try{
            if (validationFailed()){
                throw new NumberFormatException();
            }
            else{
                Contacts obj1 = new Contacts();
                contactSelected.setFirstName(firstNameTextField.getText());
                contactSelected.setLastName(lastNameTextField.getText());
                contactSelected.setEmail(emailTextField.getText());
                contactSelected.setPhoneNumber(phoneNumberTextField.getText());

            }
        } catch (Exception ex){
            firstNameTextField.setText("");
            lastNameTextField.setText("");
            emailTextField.setText("");
            phoneNumberTextField.setText("");
            firstNameTextField.requestFocus();
        }
    }

}