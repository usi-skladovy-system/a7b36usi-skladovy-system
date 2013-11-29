package cz.a7b36usi.sklad.Controller.states;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.Controller.states.users.AddressBookDataModel;
import cz.a7b36usi.sklad.Service.IZakaznikService;

@Component
public class AddressBookState implements IControllerState{

	static final Logger logger = Logger.getLogger(AddressBookState.class);
	
	
	@Autowired
    private IZakaznikService zakaznikService;
	
	private AddressBookDataModel model;
	
	@PostConstruct
    public void registerModel() {
		model = new AddressBookDataModel(zakaznikService.getAllZakaznik());
	}
	
	public void activated(MainController controller) {
		logger.debug("Activated event");
		
		controller.getForm().setTableModel(model);
	}
	
	public void save(MainController controller) {
		logger.debug("Save event");
	}

	
	

}
