package javeriana.ms.multiplier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
public class MultiplierController {
    DataPersistence dataPersistence = new DataPersistence();
    DataPersistenceController dataPersistenceController = new DataPersistenceController();
    @Autowired
    Environment environment;

    @GetMapping("/mul")
    public ResponseEntity<String[]> multiplier(@RequestParam int a, @RequestParam int b, @RequestParam String user) {
        String[] response = new String[4];
        response[0] = user;
        response[1] = ("Hello " + user + " your operation is: " + String.valueOf(a) + " x " + String.valueOf(b) + " = "
                + String.valueOf(a * b));
        response[2] = (LocalDateTime.now().toString());
        response[3] = (environment.getProperty("local.server.port"));
        saveData(response);
        return new ResponseEntity<String[]>(response, null, HttpStatus.SC_OK);
    }

    @RequestMapping(value = "/history", produces = "application/json")
    public ResponseEntity<ArrayList<DataPersistence>> getData() {
        ArrayList<DataPersistence> response = dataPersistenceController.getData();
        return new ResponseEntity<ArrayList<DataPersistence>>(response, null, HttpStatus.SC_OK);
    }

    public void saveData(String[] data) {
        dataPersistence.setUser(data[0]);
        dataPersistence.setResponse(data[1]);
        dataPersistence.setDateInvocation(data[2]);
        dataPersistence.setPort(data[3]);
        dataPersistenceController.writeData(dataPersistence);
    }
}
