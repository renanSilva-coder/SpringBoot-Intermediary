package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.config.FileStorageProperties;

import Exception.ArquivoNaoEncontradoException;
import Exception.UploadArquivoException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArquivoService {
	
	private final Path fileStorageLocation;
	
	public ArquivoService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
				.toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (IOException e) {
			throw new UploadArquivoException("Algo deu errado ao tentar criar a pasta", e);
		}
	}
	
	public String getContentType(HttpServletRequest request, Resource resource) {
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		}catch(Exception e) {
			log.error("Não foi possível determinar o tipo de arquivo", e);
		}
		
		if(contentType == null)
			contentType = "Application/octet-stream";
		
		return contentType;
	}
	
	
	public Resource carregarArquivo(String nomeArquivo) {
		try {
			Path filePath = this.fileStorageLocation.resolve(nomeArquivo).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists())
				return resource;
			else {
				throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
			}
		}catch(Exception e) {
			throw new ArquivoNaoEncontradoException("Arquivo não encontrado");
		}
	}
	
	public String salvarArquivo(MultipartFile file) {
		String nomeArquivo = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(nomeArquivo.contains(".."))
				throw new UploadArquivoException("Arquivo inválido!");
			
			Path targetLocation = this.fileStorageLocation.resolve(nomeArquivo);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			return nomeArquivo;
		}catch(IOException e) {
			throw new UploadArquivoException("Erro ao tentar salvar o arquivo!", e);
		}
	}
}





