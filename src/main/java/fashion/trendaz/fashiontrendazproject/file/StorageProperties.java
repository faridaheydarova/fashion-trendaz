package fashion.trendaz.fashiontrendazproject.file;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

	
	private String location = "upload-dir-fashion-trendaz-ajax";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
