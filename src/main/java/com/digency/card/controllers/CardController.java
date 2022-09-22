package com.digency.card.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digency.card.dto.User;
import com.digency.card.services.QRCodeGenerator;


@RestController
public class CardController {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/qr.png";
	private static final String PHOTO_PROFIL_PATH = "./src/main/resources/static/img/profil.png";

	@PostMapping(value = "/genrateAndDownloadQRCode")
	public ResponseEntity<User> download(@RequestBody User user) throws Exception {
		QRCodeGenerator.generateQRCodeImage(user, 250, 250, QR_CODE_IMAGE_PATH);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping(path = "/uploadPhoto")
	public void uploadPhoto(MultipartFile file) throws IOException {
		Files.write(Paths.get(PHOTO_PROFIL_PATH), file.getBytes());
	}
	
//	@PostMapping(path = "/uploadPhoto" ,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//	public void uploadPhoto(@RequestPart("file") MultipartFile file,
//			                @RequestPart("user") User user ) throws IOException {
//	}

}