package com.sopromadze.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopromadze.dao.ResultDao;
import com.sopromadze.entities.Result;

@Service
public class ResultServiceImpl implements ResultService {
	@Autowired
	private ResultDao resultDao;
	
	@Override
	public void saveResult(Result result) {
		resultDao.saveResult(result);
	}
}
