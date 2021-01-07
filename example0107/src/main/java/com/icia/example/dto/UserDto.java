package com.icia.example.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDto {
	private String uid;
	private String upwd;
	private String uname;
	private String ugender;
	private String ubirth;
	private String uemail;
	private String uadd;
	private String uphone;
	private MultipartFile file;
	private String uprofile;
	private int filele;
}
