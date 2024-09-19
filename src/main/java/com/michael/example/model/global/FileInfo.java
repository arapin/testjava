package com.michael.example.model.global;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class FileInfo {
	private String fileExtension;
	private String fileOriginalName;
	private String fileName;
	private String filePath;
	private String filePathName;

	@Builder
	public FileInfo(String fileExtension, String fileOriginalName, String fileName, String filePath,
		String filePathName) {
		this.fileExtension = fileExtension;
		this.fileOriginalName = fileOriginalName;
		this.fileName = fileName;
		this.filePath = filePath;
		this.filePathName = filePathName;
	}
}
