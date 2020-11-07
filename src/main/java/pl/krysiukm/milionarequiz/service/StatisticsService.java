package pl.krysiukm.milionarequiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krysiukm.milionarequiz.model.HistoryEntry;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.repository.StatisticsRepository;

import java.util.List;

@Service
public class StatisticsService {
    UserService userService;
    StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsService(StatisticsRepository statisticsRepository,
                             UserService userService) {
        this.statisticsRepository = statisticsRepository;
        this.userService = userService;
    }

    public List<HistoryEntry> getUserStatistics(User user) {
        return statisticsRepository.findByUserUsername(user.getUsername());
    }

    public HistoryEntry createHistoryEntry(HistoryEntry historyEntry) {
        return statisticsRepository.save(historyEntry);
    }
}
