package com.programming.techie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {

    @Test
    public void shouldCreateContact() {
        ContactManager contactManager = new ContactManager();
        contactManager.addContact("john", "Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
//      assertion.assertEquals compares the values and assert if not equal
        Assertions.assertEquals(1,contactManager.getAllContacts().size());
    }


    @Test
    @DisplayName("Should not create contanct when first name is null")
    public void createContactWithFirstNameIsNull(){
        ContactManager contactManager = new ContactManager();


//       it expects that A RuntimeException.class will be thrown, if not thrown the test will fail
        Assertions.assertThrows(RuntimeException.class, ()->{
            contactManager.addContact("", "Doe", "0123456789");
        });
    }

}