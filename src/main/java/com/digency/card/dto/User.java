package com.digency.card.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data 
public class User {
	
	private String nomFr;
	private String nomAr;
	private String prenomFr;
	private String prenomAr;
	private String cin;
	private String profession;
	private LocalDate dateNaissance;
	private String typeCarte;
	private String image;
	private String qrCode;
	
}
