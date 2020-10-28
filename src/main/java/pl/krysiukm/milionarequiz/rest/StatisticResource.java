package pl.krysiukm.milionarequiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krysiukm.milionarequiz.model.HistoryEntry;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.service.StatisticsService;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatisticResource {
    private final StatisticsService statisticsService;

    @Autowired
    public StatisticResource(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    public List<HistoryEntry> getUserStatistics(@RequestBody User user) {
        return statisticsService.getUserStatistics(user);
    }

    @PostMapping
    public HistoryEntry createHistoryEntry(@RequestBody HistoryEntry historyEntry) {
        return statisticsService.createHistoryEntry(historyEntry);
    }

}
