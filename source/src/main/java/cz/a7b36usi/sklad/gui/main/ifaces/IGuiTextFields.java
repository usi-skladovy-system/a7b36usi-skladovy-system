package cz.a7b36usi.sklad.gui.main.ifaces;

import java.util.List;

import javax.swing.JTextField;

/**
 * 
 * @author Lukas L.
 */
public interface IGuiTextFields {
	/**
	 * Gets address book text fields from form for validating
	 * 
	 * @return
	 */
	List<JTextField> getAddressBookTextFields();

	/**
	 * Gets user's text fields from form for validating
	 * 
	 * @return
	 */
	List<JTextField> getUsersTextFields();

	/**
	 * Gets order's text fields from form for validating
	 * 
	 * @return
	 */
	List<JTextField> getOrderTextFields();

	/**
	 * Gets document's text fields from form for validating
	 * 
	 * @return
	 */
	List<JTextField> getDocumentTextFields();

	/**
	 * Gets movement's text fields from form for validating
	 * 
	 * @return
	 */
	List<JTextField> getMovementTextFields();

	/**
	 * Gets product's text fields from form for validating
	 * 
	 * @return
	 */
	List<JTextField> getProductTextFields();

}
