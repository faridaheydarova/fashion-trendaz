package fashion.trendaz.fashiontrendazproject.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fashion.trendaz.fashiontrendazproject.FashionTrendazProjectApplication;

//burada olan ayarlar proyektin war file olaraq export olunasi uxun nexerde tutulur
@SpringBootApplication
@RestController
public class ServletInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(FashionTrendazProjectApplication.class);
	}
	
	@RequestMapping(value = "/hello")
	public String helloWorld()
	{
	return "Hello";
	}
}