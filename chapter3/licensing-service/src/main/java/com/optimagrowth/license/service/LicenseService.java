package com.optimagrowth.license.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.optimagrowth.license.model.License;
import com.optimagrowth.license.repository.LicenseRepository;

@Service
public class LicenseService {

    @Autowired
    MessageSource messages;

    @Autowired
    private LicenseRepository licenseRepository;

    public License getLicense(String licenseId, String organizationId) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (license == null) {
            throw new IllegalArgumentException(
                    String.format(messages.getMessage("license.search.error.message", null, null),
                            licenseId, organizationId));
        }
        return license;
    }

    public String createLicense(License license, String organizationId, Locale locale) {
        license.setOrganizationId(organizationId);
        licenseRepository.save(license);
        return String.format(messages.getMessage("license.create.message", null, locale), license.toString());
    }

    public String updateLicense(License license, String organizationId, Locale locale) {
        license.setOrganizationId(organizationId);
        licenseRepository.save(license);

        return String.format(messages.getMessage("license.update.message", null, locale), license.toString());
    }

    public String deleteLicense(String licenseId, String organizationId, Locale locale) {
        License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (license != null) {
            licenseRepository.delete(license);
        }
        return String.format(messages.getMessage("license.delete.message", null, locale),
                licenseId, organizationId);
    }
}
