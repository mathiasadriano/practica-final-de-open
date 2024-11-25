package org.hign.platform.u202213222.si729ebu202213222.personnel.infrastructure.persistence;

import org.hign.platform.u202213222.si729ebu202213222.personnel.domain.model.Examiner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    boolean existsByNationalProviderIdentifier(String nationalProviderIdentifier);
}
