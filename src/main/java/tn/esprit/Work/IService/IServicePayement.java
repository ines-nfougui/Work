package tn.esprit.Work.IService;


import java.util.List;

import tn.esprit.Work.model.Payement;

public interface IServicePayement {

	Payement addPayement(Payement payement,long idu,long idp);
	List<Payement> retriveAllPayment();
	Payement updatePayement(Payement payement);

	Payement findPayementById(long id);
	String callStripeAPIBuy(Payement payement);


}
