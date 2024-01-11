package fashion.trendaz.fashiontrendazproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import fashion.trendaz.fashiontrendazproject.file.StorageProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@ComponentScan(basePackages = "fashion.trendaz.fashiontrendazproject")

public class FashionTrendazProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FashionTrendazProjectApplication.class, args);
	}

}
