package mksgroup.hks.entry.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatisticsController {
    /**
     * Goto the index page.
     * @return
     */
    @RequestMapping("/statistics")
    public String statistics() {
        return "statistics/summary";
    }
    
    @RequestMapping("/statistics2")
    public String statistics2() {
        return "statistics/summary2";
    }
}
