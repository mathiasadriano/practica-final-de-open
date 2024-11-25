package org.hign.platform.u202213222.si729ebu202213222.personnel.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExaminerCommand {
    private String firstName;
    private String lastName;
    private String nationalProviderIdentifier;
}
