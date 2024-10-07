package codingon.spring_boot_default.controller._02_restapi;

import codingon.spring_boot_default.dto.UserDTO;
import codingon.spring_boot_default.vo.UserVO;
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

    // ==== DTO 이용 ====
    // #8. DTO with GET Method
    @GetMapping("/dto/res1")
    @ResponseBody
    public String dtoRes1(@ModelAttribute UserDTO userDTO) {
        // /dto/res1?name=s&age=1

        // @ModelAttribute UserDTO userDTO
        // - 요청 파라미터를 UserDTO 객체에 바인딩
        // - 폼 input 이름들 (name, age)이 UserDTO 필드명과 일치하면 자동 매핑
        //       -> 매핑? setter 를 실행
        //       -> ?name=s&age=1 -> setName("s"), setAge(1) 실행
        //       -> 따라서, Lombok plugin 설치도 필요
        //          그렇지 않으면 롬복은 애플리케이션 실행 후에 getter, setter 를 생성하기 때문에
        //          현재 시점에는 getter 가 없다고 생각해서 빨간 줄을 표시한 것임

        System.out.println("[GET] userDTO (name) = " + userDTO.getName()); // s
        System.out.println("[GET] userDTO (age) = " + userDTO.getAge()); // 1

        return userDTO.getName() + " " + userDTO.getAge();
    }

    // #9. DTO with POST Method (@RequestBody x)
    @PostMapping("/dto/res2")
    @ResponseBody
    public String dtoRes2(UserDTO userDTO) {
        // @ModelAttribute 어노테이션 생략 가능
        // - 파라미터의 UserDTO 타입 앞에 아무것도 없으면! @ModalAttribute 어노테이션 자동 추가됨
        // - POST 방식이므로 폼 데이터를 자동으로 UserDTO 바인딩

        System.out.println("[POST] userDTO (name) = " + userDTO.getName()); // c
        System.out.println("[POST] userDTO (age) = " + userDTO.getAge()); // 2

        return userDTO.getName() + " " + userDTO.getAge();
    }

    // #10. [ERROR] DTO with POST Method (@RequestBody o)
    @PostMapping("/dto/res3")
    @ResponseBody
    public String dtoRes3(@RequestBody UserDTO userDTO) {
        // @RequestBody 어노테이션
        // - 요청 본문 (req.body) 에 있는 데이터를 읽어와서 객체에 매핑
        //   -> 매핑? 필드에 값을 주입
        // - 반환 값을 HTTP 본문에 직접 작성하게 함
        // - 단!!!!!!!! 요청 형식이 JSON 또는 XMl 일 때 사용됨 (하지만 우리는 지금 일반폼 전송)

        // 참고. POST /dto/res3 요청의 경우, "일반 폼 전송"
        // - 즉, MIME Type 이 application/www-x-form-urlencoded
        // -> 따라서, @RequestBody 어노테이션 사용시 오류 발생함

        // 올바르게 사용하려면?
        // 1. "일반 폼 전송"을 하고 있으니 @ModelAttribute 를 사용 (혹은 생략) -> 9번 폼
        // 2. 클라이언트 측에서 js 코드를 사용해 폼 데이터를 json 으로 변환하여 전송 -> 동적 폼 전송 구현
        System.out.println("[POST] userDTO (name) = " + userDTO.getName());
        System.out.println("[POST] userDTO (age) = " + userDTO.getAge());

        return userDTO.getName() + " " + userDTO.getAge();
    }


    // ==== VO 이용 ====
    // #11. VO with GET Method
    @GetMapping("/vo/res1")
    @ResponseBody
    public String voRes1(@ModelAttribute UserVO userVO) {
        // /vo/res1?name=s&age=1

        // @ModelAttribute UserVO userVO
        // - 요청 파라미터를 UserVO 객체에 바인딩

        // 참고. 브라우저에서 응답이 "null 0" 으로 도착하는 이유는?
        // - @ModelAttribute 어노테이션은 setter 메서드를 통해 객체에 값을 주입
        // - 하지만, UserVO 에는 setter 가 없으므로 폼에서 전송된 데이터가 주입되지 않음
        // => 따라서, name/age 필드는 초기화되지 않은 상태 null 과 0으로 남게 됨

        System.out.println("[GET] userVO (name) = " + userVO.getName()); // null
        System.out.println("[GET] userVO (age) = " + userVO.getAge()); // 0

        return userVO.getName() + " " + userVO.getAge();
    }

    // #12. VO with POST Method (@RequestBody x)
    @PostMapping("/vo/res2")
    @ResponseBody
    public String voRes2(UserVO userVO) {
        // @ModelAttribute 어노테이션 생략 가능
        // - setter 를 이용해 객체에 값을 주입
        // -> VO 객체는 setter 를 가지지 않으므로 데이터 바인딩이 제대로 이뤄지지 않음

        System.out.println("[POST] userVO (name) = " + userVO.getName()); // null
        System.out.println("[POST] userVO (age) = " + userVO.getAge()); // 0

        return userVO.getName() + " " + userVO.getAge();
    }

    // #13. [ERROR] VO with POST Method (@RequestBody o)
    // type=Unsupported Media Type, status=415 에러 발생
    // 참고. HTTP Status code 415
    // - 서버가 클라이언트로부터 받은 요청의 미디어타입 (Content-Type) 을 지원하지 않거나 이해할 수 없는 경우 발생하는 에러
    @PostMapping("/vo/res3")
    @ResponseBody
    public String voRes3(@RequestBody UserVO userVO) {
        // @RequestBody UserVO userVO
        // - 요청의 본문 데이터를 UserVO 객체로 변환 시도

        // 참고. @RequestBody 어노테이션은 주로 JSON/XML 형식 데이터를 처리하기 위해 사용
        // - 지금 "일반 폼 전송"을 사용하고 있으므로 MIME Type 이 "application/x-www-form-urlencoded"
        // - 두 형식이 일치하지 않으므로 Spring 이 해당 요청 본문을 UserVO 객체로 변환 불가능

        // 올바른 사용
        // 1. @RequestBody 어노테이션 제거 -> @ModelAttribute 사용
        // 2. 클라이언트 측에서 js 를 사용해 폼 데이터를 json 으로 변환하여 "동적 폼 전송" 구현

        System.out.println("[POST] userVO (name) = " + userVO.getName());
        System.out.println("[POST] userVO (age) = " + userVO.getAge());

        return userVO.getName() + " " + userVO.getAge();
    }

    // ======== DTO 이용 (with. Axios) ========

    // #14-1. DTO with GET Method, Axios
    @GetMapping("/axios/res1")
    @ResponseBody
    public String axiosRes1(@RequestParam String name, @RequestParam String age) {
        System.out.println("[GET] axios (name) = " + name);
        System.out.println("[GET] axios (age) = " + age);

        return "이름: " + name + ", 나이: " + age;
    }

    // #14-2. DTO with Get Method, Axios, DTO
    @GetMapping("/axios/res2")
    @ResponseBody
    public String axiosRes2(UserDTO userDTO) {
        // UserDTO 객체를 파라미터로 받아 자동으로 데이터 바인딩
        // - DTO 를 사용해서 데이터 캡슐화
        // - 14-1 폼 대비 DTO 사용하니 코드가 깔끔해지고, 데이터 구조 설계 확장 가능
        System.out.println("[GET] axios and dto (name) = " + userDTO.getName());
        System.out.println("[GET] axios and dto (age) = " + userDTO.getAge());

        return "이름: " + userDTO.getName() + ", 나이: " + userDTO.getAge();
    }

    // #15-1. [ERROR] DTO with Post Method, Axios
    @PostMapping("/axios/res3")
    @ResponseBody
    public String axiosRes3(@RequestParam String name, @RequestParam String age) {
        // @RequestParam
        // 참고. 에러 발생 이유
        // - 클라이언트에서는 데이터를 객체로 전송, 서버에서는 @RequestParam 으로 받으려고 함
        // - Axios 는 기본적으로 데이터를 JSON 형식으로 전송 (Content-Type: application/json)
        // - 하지만, 서버측 코드는 @RequestParam 을 사용해 데이터를 받음 (Content-Type: application/x-www-form-urlencoded)
        System.out.println("[POST] axios (name) = " + name);
        System.out.println("[POST] axios (age) = " + age);

        return "이름: " + name + ", 나이: " + age;
    }

    // #15-2. DTO with Post Method, Axios
    @PostMapping("/axios/res4")
    @ResponseBody
    public String axiosRes4(UserDTO userDTO) {
        // @RequestBody 어노테이션 없이 UserDTO 객체로 파라미터를 받고자 함.
        // - JSON 데이터는 요청 본문에 있지만, @RequestBody 없는 UserDTO 는 주로 폼 데이터나 쿼리 파라미터를 바인딩하는데 사용
        // - 즉, @RequestBody 어노테이션이 없으면 String 은 JSON 요청 본문을 자동으로 UserDTO 에 바인딩하지 않음.
        System.out.println("[POST] axios and dto (name) = " + userDTO.getName());
        System.out.println("[POST] axios and dto (age) = " + userDTO.getAge());

        return "이름: " + userDTO.getName() + ", 나이: " + userDTO.getAge();
    }

    // #15-3. DTO with Post Method, Axios
    @PostMapping("/axios/res5")
    @ResponseBody
    public String axiosRes5(@RequestBody UserDTO userDTO) {
        // @RequestBody UserDTO userDTO
        // - 요청의 본문 JSON 데이터를 UserDTO 객체로 직접 매핑
        // - 즉, RESTful API 설계에 적합하며, 클라이언트-서버 간 데이터 교환을 명확하게 함.
        // => #15-2 코드의 해결책!
        System.out.println("[POST] axios and dto (name) = " + userDTO.getName());
        System.out.println("[POST] axios and dto (age) = " + userDTO.getAge());

        return "이름: " + userDTO.getName() + ", 나이: " + userDTO.getAge();
    }

    // ======== VO 이용 (with. Axios) ========
    // #16-1. VO with Get Method, Axios
    @GetMapping("/axios/vo/res1")
    @ResponseBody
    public String axiosVoRes1(@RequestParam String name, @RequestParam String age) {
        // @RequestParam
        // - HTTP 요청 파라미터를 메서드 매개변수에 바인딩

        System.out.println("[GET] axios (name) = " + name);
        System.out.println("[GET] axios (age) = " + age);

        return "이름: " + name + ", 나이: " + age;
    }

    // #16-2. VO with Get Method, Axios
    @GetMapping("/axios/vo/res2")
    @ResponseBody
    public String axiosVoRes2(UserVO userVO) {
        // @ModelAttribute 어노테이션 생략
        // - 해당 어노테이션은 setter 를 통해 객체에 값을 주입..!
        // -> VO 객체에는 setter 가 없으니 데이터 바인딩이 제대로 이뤄지지 않음
        // -> 그러므로 모든 필드가 기본 값(참조값 null, 정수형은 0) 으로 초기화

        System.out.println("[GET] axios and vo (name) = " + userVO.getName());
        System.out.println("[GET] axios and vo (age) = " + userVO.getAge());

        return "이름: "+ userVO.getName() + ", 나이: "+ userVO.getAge();
    }

    // #17-1. [ERROR] VO with Post Method, Axios
    @PostMapping("/axios/vo/res3")
    @ResponseBody
    public String axiosVoRes3(@RequestParam String name, @RequestParam String age) {
        // @RequestParam
        // - 주로, application/x-www-form-urlencoded 형식의 데이터를 처리하는데 사용하는데,
        // -> 현재 프론트엔드 에서는 JSON 형식으로 요청의 바디에 데이터를 보내고 있음.
        System.out.println("[POST] axios (name) = " + name);
        System.out.println("[POST] axios (age) = " + age);

        return "이름: " + name + ", 나이: " + age;
    }

    // #17-2. VO with Post Method, Axios
    @PostMapping("/axios/vo/res4")
    @ResponseBody
    public String axiosVoRes4(UserVO userVO){
        // @ModelAttribute 생략
        // -> setter 를 통해 객체에 값을 주입, vo 객체니까 setter 가 없어서 데이터가 바인딩되지 않음
        System.out.println("[POST] axios and vo (name) = " + userVO.getName());
        System.out.println("[POST] axios and vo (age) = " + userVO.getAge());

        return "이름: " + userVO.getName() + ", 나이: " + userVO.getAge();
    }

    // #17-3. VO with Post Method, Axios
    @PostMapping("/axios/vo/res5")
    @ResponseBody
    public String axiosVoRes5(@RequestBody UserVO userVO){
        // @RequestBody
        // - JSON 형식의 본문을 UserVO 객체로 올바르게 변환하도록 함

        // 비교. @ModelAttribute vs. @RequestBody
        // - @ModelAttribute: setter 함수를 실행해 값을 넣음
        // - @RequestBody: 각 필드에 직접 접근해서 값을 주입 (setter 를 사용하지 않음)

        System.out.println("[POST] axios and vo (name) = " + userVO.getName());
        System.out.println("[POST] axios and vo (age) = " + userVO.getAge());

        return "이름: " + userVO.getName() + ", 나이: " + userVO.getAge();
    }

}