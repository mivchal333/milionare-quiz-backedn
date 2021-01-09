package pl.krysiukm.milionarequiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.krysiukm.milionarequiz.model.HistoryEntry;

import java.util.List;

@Repository
public interface StatisticsRepository extends JpaRepository<HistoryEntry, Long> {
    List<HistoryEntry> findByUserUsernameOrderByDateDesc(String username);
}
