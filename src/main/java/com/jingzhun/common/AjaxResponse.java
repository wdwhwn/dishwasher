package com.jingzhun.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class AjaxResponse extends HashMap<String,Object> {
	/*日志处理*/
	private static Logger logger = LoggerFactory.getLogger(AjaxResponse.class);
	public void setMessage(String message) {
		this.put("message",message);
	}

	public void setDirect(boolean direct) {
		this.put("direct",direct);
	}
	public void setDirectUrl(String directUrl) {
		this.put("directUrl",directUrl);
	}

	public void setData(Map data) {
		this.put("data",data);
	}

	public void  putData(String key,Object value){
		if(this.get("data")==null){
			setData(new HashMap());
		}
		Map response=(Map)this.get("data");
		response.put(key,value);

	}

	/**
	 * 完整请求,创建一个成功的返回类型
	 * @author zhangbin
	 * @date 2016 /02/19 12:23:40
	 * ajax response
	 * @param message the message
	 * @param data the object
	 * @return the ajax response
	 */
	public static AjaxResponse success(String message,Object data){

		AjaxResponse response = new AjaxResponse();
		response.put("message", message);
		response.put("data",data);
		response.put("code", HTTPResponseCode.SUCCESS);
		try {
			logger.info("请求完成，返回数据 {}",new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 简化的成功请求,返回对象必须传入
	 * @author zhangbin
	 * @date 2016 /02/19 12:23:59
	 * ajax response
	 * @param data the object
	 * @return the ajax response
	 */
	public static AjaxResponse success(Object data){
		AjaxResponse response = new AjaxResponse();
		response.put("message", "请求成功");
		response.put("data", data);
		response.put("code", HTTPResponseCode.SUCCESS);
		try {
			logger.info("请求完成，返回数据 {}",new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

	public static AjaxResponse success(){
		AjaxResponse response = new AjaxResponse();
		response.put("message", "请求成功");
		response.put("code", HTTPResponseCode.SUCCESS);
		try {
			logger.info("请求完成，返回数据 {}",new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
	/**返回arrayList
	 * @param data 数据
	 * @param total 符合条件的总条数
	 * @param currentPage 当前的页码
	 * @param pageSize 页面的大小
	 * */
	public static AjaxResponse array(Object data,int total,int pageSize,int currentPage){
		AjaxResponse response = new AjaxResponse();
		response.put("message", "请求成功");
		response.put("data",data);
		response.put("total",total);//总条数
		response.put("pageSize",pageSize);//页面大小
		response.put("currentPage",currentPage);
		response.put("code", HTTPResponseCode.SUCCESS);
		try {
			logger.info("请求完成，返回数据 {}",new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 创建一个简化的错误信息
	 * @author zhangbin
	 * @date 2016 /02/19 12:31:20
	 * ajax response
	 * @return the ajax response
	 */
	public static AjaxResponse error() {
		AjaxResponse response = new AjaxResponse();
		response.put("message", "请求失败");
		response.put("code", HTTPResponseCode.ERROR);
		try {
			logger.info("请求失败，返回数据 {}",new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

	public static AjaxResponse error(String message) {
		AjaxResponse response = new AjaxResponse();
		response.put("message", message);
		response.put("code", HTTPResponseCode.ERROR);
		try {
			logger.info("请求失败，返回数据 {}",new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
	public static AjaxResponse error(String message,int code) {
		AjaxResponse response = new AjaxResponse();
		response.put("message", message);
		response.put("code", code);
		try {
			logger.info("请求失败，返回数据 {}",new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
}
