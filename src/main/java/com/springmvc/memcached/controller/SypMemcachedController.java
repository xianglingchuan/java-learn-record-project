package com.springmvc.memcached.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.memcached.service.SpyMemcachedService;

import net.spy.memcached.MemcachedClient;

@Controller
@RequestMapping("/memcached/demo")
public class SypMemcachedController {

	@Resource(name = "memcachedClient")
	private MemcachedClient memcachedClient;

	public MemcachedClient getMemcachedClient() {
		return memcachedClient;
	}

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void home(Model model) {
		System.out.println("this.memcachedClient:" + this.memcachedClient.toString());
		System.out.println("set：" + this.memcachedClient.set("SpyMemcached", 9000, "hello memcached"));
		System.out.println("get：" + this.memcachedClient.get("SpyMemcached"));
		System.out.println("/memcached/demo/index");
	}

	@Autowired
	private SpyMemcachedService spyMemcachedService;

	@RequestMapping("add")
	public void add(HttpServletResponse response, HttpServletRequest request) {
		try {
			boolean flag = spyMemcachedService.add("key1", "add", 1000);
			if (flag) {
				this.responseText("add成功,key=key1,value=add", response);
			} else {
				this.responseText("add失败！", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("get")
	public void get(HttpServletResponse response, HttpServletRequest request) {
		try {
			Object val = spyMemcachedService.get("key1");
			this.responseText("get,key=key1,value=" + val, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("replace")
	public void replace(HttpServletResponse response, HttpServletRequest request) {
		try {
			boolean flag = spyMemcachedService.replace("key1", "replace", 1000);
			if (flag) {
				this.responseText("replace成功,key=key1,value=replace", response);
			} else {
				this.responseText("replace失败！", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("set")
	public void set(HttpServletResponse response, HttpServletRequest request) {
		try {
			boolean flag = spyMemcachedService.set("key1", "set", 1000);
			if (flag) {
				this.responseText("set成功,key=key1,value=set", response);
			} else {
				this.responseText("set失败！", response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 响应字符串 用于ajax请求响应
	 * 
	 * @param str
	 * @throws Exception
	 */
	public void responseText(String str, HttpServletResponse reponse) throws Exception {
		reponse.setContentType("text/html;charset=UTF-8");
		PrintWriter out = reponse.getWriter();
		out.write(str);
		out.flush();
		out.close();
	}

}
