package khan.cpm.fullstackcrudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FullstackCrudAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackCrudAppApplication.class, args);
	}
//	allow cors Origin
	@Bean
	public  WebMvcConfigurer  corsConfig(){
		return  new WebMvcConfigurer() {
			public void  addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("http://localhost:3000/");
			}
		};
	}

}
