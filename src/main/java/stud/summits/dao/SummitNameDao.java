package stud.summits.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stud.summits.model.SummitName;

import java.util.Optional;

@Repository
public interface SummitNameDao extends JpaRepository<SummitName, Long> {
    Page<SummitName> findBySummitId(Long summitId, Pageable pageable);
    Optional<SummitName> findByIdAndSummitId(Long id, Long summitId);
}
