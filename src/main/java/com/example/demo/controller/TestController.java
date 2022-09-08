package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //이 컨트롤러가 RestController임을 명시
@RequestMapping("test")
//현 패키지에는 컨트롤러와 관련된 클래스만 생성
public class TestController {
    @GetMapping//클라이언트가 이 리소스에 대해 Get 메서드로 요청하면 이 컨트롤러가 실행
    public String testController(){
        return "Hello World!";
    }

    @GetMapping("/testGetMapping")
    public String testControllerWithPath() {
        return "Hello World testGetMapping";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id){
        return "Hello World! ID " + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello World ID " + id;
    }

    //반환하고자 하는 리소스가 복잡할 경우(오브젝트와 같은 자료형)
    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World ID " + testRequestBodyDTO.getId() + " Message : "
                + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody")
    //모든 컨트롤러는 ResponseDTO를 반환한다.
    public ResponseDTO<String> testControllerResponseBody(){
        List<String> list = new ArrayList<>();
        list.add("Hello World ! I'm ResponseDTO");
        list.add("Thx!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity")
    //작성할 모든 컨트롤러는 ResponseEntity를 반환한다.
    //ResponseEntity는 HTTP 응답의 바디뿐만 아니라 여러 다른 매개변수(header, status)를 조작하고 싶을 때 사용한다.
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm responseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        //http status를 400으로 설정
        return ResponseEntity.badRequest().body(response);
    }

}
