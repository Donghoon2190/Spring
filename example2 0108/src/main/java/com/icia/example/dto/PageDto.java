package com.icia.example.dto;

import lombok.Data;

@Data
public class PageDto {
	private int Page;
	private int StartPage;
	private int EndPage;
	private int MaxPage;
	private int StartRow;
	private int EndRow;
}
