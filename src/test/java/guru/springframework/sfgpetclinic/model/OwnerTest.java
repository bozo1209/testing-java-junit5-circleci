package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions(){
        Owner owner = new Owner(1L, "Joe", "Doe");
        owner.setCity("Key West");
        owner.setTelephone("123");

        assertAll("properties test",
                () -> assertAll("person properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "first name not match"),
                        () -> assertEquals("Doe", owner.getLastName(), "last name not match")),
                () -> assertAll("owner properties",
                        () -> assertEquals("Key West", owner.getCity(), "city not match"),
                        () -> assertEquals("123", owner.getTelephone(), "phone not match"))
        );
    }

    @DisplayName("value source test - ")
    @ParameterizedTest(name = "{displayName} [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"one", "two", "three"})
    void testValueSource(String val){
        System.out.println(val);
    }

    @DisplayName("value source test - ")
    @ParameterizedTest(name = "{displayName} [{index}] {argumentsWithNames}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType){
        System.out.println(ownerType);
    }
}