package com.hushunjian.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hushunjian.domain.CmsUser;
import com.hushunjian.service.CmsUserService;

@RestController
@Transactional
@RequestMapping("/api/cms")
public class CmsUserController extends BaseController {
	
	@Autowired
	private CmsUserService service;   
	
    @ResponseBody
    @RequestMapping(value = "getAllUsers")
	public Object getAllUsers(@NotNull @RequestParam Long pageIndex,
							  @NotNull @RequestParam Long pageSize){
    	List<CmsUser> cmsUsers = service.getAllUsersByPage(pageIndex,pageSize);
		return success(cmsUsers);
	}
}
