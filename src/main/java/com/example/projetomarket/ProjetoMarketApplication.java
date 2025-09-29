package com.example.projetomarket;

import com.example.projetomarket.repositorios.DunksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoMarketApplication implements CommandLineRunner {
	@Autowired
	private DunksRepository dunksRepository;

	@Override
	public void run(String... args) throws Exception {

	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoMarketApplication.class, args);
	}

}
