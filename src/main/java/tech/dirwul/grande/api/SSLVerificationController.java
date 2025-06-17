package tech.dirwul.grande.api;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
public class SSLVerificationController {

	private static final String VALIDATION_FILE_NAME = "888F9632D9BF77FDB32A35382A04C7A6.txt";
	private static final String VALIDATION_PATH = "/.well-known/pki-validation/" + VALIDATION_FILE_NAME;

	@GetMapping(VALIDATION_PATH)
	public ResponseEntity<ByteArrayResource> verify() throws IOException {
		ClassPathResource resource = new ClassPathResource("static/" + VALIDATION_FILE_NAME);
		byte[] contentBytes = Files.readAllBytes(resource.getFile().toPath());
		ByteArrayResource byteArrayResource = new ByteArrayResource(contentBytes);

		return ResponseEntity.ok()
			.contentType(MediaType.parseMediaType("application/octet-stream"))
			.contentLength(contentBytes.length)
			.contentType(MediaType.TEXT_PLAIN)
			.body(byteArrayResource);
	}

}
