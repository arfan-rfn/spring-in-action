package com.optimagrowth.license.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PresidencyId implements java.io.Serializable {
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "organization_id")
    private Long organizationId;
}