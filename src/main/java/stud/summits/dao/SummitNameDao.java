package stud.summits.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import stud.summits.model.SummitName;

public interface SummitNameDao extends JpaRepository<SummitName, Long> {
}
