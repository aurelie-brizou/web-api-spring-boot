package dev;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// cette annotation permet de configurer automatiquement spring et scanner (composants : COntroller, Bean, Service...)
@SpringBootApplication
public class MyLibraryBackApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MyLibraryBackApplication.class, args);
	}


}
