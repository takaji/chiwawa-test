package jp.co.dreamarts.chiwawa.web.api;

import jp.co.dreamarts.chiwawa.entity.Session;
import jp.co.dreamarts.chiwawa.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/client")
public class ClientApiController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping("/session")
    public Session getSession(@RequestParam String companayId, @RequestParam String loginId) {
        return sessionService.getSession(companayId, loginId);
    }

}
