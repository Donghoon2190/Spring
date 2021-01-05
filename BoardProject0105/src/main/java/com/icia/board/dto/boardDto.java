package com.icia.board.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class boardDto {
	private String bnum;
	private String bwriter;
	private String bpwd;
	private String btitle;
	private String bcontents;
	private String bdate;
	private String bhits;
	private String breply;

	private String bfilename;
	private MultipartFile bfile;
	
}
