package com.wiley.gr.ace.authorservices.model;

/**
 * This is the generic service VO object which is returned by every service.
 * Data from the service is wrapped into this and returned.
 * 
 * @author SarmaKumarap
 *
 */
public class ServiceVO {
	
	private String status;
	
	private Object serviceObject;
	
	private ErrorVO errorVO;

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public Object getServiceObject() {
		return serviceObject;
	}

	/**
	 * @param serviceObject
	 */
	public void setServiceObject(Object serviceObject) {
		this.serviceObject = serviceObject;
	}

	/**
	 * @return
	 */
	public ErrorVO getErrorVO() {
		return errorVO;
	}

	/**
	 * @param errorVO
	 */
	public void setErrorVO(ErrorVO errorVO) {
		this.errorVO = errorVO;
	}
	
	

}
