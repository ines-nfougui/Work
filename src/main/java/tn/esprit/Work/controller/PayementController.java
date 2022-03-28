package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.IService.IServicePublicite;
import tn.esprit.Work.Serice.PayementService;
import tn.esprit.Work.model.OrderStatus;
import tn.esprit.Work.model.Payement;
import tn.esprit.Work.model.PayementType;
import tn.esprit.Work.model.Publicite;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PayementController {
	@Autowired
	PayementService payementService;
	@Autowired
	IServicePublicite publiciteservice;

	

	@PutMapping("/modify-Payement")
	@ResponseBody
	public Payement modifyPayement(@RequestBody Payement pay) {
		return payementService.updatePayement(pay);
	}
	
	@PostMapping("/addp/{idu}/{idp}")
	@ResponseBody
	public Payement addPayement(Payement pay,@PathVariable("idu") long idu,@PathVariable("idp") long idp) {
		return payementService.addPayement(pay,idu,idp);
	}
	
	@GetMapping("/all-Payement")
	@ResponseBody
	public List<Payement> allPayement() {
		return (List<Payement>) payementService.retriveAllPayment();
	}

	@PostMapping("/purchase") 
	@ResponseBody 
	@Transactional
	public Object buyPublicite(@RequestParam("payementId") Long id) {
		Payement payement =payementService.findPayementById(id);

		Map<String, Object> responseDetails = new HashMap<>();
		if(payement==null)
			responseDetails.put("message", "payement does not exists");
		else{	
			Publicite publicite = payement.getPublicite();
			if(payement.getPayementType().equals(PayementType.Online)
					&& !payement.getStatus().equals(OrderStatus.Executed)) {
				String referenceExterne = payementService.callStripeAPIBuy(payement);
				if(referenceExterne != null)
				{
					payement.setStatus(OrderStatus.Executed);
					payement.setReferenceExterne(referenceExterne);
					payementService.updatePayement(payement);
					publiciteservice.updatePub(publicite);
					responseDetails.put("message", "payement effectué");
					responseDetails.put("payement", payement);
				}
				else
					responseDetails.put("message", "payement non abouti");

			}
			else
				responseDetails.put("message", "payement could not be executed");
		}

		return new ResponseEntity<>(responseDetails, HttpStatus.OK); 
	}

}
