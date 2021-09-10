package javeriana.ms.calculadora;

import java.util.ArrayList;

import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CalculadoraController {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/calculator/add")
    public ResponseEntity<String> calculatorAdd(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String[] response = restTemplate.getForObject("http://adder/add?a={a}&b={b}&user={user}", String[].class, a, b,
                user);
        return new ResponseEntity<>(response[1], HttpStatus.OK);
    }

    @GetMapping("/add-history")
    public ResponseEntity<ResponseData[]> calculatorAddHistory() {
        ResponseData[] response = restTemplate.getForObject("http://adder/history", ResponseData[].class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/calculator/mul")
    public ResponseEntity<String> calculatorMul(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String[] response = restTemplate.getForObject("http://multiplier/mul?a={a}&b={b}&user={user}", String[].class,
                a, b, user);
        return new ResponseEntity<>(response[1], HttpStatus.OK);
    }

    @GetMapping("/mul-history")
    public ResponseEntity<ResponseData[]> calculatorMulHistory() {
        ResponseData[] response = restTemplate.getForObject("http://multiplier/history", ResponseData[].class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/calculator/div")
    public ResponseEntity<String> calculatorDiv(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String[] response = restTemplate.getForObject("http://divider/div?a={a}&b={b}&user={user}", String[].class, a,
                b, user);
        return new ResponseEntity<>(response[1], HttpStatus.OK);
    }

    @GetMapping("/div-history")
    public ResponseEntity<ResponseData[]> calculatorDivHistory() {
        ResponseData[] response = restTemplate.getForObject("http://divider/history", ResponseData[].class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/calculator/sub")
    public ResponseEntity<String> calculatorSub(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String[] response = restTemplate.getForObject("http://subtraction/sub?a={a}&b={b}&user={user}", String[].class,
                a, b, user);
        return new ResponseEntity<>(response[1], HttpStatus.OK);
    }

    @GetMapping("/sub-history")
    public ResponseEntity<ResponseData[]> calculatorSubHistory() {
        ResponseData[] response = restTemplate.getForObject("http://subtraction/history", ResponseData[].class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
