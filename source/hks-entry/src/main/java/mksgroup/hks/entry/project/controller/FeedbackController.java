/**
 * Copyright 2018, MKS GROUP.
 */
package mksgroup.hks.entry.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This controller processes request /
 * @author ThachLN
 */
@Controller
public class FeedbackController {

    /**
     * Goto the feedback page.
     * @return
     */
    @RequestMapping("/feedback")
    public String dashboard() {
        return "feedback/feedback";
    }
}

