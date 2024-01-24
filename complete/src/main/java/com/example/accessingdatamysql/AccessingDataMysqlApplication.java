package com.example.accessingdatamysql;

import com.example.accessingdatamysql.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.File;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AccessingDataMysqlApplication {

	public static void main(String[] args) {
		//当前文件夹下是否有upload-dir文件夹，没有则创建
		//文件连接符号在java中用那个类来表示
		//
		File file = new File("."+File.separator+"upload-dir");
		if (!file.exists()) {
			file.mkdir();
		}
		SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}
}
