package com.luis.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/mars")
public class RobotController {

    @Autowired
    private RobotService robotService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{moves}")
    public ResponseEntity<String> moveRobot(@PathVariable String moves) {

        String response = robotService.moveRobot(moves);

        if(response == null)
            return ResponseEntity.badRequest().body("400 Bad Request");
        else
            return ResponseEntity.ok().body(response);

    }

}
