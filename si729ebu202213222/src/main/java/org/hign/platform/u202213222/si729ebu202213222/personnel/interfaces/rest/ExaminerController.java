package org.hign.platform.u202213222.si729ebu202213222.personnel.interfaces.rest;

import lombok.RequiredArgsConstructor;
import org.hign.platform.u202213222.si729ebu202213222.personnel.application.command.CreateExaminerCommand;
import org.hign.platform.u202213222.si729ebu202213222.personnel.domain.model.Examiner;
import org.hign.platform.u202213222.si729ebu202213222.personnel.infrastructure.persistence.ExaminerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/examiners")
@RequiredArgsConstructor
public class ExaminerController {

    private final ExaminerRepository repository;

    @PostMapping
    public ResponseEntity<Examiner> create(@RequestBody CreateExaminerCommand command) {
        if (repository.existsByNationalProviderIdentifier(command.getNationalProviderIdentifier())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Examiner examiner = new Examiner();
        examiner.setFirstName(command.getFirstName());
        examiner.setLastName(command.getLastName());
        examiner.setNationalProviderIdentifier(command.getNationalProviderIdentifier());
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(examiner));
    }
}
