package cz.a7b36usi.sklad.Controller.states;

import org.apache.log4j.Logger;

import cz.a7b36usi.sklad.Controller.MainController;
import cz.a7b36usi.sklad.tableutils.BaseDataModel;

public class EmptyState implements IControllerState{
	static final Logger logger = Logger.getLogger(EmptyState.class);

	
	private BaseDataModel<Object> model;
	
	public EmptyState(){
		model = new BaseDataModel<Object>(null) {
			private static final long serialVersionUID = 3166346861380415669L;

			@Override
			public Object getColumnValue(Object row, int index) {
				return "";
			}
			
			@Override
			public int getRowCount() {
				return 0;
			}
			
			@Override
			public int getColumnCount() {
				return 0;
			}
			
		};
	}
	
	public void activated(MainController controller) {
		logger.debug("Activated event");
		controller.getForm().setTableModel(model);
	}
	
	public void save(MainController controller) {
		logger.warn("Save event");
	}
	
	
}
