package com.kaua.hrworker.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.kaua.hrworker.convert.WorkerConverter;
import com.kaua.hrworker.form.WorkerForm;
import com.kaua.hrworker.model.Worker;
import com.kaua.hrworker.repository.WorkerRepository;

@Service
public class WorkerService {

	private WorkerRepository repository;
	private WorkerConverter converter;

	public WorkerService(WorkerRepository workerRepository, WorkerConverter converter) {
		this.repository = workerRepository;
		this.converter = converter;
	}

	public List<Worker> findAllWorker() {
		return repository.findAll();
	}

	public Worker findWorkerById(Long id) {
		return repository.findById(id).get();
	}

	public Worker saveWorker(WorkerForm form) {
		return repository.save(converter.WorkerFormToWorker(form));
	}

	public void deleteWorkerById(Long id) {
		repository.deleteById(id);
	}
}
