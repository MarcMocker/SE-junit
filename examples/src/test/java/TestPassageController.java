import scanner.*;
import validator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPassageController {
    
    @Test
    @DisplayName("get a valid certificate and allow passage")
    void test_valid_certificate(){
        // ARRANGE
        boolean pass = true;
        
        Scanner scanner = new StubScanner("X54oecbuefb");
        Validator validator = new StubValidator(pass);
        PassageController passageController = new PassageController(scanner, validator);
        
        // ACT
        passageController.controllOneAccessAttemt();
        
        // ASSERT
        assertEquals(((StubScanner) scanner).allowPassage , pass);
        assertEquals(((StubScanner) scanner).denyPassage, !pass);
    }

    @Test
    @DisplayName("get an invalid certificate and allow passage")
    void testInvalidCertificate(){
        // ARRANGE
        boolean pass = false;
        
        Scanner scanner = new StubScanner("X54oecbuefb");
        Validator validator = new StubValidator(pass);
        PassageController passageController = new PassageController(scanner, validator);
        
        // ACT
        passageController.controllOneAccessAttemt();
        
        // ASSERT
        assertEquals(((StubScanner) scanner).allowPassage , pass);
        assertEquals(((StubScanner) scanner).denyPassage, !pass);
    }
}
