package com.optimagrowth.license.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.optimagrowth.license.model.Membership;
import com.optimagrowth.license.model.MembershipId;

public interface MembershipRepository extends JpaRepository<Membership, MembershipId> {
}