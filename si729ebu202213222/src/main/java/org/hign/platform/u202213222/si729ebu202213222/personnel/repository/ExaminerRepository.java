package org.hign.platform.u202213222.si729ebu202213222.personnel.repository;
import org.hign.platform.u202213222.si729ebu202213222.personnel.domain.Examiner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    Optional<Examiner> findByNationalProviderIdentifier(UUID nationalProviderIdentifier);
}
