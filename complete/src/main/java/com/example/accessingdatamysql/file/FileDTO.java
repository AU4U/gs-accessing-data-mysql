package com.example.accessingdatamysql.file;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FileDTO {
    //private String fileName;
    /**
     * 文件原始名称
     */
    private String orgName;
    /**
     * 文件下载地址
     */
    private String fileDownloadUri;
    /**
     * 文件类型
     */
    private String extension;
    /**
     * 时间戳
     */
    private long timestamp;
}
