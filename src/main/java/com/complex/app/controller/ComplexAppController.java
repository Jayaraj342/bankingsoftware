package com.complex.app.controller;

import com.complex.app.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//makes RestController - else without ResponseBody it might return View as well
@Controller
@ResponseBody
public class ComplexAppController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("/get")
    public String get() {
        return dummyService.dummyCall();
    }
}
