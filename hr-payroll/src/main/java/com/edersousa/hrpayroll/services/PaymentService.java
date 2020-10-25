package com.edersousa.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersousa.hrpayroll.entities.Payment;
import com.edersousa.hrpayroll.entities.Worker;
import com.edersousa.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findbyId(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
