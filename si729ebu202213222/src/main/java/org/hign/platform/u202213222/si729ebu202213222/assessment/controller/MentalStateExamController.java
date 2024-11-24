package org.hign.platform.u202213222.si729ebu202213222.assessment.controller;
import lombok.RequiredArgsConstructor;
import org.hign.platform.u202213222.si729ebu202213222.assessment.domain.MentalStateExam;
import org.hign.platform.u202213222.si729ebu202213222.assessment.repository.MentalStateExamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mental-state-exams")
@RequiredArgsConstructor
public class MentalStateExamController {

    private final MentalStateExamRepository mentalStateExamRepository;

    @PostMapping
    public ResponseEntity<Object> createMentalStateExam(@RequestBody MentalStateExam mentalStateExam) {
        // Validar el formato de examDate (YYYY-MM-DD)
        try {
            LocalDate.parse(mentalStateExam.getExamDate());
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body("Invalid date format. Use YYYY-MM-DD.");
        }

        // Validar que examinerNationalProviderIdentifier sea un UUID válido
        try {
            UUID.fromString(mentalStateExam.getExaminerNationalProviderIdentifier());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid UUID format for examinerNationalProviderIdentifier.");
        }

        // Guardar el examen en la base de datos
        MentalStateExam savedExam = mentalStateExamRepository.save(mentalStateExam);

        // Preparar la respuesta con los campos requeridos
        return ResponseEntity.status(HttpStatus.CREATED).body(new MentalStateExamResponse(
                savedExam.getId(),
                savedExam.getExamDate(),
                savedExam.getExaminerNationalProviderIdentifier()
        ));
    }

    // Clase para estructurar la respuesta según los requisitos del examen
    private record MentalStateExamResponse(Long id, String examDate, String examinerNationalProviderIdentifier) {}
}
