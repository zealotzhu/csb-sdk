package com.alibaba.csb.sdk;

/**
 * 设置HTTP传输的body内容，可以是Json String或者是byte[]格式
 * 
 * @author Alibaba Middleware CSB Team
 * @author liaotian.wq 
 * @since 2016
 */
public class ContentBody {
	/**
	 * 指定ContentBody的类型
	 *
	 */
	public static enum Type {
		JSON("application/json"), BINARY("application/octet-stream");
		
		private String ct;
		
		private Type(String ct) {
			this.ct = ct;
		}
		
		public String getContentType() {
			return ct;
		}
	}
	
	private String jsonBody ;
	private byte[] bytesBody ;
	private Type type;
	
	/**
	 * 使用Json串构造ContentBody
	 * @param jsonStr
	 */
	public ContentBody(String jsonStr) {
		this.jsonBody = jsonStr;
		type = Type.JSON;
	}
	
	/**
	 * 使用byte数组构造ContentBody
	 * @param bytes
	 */
	public ContentBody(byte[] bytes) {
		this.bytesBody = bytes;
		type = Type.BINARY;
	}
	
	public Type getContentType() {
		return this.type;
	}
	
	public Object getContentBody() {
		if (type ==  Type.BINARY)
			return bytesBody;
		else
			return jsonBody;
	}
}
