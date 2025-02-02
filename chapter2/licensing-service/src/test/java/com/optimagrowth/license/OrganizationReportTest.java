package com.optimagrowth.license;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.optimagrowth.license.config.TestDataLoader;
import com.optimagrowth.license.model.Membership;
import com.optimagrowth.license.model.Organization;
import com.optimagrowth.license.service.MembershipService;
import com.optimagrowth.license.service.OrganizationService;
import static com.optimagrowth.license.util.TestUtils.printSectionHeader;

@SpringBootTest
@ActiveProfiles("test")
@Import(TestDataLoader.class)
class OrganizationReportTest {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private MembershipService membershipService;

    @Test
    void generateOrganizationReport() {
        // Get all organizations
        List<Organization> organizations = organizationService.getAllOrganizations();

        // Get all memberships
        List<Membership> memberships = membershipService.getAllMemberships();

        // Count members per organization
        Map<Long, Long> memberCounts = memberships.stream()
            .collect(Collectors.groupingBy(
                m -> m.getOrganization().getId(),
                Collectors.counting()
            ));

		printSectionHeader("Organization Membership Report");


        // Generate report for each organization
        organizations.forEach(org -> {
            System.out.println("\nOrganization Details:");
            System.out.println("-----------------------");
            System.out.println("Name: " + org.getName());
            System.out.println("Category: " + org.getCategory());
            System.out.println("Established: " + org.getEstablishedDate());
            System.out.println("Number of Members: " + memberCounts.getOrDefault(org.getId(), 0L));

            // Print members of this organization
            System.out.println("\nMembers:");
            memberships.stream()
                .filter(m -> m.getOrganization().getId().equals(org.getId()))
                .forEach(m -> System.out.println("- " + m.getPerson().getName() +
                    " (" + m.getPerson().getMajor() + ", " + m.getPerson().getDept() + ")"));

            System.out.println("-------------------------------------");
        });

        // Print summary
        System.out.println("\n=== Summary ===");
        System.out.println("Total Organizations: " + organizations.size());
        System.out.println("Total Memberships: " + memberships.size());
    }
}