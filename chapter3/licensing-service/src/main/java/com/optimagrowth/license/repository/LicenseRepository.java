package com.optimagrowth.license.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optimagrowth.license.model.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {
    // Spring Data JPA will implement this method based on the method name
    // It will create a query like:
    // SELECT * FROM licenses WHERE organization_id = ? AND license_id = ?
    License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);

	License findByLicenseId(String licenseId);
}