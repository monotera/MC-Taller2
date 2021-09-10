package javeriana.ms.divider;

import java.time.LocalDateTime;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DividerController {
    @Autowired
    Environment environment;

    @GetMapping("/div")
    public ResponseEntity<String[]> div(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String[] response = new String[5];
        try {
            response[0] = user;
            response[1] = ("Hello " + user + " your operation is: " + String.valueOf(a) + " / " + String.valueOf(b)
                    + " = " + String.valueOf(a / b));
            response[2] = (LocalDateTime.now().toString());
            response[3] = (environment.getProperty("local.server.port"));
            response[4] = "division";
            return new ResponseEntity<String[]>(response, null, HttpStatus.SC_OK);
        } catch (Exception e) {
            response[0] = user;
            response[1] = "Error, the division is invalid";
            response[2] = (LocalDateTime.now().toString());
            response[3] = (environment.getProperty("local.server.port"));
            response[4] = "division";
            return new ResponseEntity<String[]>(response, null, HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
