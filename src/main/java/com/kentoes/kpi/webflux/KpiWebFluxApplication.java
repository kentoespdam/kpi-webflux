package com.kentoes.kpi.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.kentoes.kpi.webflux.config.EnvConfig.ENDPOINT;

@SpringBootApplication
public class KpiWebFluxApplication {


	public static void main(String[] args) {

		SpringApplication.run(KpiWebFluxApplication.class, args);
	}

}
