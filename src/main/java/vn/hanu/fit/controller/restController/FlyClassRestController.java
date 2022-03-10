package vn.hanu.fit.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hanu.fit.entity.FlyClass;
import vn.hanu.fit.repository.FlyClassRepository;

@RestController
@RequestMapping("/flyclass")
public class FlyClassRestController {

    @Autowired
    FlyClassRepository flyClassRepository;
    @PostMapping("/add")
    public FlyClass createFlyClass(@RequestBody FlyClass flyClass){
        return flyClassRepository.save(flyClass);
    }
}
