package com.optimagrowth.license.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.optimagrowth.license.model.Presidency;
import com.optimagrowth.license.model.PresidencyId;
import com.optimagrowth.license.repository.PresidencyRepository;

@Service
public class PresidencyService {
    @Autowired
    private PresidencyRepository presidencyRepository;

    public List<Presidency> getAllPresidencies() {
        return presidencyRepository.findAll();
    }

    public Presidency createPresidency(Presidency presidency) {
        return presidencyRepository.save(presidency);
    }

    public void deletePresidency(Long personId, Long organizationId) {
        Presidency presidency = new Presidency();
        PresidencyId id = new PresidencyId();
        id.setPersonId(personId);
        id.setOrganizationId(organizationId);
        presidency.setId(id);
        presidencyRepository.delete(presidency);
    }
}