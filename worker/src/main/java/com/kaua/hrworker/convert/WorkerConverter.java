package com.kaua.hrworker.convert;

import org.springframework.stereotype.Service;

import com.kaua.hrworker.form.WorkerForm;
import com.kaua.hrworker.model.Worker;

@Service
public class WorkerConverter {

	public Worker WorkerFormToWorker(WorkerForm form) {
		Worker worker = new Worker();
		
		worker.setDailyIncome(form.getDailyIncome());
		worker.setName(form.getName());
		
		return worker;
	}
}
