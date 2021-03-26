package stud.summits.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import stud.summits.model.Summit;

public interface SummitDao extends JpaRepository<Summit, Long> {
}
