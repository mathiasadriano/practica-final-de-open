package org.hign.platform.u202213222.si729ebu202213222.assessment.domain;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mental_state_exams")
public class MentalStateExam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String examDate;

    @Column(nullable = false)
    private String examinerNationalProviderIdentifier;
}
