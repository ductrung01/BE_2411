package vn.com.t3h.claim_manager.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class AminDetailClaimController {
    @GetMapping("cms/detail-claim")
    public String detailClaim() {
        return "cms/detail-claim";
    }
}
