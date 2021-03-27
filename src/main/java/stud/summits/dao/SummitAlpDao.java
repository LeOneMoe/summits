package stud.summits.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stud.summits.model.SummitAlp;

import java.util.Optional;

@Repository
public interface SummitAlpDao extends JpaRepository<SummitAlp, Long> {
    Page<SummitAlp> findBySummitId(Long summitId, Pageable pageable);
    Optional<SummitAlp> findByIdAndSummitId(Long id, Long summitId);
}
