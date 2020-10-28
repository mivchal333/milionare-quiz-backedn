package pl.krysiukm.milionarequiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krysiukm.milionarequiz.model.HistoryEntry;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.repository.StatisticsRepository;

import java.util.Date;
import java.util.List;

@Service
public class StatisticsService {

    StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public List<HistoryEntry> getUserStatistics(User user) {
        return statisticsRepository.findByUserUsername(user.getUsername());
    }

    public HistoryEntry createHistoryEntry(HistoryEntry historyEntry) {
        historyEntry.setDate(new Date());
        return statisticsRepository.save(historyEntry);
    }
}
