package org.hign.platform.u202213222.si729ebu202213222.personnel.controller;
import lombok.RequiredArgsConstructor;
import org.hign.platform.u202213222.si729ebu202213222.personnel.domain.Examiner;
import org.hign.platform.u202213222.si729ebu202213222.personnel.repository.ExaminerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/examiners")
@RequiredArgsConstructor
public class ExaminerController {

    private final ExaminerRepository examinerRepository;

    @PostMapping
    public ResponseEntity<Object> createExaminer(@RequestBody Examiner examiner) {
        // Validar formato de UUID
        try {
            UUID.fromString(examiner.getNationalProviderIdentifier().toString());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid UUID format for nationalProviderIdentifier.");
        }

        // Validar unicidad del nationalProviderIdentifier
        Optional<Examiner> existingExaminer = examinerRepository.findByNationalProviderIdentifier(examiner.getNationalProviderIdentifier());
        if (existingExaminer.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NationalProviderIdentifier already exists.");
        }

        // Guardar el nuevo examiner
        Examiner savedExaminer = examinerRepository.save(examiner);

        // Crear respuesta sin atributos de auditoría
        Map<String, Object> response = new HashMap<>();
        response.put("id", savedExaminer.getId());
        response.put("firstName", savedExaminer.getFirstName());
        response.put("lastName", savedExaminer.getLastName());
        response.put("nationalProviderIdentifier", savedExaminer.getNationalProviderIdentifier().toString());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
