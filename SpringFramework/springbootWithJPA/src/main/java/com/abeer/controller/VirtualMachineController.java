package com.abeer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abeer.Exception.*;
import com.abeer.model.*;
import com.abeer.repository.*;


@RestController 
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class VirtualMachineController {
	@Autowired
    private VirtualMachinesRepository virtualMachinesRopository;
	@GetMapping("/vm")
    public List<VirtualMachine> getAllEmployees() {
        return virtualMachinesRopository.findAll();
    }
	 @GetMapping("/vm/{id}")
	    public ResponseEntity<VirtualMachine> getEmployeeById(@PathVariable(value = "id") Long vmId)
	        throws ResourceNotFoundException {
		 VirtualMachine vm = virtualMachinesRopository.findById(vmId)
	          .orElseThrow(() -> new ResourceNotFoundException("VM not found for this id :: " + vmId));
	        return ResponseEntity.ok().body(vm);
	 }
	 @PostMapping("/vm")
	    public VirtualMachine createVirtualMachine(@Valid @RequestBody VirtualMachine vm) {
	        return virtualMachinesRopository.save(vm);
	 }
	 @PutMapping("/vm/{id}")
	 public ResponseEntity<VirtualMachine> updateVirtualmachine(@PathVariable(value = "id") Long vmId,
	     @Valid @RequestBody VirtualMachine virtualMachineDetails) throws ResourceNotFoundException {
		 VirtualMachine vm = virtualMachinesRopository.findById(vmId)
	        .orElseThrow(() -> new ResourceNotFoundException("VM not found for this id :: " + vmId));
	       
		 vm.setIp(virtualMachineDetails.getIp());
	     vm.setUsername(virtualMachineDetails.getUsername());
	     vm.setPassword(virtualMachineDetails.getPassword());
	     final VirtualMachine updatedVirtualMachine = virtualMachinesRopository.save(vm);
	     return ResponseEntity.ok(updatedVirtualMachine);
	  }
	    @DeleteMapping("/vm/{id}")
	    public Map<String, Boolean> deleteVirtualMachine(@PathVariable(value = "id") Long vmId)
	         throws ResourceNotFoundException {
	    	VirtualMachine vm = virtualMachinesRopository.findById(vmId)
	       .orElseThrow(() -> new ResourceNotFoundException("Virtual Machine not found for this id :: " + vmId));

	    	virtualMachinesRopository.delete(vm);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }

}
