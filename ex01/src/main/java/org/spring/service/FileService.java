package org.spring.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	public void saveFile(MultipartFile file, String destinationDir ) throws IOException {
//		File destination = new File(destinationDir+File.separator+file.getOriginalFilename());
		File destination = new File(destinationDir+File.separator);
		file.transferTo(destination);

	}
}
