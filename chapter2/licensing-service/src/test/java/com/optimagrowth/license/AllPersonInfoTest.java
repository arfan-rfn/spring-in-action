package com.optimagrowth.license;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.optimagrowth.license.config.TestDataLoader;
import com.optimagrowth.license.model.Person;
import com.optimagrowth.license.service.PersonService;
import static com.optimagrowth.license.util.TestUtils.printDivider;
import static com.optimagrowth.license.util.TestUtils.printSectionHeader;

@SpringBootTest
@ActiveProfiles("test")
@Import(TestDataLoader.class)
class AllPersonInfoTest {

    @Autowired private PersonService personService;

    @Test
    void printAllData() {
        // Print Persons
        List<Person> persons = personService.getAllPersons();
        printSectionHeader("All Persons: (total: " + persons.size() + ")");
        persons.forEach(person -> {
            System.out.println("ID: " + person.getId());
            System.out.println("Name: " + person.getName());
            System.out.println("Major: " + person.getMajor());
            System.out.println("Department: " + person.getDept());
            System.out.println("Date of Birth: " + person.getDateOfBirth());
            System.out.println("Phone: " + person.getPhone());
            System.out.println("Email: " + person.getEmail());
            printDivider();
        });
    }
}