package com.optimagrowth.license.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimagrowth.license.model.Membership;
import com.optimagrowth.license.model.MembershipId;
import com.optimagrowth.license.repository.MembershipRepository;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;

    public List<Membership> getAllMemberships() {
        return membershipRepository.findAll();
    }

    public Membership createMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    public void deleteMembership(Long personId, Long organizationId) {
        Membership membership = new Membership();
        MembershipId id = new MembershipId();
        id.setPersonId(personId);
        id.setOrganizationId(organizationId);
        membership.setId(id);
        membershipRepository.delete(membership);
    }
}