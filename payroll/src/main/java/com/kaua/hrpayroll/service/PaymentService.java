package com.kaua.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaua.hrpayroll.dto.WorkerResponse;
import com.kaua.hrpayroll.feignClient.WorkerFeign;
import com.kaua.hrpayroll.model.Payment;

@Service
public class PaymentService {

	@Autowired
	WorkerFeign workerFeign;

	public Payment findPayment(Long workerId, Integer days) {

		WorkerResponse worker = workerFeign.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
