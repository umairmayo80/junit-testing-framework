package com.programming.techie;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        this.contactManager = new ContactManager();
    }

    @Test
    public void shouldCreateContact() {
        this.contactManager.addContact("john", "Doe", "0123456789");
        Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
//      assertion.assertEquals compares the values and assert if not equal
        Assertions.assertEquals(1,contactManager.getAllContacts().size());
    }


    @Test
    @DisplayName("Should not create contanct when first name is null")
    public void createContactWithFirstNameIsNull(){
//       it expects that A RuntimeException.class will be thrown, if not thrown the test will fail
        Assertions.assertThrows(RuntimeException.class, ()->{
            this.contactManager.addContact("", "Doe", "0123456789");
        });
    }


    //    @MethodSource("functionname") // takes the return value of method and then injects the values in test case
    @DisplayName("Should not create contact with invalid data")
    @ParameterizedTest
    @ValueSource(strings = {""," "})
    public void shouldNotCreateContactWithInvalidName(String fname){
        this.contactManager.addContact(fname, "Doe", "0123456789");
        Assertions.assertTrue(contactManager.getAllContacts().isEmpty());
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