/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.hks.view.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This controller processes request /
 * @author ThachLN
 */
@Controller
public class DashboardController {

    /**
     * Goto the index page.
     * @return
     */
    @RequestMapping("/dashboard")
    public String login() {
        return "dashboard/summary";
    }
}
