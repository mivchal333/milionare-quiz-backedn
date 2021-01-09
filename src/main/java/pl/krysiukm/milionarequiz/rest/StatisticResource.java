package pl.krysiukm.milionarequiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krysiukm.milionarequiz.bean.HistoryEntryBean;
import pl.krysiukm.milionarequiz.model.HistoryEntry;
import pl.krysiukm.milionarequiz.model.User;
import pl.krysiukm.milionarequiz.rest.exception.BadRequestResponseException;
import pl.krysiukm.milionarequiz.service.BeanHelper;
import pl.krysiukm.milionarequiz.service.StatisticsService;
import pl.krysiukm.milionarequiz.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/stats")
public class StatisticResource {
    private final StatisticsService statisticsService;
    private final UserService userService;
    private final BeanHelper beanService;

    @Autowired
    public StatisticResource(StatisticsService statisticsService,
                             UserService userService, BeanHelper beanService) {
        this.statisticsService = statisticsService;
        this.userService = userService;
        this.beanService = beanService;
    }

    @GetMapping
    public List<HistoryEntry> getUserStatistics(@RequestParam String username) {
        Optional<User> userOpt = userService.getUser(username);
        if (!userOpt.isPresent()) {
            throw new BadRequestResponseException();
        }
        return statisticsService.getUserStatistics(userOpt.get());
    }

    @PostMapping
    public HistoryEntry createHistoryEntry(@RequestBody HistoryEntryBean historyEntryBean) {
        HistoryEntry historyEntry = beanService.getHistoryEntry(historyEntryBean);
        historyEntry.setDate(new Date());
        return statisticsService.createHistoryEntry(historyEntry);
    }

}
