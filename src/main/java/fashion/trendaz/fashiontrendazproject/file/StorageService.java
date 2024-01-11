package fashion.trendaz.fashiontrendazproject.file;

import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
	void init();//eger yoxdursa qovluq yaradir
	String store(MultipartFile file);//fayli yadda saxlayib adini qaytarir
	Path load(String filename);//faylin adina gore path qaytarir
	Resource loadAsResource(String filename);//faylin ozunu qaytarir
	void deleteAll();//silinme
}
