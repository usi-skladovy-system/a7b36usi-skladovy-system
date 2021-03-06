package cz.a7b36usi.sklad.Controller.states.documents;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import cz.a7b36usi.sklad.Service.IDocumentService;
import cz.a7b36usi.sklad.Service.IProductService;
import cz.a7b36usi.sklad.gui.documentitems.DocumentItemsDataModel;
import cz.a7b36usi.sklad.gui.documentitems.ifaces.IDocumentItemsGUI;

@Component
public class DocumentItemState implements IDocumentItemState {

	static final Logger logger = Logger.getLogger(DocumentItemState.class);

	@Autowired
	private IDocumentItemsGUI orderEditForm;

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IDocumentService documentService;

	private DocumentItemsDataModel model;
	private DocumentDTO item;

	@PostConstruct
	public void registerModel() {
		orderEditForm.addListeners(this);
	}

	public void save() {
		MovementDTO movement = orderEditForm.getEditedMovementItem();

		movement.setDocument(documentService.getDocumentById(item.getId()));

		logger.debug("Save item " + movement.getId());
		documentService.saveMovement(movement);

		updateModel();
	}

	public void click(int index) {
		logger.debug("Edit item " + index);
		MovementDTO orderItem = model.getRowByIndex(index);
		orderEditForm.editMovementItem(orderItem);
	}

	public void deactivated(MainController controller, DocumentsState state) {
		orderEditForm.setVisible(false);
	}

	public void openDialog(MainController controller, DocumentsState state,
			DocumentDTO item) {

		this.item = item;

		if (updateModel()) {
			orderEditForm.setTableModel(model, productService.getAllProducts(), productService.getAllProductVersions(), productService.getAllWrappingTypes());
			orderEditForm.setVisible(true);
		}
	}

	private boolean updateModel() {

		if (item == null) {
			logger.error("Item is null!");
			return false;
		}

		List<MovementDTO> items = documentService.getAllDocumentsMovements(item
				.getId());
		if (items == null) {
			logger.error("Items is null!");
			return false;
		}

		if (model == null) {
			logger.debug("Create new model");
			model = new DocumentItemsDataModel(items);
		} else {
			logger.debug("Updating model");
			model.update(items);
		}

		return true;
	}

	public void delete() {

		MovementDTO movement = orderEditForm.getEditedMovementItem();
		logger.debug("Delete item " + movement.getId());
		documentService.removeMovement(movement.getId());
		updateModel();

	}

}
