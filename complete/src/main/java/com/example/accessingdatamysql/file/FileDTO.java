package com.example.accessingdatamysql.file;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FileDTO {
    //private String fileName;
    private String orgName;
    private String fileDownloadUri;
    private String extension;
    private long timestamp;
}
