package com.michael.example.util;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.michael.example.constant.GlobalConstants;
import com.michael.example.enumeration.http.ResponseStatus;
import com.michael.example.exception.ApiException;
import com.michael.example.model.global.FileInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUtil {

	/**
	 * Searches for a file at the specified file path and returns the contents of the file as a Base64-encoded string.
	 *
	 * @param filePath the file path of the file to search for
	 * @return the contents of the file as a Base64-encoded string, or null if the file is not found or an error occurs
	 */
	public static String searchFile(String filePath){
		File file = new File(filePath);
		String fileBytes;

		if(!file.isFile()){
			throw new ApiException(ResponseStatus.FILE_DATA_NOT_FOUND);
		}

		try {
			fileBytes = Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath()));
		}catch (Exception e){
			throw new ApiException(ResponseStatus.FILE_DATA_NOT_FOUND);
		}

		return fileBytes;
	}

	/**
	 * Saves the provided file to the file system.
	 *
	 * @param file the file to be saved
	 * @return the FileInfo object containing information about the saved file
	 */
	public static FileInfo saveFile(MultipartFile file, String parentPath, long customerId, String step){
		LocalDateTime today = LocalDateTime.now();
		String originalFileName = file.getOriginalFilename();
		String fileExtension = FilenameUtils.getExtension(originalFileName);
		String newFileFirstName = today.format(DateTimeFormatter.ofPattern(GlobalConstants.dateFileNameFormat));
		String newFileSecName = String.format("%08d", customerId);
		String newFileName = String.format("%s_%s_%s",newFileFirstName ,newFileSecName, step);

		String datePath = today.format(DateTimeFormatter.ofPattern(GlobalConstants.datePathNameFormat));
		String fullPath = File.separator + datePath;

		Path filePath = Path.of(parentPath, fullPath + File.separator + newFileName);
		Path folderPath = Path.of(parentPath, fullPath);
		File oldFile = new File(filePath.toString());

		// 기존 파일 삭제
		if(oldFile.isFile()){
			boolean deleted = oldFile.delete();

			if(deleted){
				log.info("{} : 이전 파일이 삭제 되었습니다.", filePath.toString());
			}
		}

		try {
			Files.createDirectories(folderPath);
			Files.copy(file.getInputStream(), filePath);

			return FileInfo.builder()
				.fileExtension(fileExtension)
				.fileName(newFileName)
				.fileOriginalName(originalFileName)
				.filePathName(datePath)
				.filePath(datePath + "/" + newFileName)
				.build();
		}catch (Exception e){
			log.error("message : {}", e.getMessage());
			throw new ApiException(ResponseStatus.FILE_SAVE_FAILURE);
		}
	}
}
