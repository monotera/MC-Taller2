package javeriana.ms.subtraction;

import java.time.LocalDateTime;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubtractionController {
    @Autowired
    Environment environment;

    @GetMapping("/sub")
    public ResponseEntity<String[]> sub(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String[] response = new String[5];
        response[0] = user;
        response[1] = ("Hello " + user + " your operation is: " + String.valueOf(a) + " - " + String.valueOf(b) + " = "
                + String.valueOf(a - b));
        response[2] = (LocalDateTime.now().toString());
        response[3] = (environment.getProperty("local.server.port"));
        response[4] = "subtraction";
        return new ResponseEntity<String[]>(response, null, HttpStatus.SC_OK);

    }
}
