package fashion.trendaz.fashiontrendazproject.exception;

import org.springframework.validation.BindingResult;

public class MyRuntimeException {
	private static final long serialVersionUID = 1L;
	private BindingResult result;
	public BindingResult getResult() {
		return result;
	}
}
