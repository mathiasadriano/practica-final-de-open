package org.hign.platform.u202213222.si729ebu202213222.assessment.interfaces.rest;

import lombok.RequiredArgsConstructor;
import org.hign.platform.u202213222.si729ebu202213222.assessment.domain.model.MentalStateExam;
import org.hign.platform.u202213222.si729ebu202213222.assessment.infrastructure.persistence.MentalStateExamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mental-state-exams")
@RequiredArgsConstructor
public class MentalStateExamController {

    private final MentalStateExamRepository mentalStateExamRepository;

    @PostMapping
    public ResponseEntity<?> createMentalStateExam(@RequestBody MentalStateExam mentalStateExam) {
        try {
            MentalStateExam savedExam = mentalStateExamRepository.save(mentalStateExam);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedExam);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
