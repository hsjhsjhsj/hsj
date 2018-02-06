package com.hushunjian.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hushunjian.domain.CmsUser;
import com.hushunjian.domain.CmsUserExample;
import com.hushunjian.mapper.CmsUserMapper;

@Service
public class CmsUserService {
	
	@Autowired
	private CmsUserMapper cmsUserMapper;

	public List<CmsUser> getAllUsersByPage(Long pageIndex, Long pageSize) {
		CmsUserExample example = new CmsUserExample();
		example.setOrderByClause("id asc limit " + (pageIndex-1)*pageSize + "," + pageSize);
		return cmsUserMapper.selectByExample(example);
	}

}
