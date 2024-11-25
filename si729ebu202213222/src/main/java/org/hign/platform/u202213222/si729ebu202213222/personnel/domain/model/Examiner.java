package org.hign.platform.u202213222.si729ebu202213222.personnel.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hign.platform.u202213222.si729ebu202213222.shared.domain.model.entities.AuditableModel;

@Data
@Entity
@Table(name = "examiners")
public class Examiner extends AuditableModel {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String nationalProviderIdentifier;
}
