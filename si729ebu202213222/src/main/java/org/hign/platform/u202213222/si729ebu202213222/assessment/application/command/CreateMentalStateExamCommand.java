package org.hign.platform.u202213222.si729ebu202213222.assessment.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMentalStateExamCommand {
    private String examDate;
    private String examinerNationalProviderIdentifier;
}
