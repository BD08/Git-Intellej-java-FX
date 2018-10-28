package fxtebaexpressnb.Utility;

import fxtebaexpressnb.View.TarifListControllerList;
import javafx.fxml.FXMLLoader;

public interface IControllViewDetailItem<E> {

	FileFXML select=FileFXML.CUSTOMER_LIST_VIEW;

	default void dataTable(BaseController base,FileFXML fileFXML) {
		FXMLLoader fxmlLoader;
		try{
			fxmlLoader=base.changeCenter(FileFXML.TARIF_LIST_VIEW);
			TarifListControllerList tarifListController=fxmlLoader.<TarifListControllerList>getController();
			tarifListController.disableMainMenu(BaseController.selectedMenu.Tarif);
			tarifListController.setBaseControllerModel(base.getBaseControllerModel());
			tarifListController.PageFistLoad();
		}catch (Exception ex){
			System.err.print("Tidak Bisa Load"+ex);
		}
	}

	default void dataTable(BaseController base){

	}

	/**
	 * Untuk Load Page Detail Untuk parsing data dan lain lain
	 */
	void PageLoad();

	/**
	 * untuk Load Page Detail dengan data yang sudah ada
	 *
	 * @param o PrimaryKey Yang dikirim
	 */
	void PageLoad(Object o);

	/**
	 * Untuk load Page Detail dengan Item yang sudah di ketahui
	 * @param e
	 */
	void PageItem(E e);

}
