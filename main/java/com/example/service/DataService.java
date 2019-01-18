package com.example.service;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Data;
import com.example.persistence.DaoDataImpl;

@Service
public class DataService {
	@Autowired
	DaoDataImpl daoData;
	
	@Transactional
	public void addData(Data data) {
		daoData.addData(data);
	}
}
