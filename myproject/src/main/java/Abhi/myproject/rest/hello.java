package Abhi.myproject.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {
    @Value("${plane.name}")
    public String planename;

    @Value("${plane.model}")
    public String planeModel;

    @GetMapping("/planes")
    public String Plane(){
        return "Name"+planename+" Model"+planeModel;
    }

   // expose "/" that return hello world
    @GetMapping("/")
    public String helo(){
        return "hello worldy!";
    }
    @GetMapping("/chess")
    public String playChess(){
        return "I wana play chess!";
    }



}
