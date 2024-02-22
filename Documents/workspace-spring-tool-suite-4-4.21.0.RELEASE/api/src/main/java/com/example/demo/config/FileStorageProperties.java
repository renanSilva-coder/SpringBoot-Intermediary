package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class FileStorageProperties {

	@Value("${arquivo.uploadDir}")
	private String uploadDir;
}
