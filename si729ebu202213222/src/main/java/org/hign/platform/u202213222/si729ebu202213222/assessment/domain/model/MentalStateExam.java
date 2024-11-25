package org.hign.platform.u202213222.si729ebu202213222.assessment.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hign.platform.u202213222.si729ebu202213222.shared.domain.model.entities.AuditableModel;

@Data
@Entity
@Table(name = "mental_state_exams")
public class MentalStateExam extends AuditableModel {
    @Column(nullable = false)
    private String examDate;

    @Column(nullable = false)
    private String examinerNationalProviderIdentifier;
}
