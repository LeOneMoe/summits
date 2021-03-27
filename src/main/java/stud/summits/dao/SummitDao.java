package stud.summits.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stud.summits.model.Summit;

@Repository
public interface SummitDao extends JpaRepository<Summit, Long> {
}
