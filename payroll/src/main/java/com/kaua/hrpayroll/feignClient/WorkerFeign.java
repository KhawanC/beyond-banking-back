package com.kaua.hrpayroll.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kaua.hrpayroll.dto.WorkerResponse;

@Component
@FeignClient(name = "hr-worker", path = "/worker")
public interface WorkerFeign {

	@GetMapping("{id}")
	ResponseEntity<WorkerResponse> findById(@PathVariable Long id);
}
