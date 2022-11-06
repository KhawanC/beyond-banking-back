package com.kaua.hrworker.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaua.hrworker.form.WorkerForm;
import com.kaua.hrworker.model.Worker;
import com.kaua.hrworker.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerResource {
	
	private static Logger LOG = LoggerFactory.getLogger(WorkerResource.class);
	
	@Autowired
	WorkerService workerService;
	
	@Autowired
	private Environment env;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return new ResponseEntity<>(workerService.findAllWorker(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		LOG.info("PORT = " + env.getProperty("local.server.port"));
		return new ResponseEntity<>(workerService.findWorkerById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Worker> createWorker(@RequestBody WorkerForm form) {
		return new ResponseEntity<>(workerService.saveWorker(form), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWorker(@PathVariable Long id) {
		workerService.deleteWorkerById(id);
		return new ResponseEntity<>("Worker deleted with sucess", HttpStatus.OK);
	}
}
