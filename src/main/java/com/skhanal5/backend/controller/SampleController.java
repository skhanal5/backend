package com.skhanal5.backend.controller;

import com.skhanal5.backend.model.Sample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

  @GetMapping("/samples")
  public Sample getSamples() {
    return new Sample("1", "foo");
  }
}
