package co.imdo.perfect.controller;

import co.imdo.perfect.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class TestSentinelController {

    @Autowired
    private JedisService jedisService;

    @ResponseBody
    @GetMapping("/set")
    public String test1(@RequestParam("key") String key, @RequestParam("value") String value) {
        return jedisService.set(key, value);
    }

    @ResponseBody
    @GetMapping("/get")
    public String test1(@RequestParam("key") String key) {
        return jedisService.get(key);
    }
}
