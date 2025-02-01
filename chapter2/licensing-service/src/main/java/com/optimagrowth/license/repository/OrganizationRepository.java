package com.optimagrowth.license.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optimagrowth.license.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}