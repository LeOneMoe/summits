package stud.summits.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stud.summits.model.SummitName;

import java.util.List;
import java.util.Optional;

@Repository
public interface SummitNameDao extends JpaRepository<SummitName, Long> {
    List<SummitName> findBySummitId(Long summitId);
    Optional<SummitName> findByIdAndSummitId(Long id, Long summitId);
}
