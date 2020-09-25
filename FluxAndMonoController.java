package com.reactive.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class FluxAndMonoController {

	@GetMapping(value= "/flux",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> returnFlux()
	{
		return Flux.just(1,2,3,4,5,6,7,8)
				.delayElements(Duration.ofSeconds(1)).log();
	}
	
	@GetMapping("/api")
	public List<Integer> api() {
		 List<Integer> list=new ArrayList<Integer>();
		 for(int i=1;i<=8;i++)
		 {
			 list.add(i);
			 try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		 return list;
	}
}
