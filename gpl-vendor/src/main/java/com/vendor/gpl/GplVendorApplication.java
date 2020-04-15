package com.vendor.gpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GplVendorApplication {
	public static void main(String[] args) {
		System.out.println("GPL Vendor started");
		SpringApplication.run(GplVendorApplication.class, args);
	}
}
