package com.packt.webstore.exception;

import org.springframework.stereotype.Component;

@Component
public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -694354952032299587L;
	
	private String productId;
	private String message = "Product Not Found for this ID ";
	
//	@Autowired
//	private ReloadableResourceBundleMessageSource messages;

////	@Autowired
//	public void setMessageSource(MessageSource messageSource) {
//	  this.messageSource = (ReloadableResourceBundleMessageSource((DelegatingMessageSource)messageSource).getParentMessageSource();
//	}
	
//	@Autowired
//	MessageSource messages;
	
	public ProductNotFoundException() {}
	
	public ProductNotFoundException(String productId, String message) {
		this.productId = productId;
		Object[] parameters= {productId};
		
		if (message != null) this.message = message;

//		String exMessage = this.messages.getMessage(message, parameters,  null);		
		
		
	}
	
	public String getFullMessage() {
		return (message + productId);
	}
	
	public String getProductId() {
		return productId;
	}
	


}
