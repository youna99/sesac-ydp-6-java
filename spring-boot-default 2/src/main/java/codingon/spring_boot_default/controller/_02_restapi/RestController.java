package codingon.spring_boot_default.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestController {
    // ==== Template 랜더링 ====
    // GET localhost:PORT/ 요청 시; _02_restapi/req.html 이 브라우저에 랜더링
    // node.js) res.render() 와 유사한 역할
    @GetMapping("/")
    public String getReq() { return "_02_restapi/req"; }

    // ==== GET 요청 ====
    // #1. Get Method / Query string
    @GetMapping("/get/res1")
    public String getRes1(@RequestParam(value="name") String name,
                          @RequestParam(value="age") int age, Model model) {
        // req ex. /get/res1?name=s&age=1

        // @RequestParam 어노테이션
        // - HTTP 요청 파라미터를 메서드 매개변수에 바인딩
        // - query string 중에서 name key 에 대한 value 를 String name 에 매핑
        // - required=true 가 기본 값 이므로 요청 URL 에서 name key 를 필수로 보내야 함
        //      퀴즈. name input 은 빈 input 으로 요청을 보내도 에러가 발생하지 않는 이유?
        //      -> String 은 빈 문자열도 유효한 값으로 취급하기 때문!
        System.out.println("[GET] request query string (name) = " + name);
        System.out.println("[GET] request query string (age) = " + age);

        // view 에 전달할 데이터를 Model 객체에 추가
        model.addAttribute("name", name); // s
        model.addAttribute("age", age); // 1

        // 응답 결과를 보여줄 뷰 이름 반환
        return "_02_restapi/res";
    }

    // #2. Get Method / Query string (required=false)
    @GetMapping("/get/res2")
    public String getRes2(@RequestParam(value="name", required = false) String name,
                          Model model) {
        System.out.println("[GET] request query string (name) = " + name);

        // view 에 전달할 데이터를 Model 객체에 추가
        model.addAttribute("name", name);

        // 응답 결과를 보여줄 뷰 이름 반환
        return "_02_restapi/res";
    }

    // #3. Get Method / Path variable
    @GetMapping("/get/res3/{param1}/{param2}")
    public String getRes3(@PathVariable String param1,
                          @PathVariable(value="param2") int age, Model model) {
        // @PathVariable 어노테이션
        // - URL path variable 을 사용할 때 필요
        // - 기본적으로 path variable 은 값을 가져야 함 (즉, 값이 없으면 404 error)

        // 참고. URL 의 path variable 과 해당 메서드의 매개변수명을 다르게 사용하고 싶다면?
        // ex. @PathVariable("param2") int age

        System.out.println("[GET] request path variable (name) = " + param1);
        System.out.println("[GET] request path variable (age) = " + age);

        model.addAttribute("name", param1);
        model.addAttribute("age", age);

        return "_02_restapi/res";
    }


    // #4. Get Method / Path variable (optional)
    // 선택적으로 받아오는 path variable 이 있다면, {} 안에 경로 여러 개 설정
    @GetMapping({"/get/res4/{name}/{age}", "/get/res4/{name}"})
    public String getRes4(@PathVariable String name,
                          @PathVariable(required = false) Integer age, Model model) {
        // path variable 중에서 name(필수), age(선택) 이라면?
        // - required=false 사용
        // - optional 한 변수가 맨 뒤에 와야 함

        // 참고. age 변수의 타입이 int 가 아닌 Integer 인 이유?
        // - age (숫자형) optional 한 값이므로 null 이 가능함.
        // - primitive type (int) 은 null 값을 가질 수 없음
        // - 따라서, reference type 인 wrapper 객체 사용해야 함

        System.out.println("[GET] request path variable (name) = " + name);
        System.out.println("[GET] request path variable (age) = " + age);

        model.addAttribute("name", name); // 성춘향
        model.addAttribute("age", age); // null

        return "_02_restapi/res";
    }

    // ==== POST 요청 ====
    // #5. Post Method / form data (required=true)
    @PostMapping("/post/res1")
    public String postRes1(@RequestParam String name, @RequestParam int age, Model model) {
        System.out.println("[POST] request request param (name) = " + name);
        System.out.println("[POST] request request param (age) = " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "_02_restapi/res";
    }

    // #6. Post Method / form data (required=false)
    @PostMapping("/post/res2")
    public String postRes1(@RequestParam String name,
                           @RequestParam(required = false) Integer age, Model model) {
        System.out.println("[POST] request request param (name) = " + name);
        System.out.println("[POST] request request param (age) = " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "_02_restapi/res";
    }

    // #1~6 폼까지는 항상 Template view 반환!
    // 하지만, Spring Boot 를 API 서버로 활용하고자 데이터 자체를 응답하고 싶다면?
    // => @RequestBody 사용
    // #7. Post Method / @RequestBody annotation
    @PostMapping("/post/res3")
    @ResponseBody // 메서드의 반환 값을 응답 본문 (response body) 에 직접 쓰도록 지시
    public String postRes3(@RequestParam String name,
                           @RequestParam int age, Model model) {
        // @ResponseBody 어노테이션
        // - 응답시 객체를 JSON 으로 리턴할 때 사용
        // - 즉, 응답 객체를 전달 (express res.send() 메서드와 유사)

        System.out.println("[POST] request request param (name) = " + name);
        System.out.println("[POST] request request param (age) = " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        // 템플릿 엔진(res.html) 이 아닌 문자열 그 자체를 응답
        return name + " " + age;
    }


}