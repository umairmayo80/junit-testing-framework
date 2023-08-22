package com.programming.techie;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// by default junit create separate instance of class for each test case function
// .per_class changes to singleton
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

    ContactManager contactManager;

    @BeforeAll
    public void setupAll(){
        System.out.println("It will run at the very first of the lifecycle.");
    }

    @BeforeEach
    public void setup(){
        //create a fresh contactManager for each test case
        contactManager = new ContactManager();
    }

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


    @AfterEach
    public void tearDown(){
        System.out.println("It will be executed after each test case");
    }

    @AfterAll
    public void tearDownAll(){
        contactManager = null; // clean up
        System.out.println("It will be executed at the end of test lifecycle, ususally for clean upp");
    }

}