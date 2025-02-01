package com.optimagrowth.license.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.optimagrowth.license.model.Presidency;
import com.optimagrowth.license.model.PresidencyId;

public interface PresidencyRepository extends JpaRepository<Presidency, PresidencyId> {
}