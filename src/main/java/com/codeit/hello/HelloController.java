package com.codeit.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

//@ResponseBody //해당 메소드의 return문에서 반환하는 문자열이 HTML 파일 이름이 아니라, 리스폰스 내용 그 자체가 됨.
//@Controller
@RestController // @Controller와 @ResponseBody를 합친 것과 동일한 기능 제공
public class HelloController {
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello") // Composed Annotations(합성 어노테이션 : 자주 사용되는 설정을 미리 조합해서 만들어 둔 어노테이션)
    public String sayHello() {
        //return "hello";
        return "{\"status\": \"OK\", \"message\": \"Hello, Spring Boot!\"}"; //JSON(JavaScript Object Notation
    }

    //@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "goodbye";
    }

    @GetMapping("/info")
    public String getInfo() {
        return "{\"name\": \"Spring Boot\", \"version\": 3.2, \"active\": true}"; //문자열과 달리 숫자와 불린값은 큰따옴표로 감싸지 않음.
    }

    @GetMapping("/welcome")
    public String sayWelcome(@RequestParam String name) { //쿼리 스트링 사용. 파라미터에 @RequestParam을 붙이면 리퀘스트에 포함된 쿼리 스트링을 파라미터 변수로 받아 사용 가능.
        return "{\"message\": \"Welcome, " + name + "!\"}";
    }

    /*
    @GetMapping("/wave")
    public String tripleWave(@RequestParam Integer count) { //쿼리 스트링은 기본적으로 문자열로 넘어옴. 타입 변환도 가능.
        Integer tripleCount = count * 3;
        return "{\"message\": \"손을 " + tripleCount + "번 흔들었습니다.\"}";
    }
    */

    @GetMapping("/wave")
    public String tripleCount(@RequestParam(name = "hand") Integer count) { //쿼리 스트링 키와 파라미터명 다르게 설정 가능. @RequestParam 어노테이션에 name 아규먼트 전달하면 됨.
        Integer tripleCount = count * 3;
        return "{\"message\": \"손을 " + tripleCount + "번 흔들었습니다.\"}";
    }

    @GetMapping("/books") //파라미터를 여러 개 정의해서 여러개의 쿼리 스트링도 사용 가능.
    public String getBooks(@RequestParam(required = false, defaultValue = "1") Integer page, //쿼리 스트링을 필수로 받을 필요가 없다면 required 아규먼트에 false를 넘겨서 선택적으로 만들 수 있음. 기본값은 true로 키값을 넘겨주지 않으면 잘못된 리퀘스트가 왔다는 HTTP 400 오류가 발생함.
                           @RequestParam(required = false, defaultValue = "1") Integer line) { //값을 넘겨주지 않더라도 기본값 지정도 가능. 쿼리 스트링은 기본적으로 문자열이기에 기본값도 문자열로 지정해야 함. 기본값을 문자열로 지정하더라도 스프링이 알아서 파라미터의 타입으로 변환해줌.
        return "{\"message\": \"" + page + "번째 페이지, " +  line + "번째 줄입니다.\"}"; //
    }

    @GetMapping("/hello/{name}")
    public String welcomeMessage(@PathVariable String name) {
        return "{\"message\": \"안녕, " + name + "!\"}";
    }

    /*
    @GetMapping("/cube/{number}")
    public String getCube(@PathVariable Integer number) {
        Integer cube = number * number * number;
        return "{\"message\": \"" + number + "의 세제곱은 " + cube + "입니다.\"}";
    }
    */

    @GetMapping("/cube/{side}")
    public String getCube(@PathVariable(name = "side") Integer number) {
        Integer cube = number * number * number;
        return "{\"message\": \"" + number + "의 세제곱은 " + cube + "입니다.\"}";
    }

    @GetMapping("/cube/{side}/{count}")
    public String getCube(@PathVariable(name = "side") Integer number, @PathVariable Integer count) {
        Integer cube = number * number * number;
        Integer total = cube * count;
        return "{\"message\": \"" + number + "의 세제곱 " + cube + "을 " + count + "번 더하면 " + total + "입니다.\"}";
    }
}
