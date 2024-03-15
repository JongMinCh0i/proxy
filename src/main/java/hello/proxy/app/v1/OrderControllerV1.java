package hello.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

/*
   3.0 기준 : @Controller Or @RequestMapping 이 있어야 스프링 컨트롤러 인식
*/
@RestController
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
