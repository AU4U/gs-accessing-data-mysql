package com.example.accessingdatamysql.file;

import com.example.accessingdatamysql.storage.StorageFileNotFoundException;
import com.example.accessingdatamysql.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {

	private final StorageService storageService;

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	@GetMapping("file_test")
	public String listUploadedFiles(Model model) throws IOException {
		model.addAttribute("files", storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()));
		return "uploadForm";
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		if (file == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}

	/**
	 * 单个文件上传
	 * @param file  文件
	 * @return 重定向到上传成功页面
	 */
	@PostMapping("/file")
	public @ResponseBody ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		FileDTO fileUrls = storageService.store(file);
		Map<String, Object> responseBody = new HashMap<>();
		responseBody.put("fileInfo", fileUrls);
		return new ResponseEntity<>(responseBody,HttpStatus.OK);
	}

	@PostMapping("/files")
	public @ResponseBody ResponseEntity<?> handleFilesUpload(@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file : files) {
			storageService.store(file);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/files")
	public @ResponseBody ResponseEntity<?> listUploadedFiles() throws IOException {
		return new ResponseEntity<>(storageService.loadAll().map(
				path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
						"serveFile", path.getFileName().toString()).build().toUri().toString())
				.collect(Collectors.toList()), HttpStatus.OK);
	}
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
