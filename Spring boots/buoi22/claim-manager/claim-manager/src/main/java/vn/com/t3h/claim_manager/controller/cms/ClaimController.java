package vn.com.t3h.claim_manager.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cms")
public class ClaimController {
    @GetMapping("/claim-manager")
    public String claimManager() {
        return "cms/claim/claim-manager";
    }
    @GetMapping("detail-claim")
    public String detailClaim() {
        return "cms/claim/detail-claim";
    }
}
