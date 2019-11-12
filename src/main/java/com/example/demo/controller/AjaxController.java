package com.example.demo.controller;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CommonHeader;
import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.dto.ProductResponseBody;
import com.example.demo.vo.Product;




@Controller
public class AjaxController {
	

	
	@RequestMapping(value = "/prod",method = RequestMethod.GET)
	public String prod() {
		
		return "AjaxTest.html";
		
	}
	
	@RequestMapping(value = "/prod/ajax",method = RequestMethod.POST)
	@ResponseBody
	public ProductResponse prod(@RequestBody ProductRequest request) {
		ProductResponse response = new ProductResponse();
		ProductResponseBody responseBody = new ProductResponseBody();
		
		CommonHeader header = new CommonHeader();
		BeanUtils.copyProperties(request.getHeader(), header);
		response.setHeader(header);
		responseBody.setProductId(request.getBody().getProductId());
//		ProductResponse productrespon = productService.findByProductId(request.getBody().getProductId());
//		BeanUtils.copyProperties(productrespon, responseBody);
		response.setBody(responseBody);
		return response;
		
		
	}
}
