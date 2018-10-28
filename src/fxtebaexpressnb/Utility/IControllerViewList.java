package fxtebaexpressnb.Utility;

public interface IControllerViewList<E> {
	/**
	 * Untuk Load Data Dan harus Memanggil List yang harus di buat di Controller
	 * seperti load database dan di plot pada list
	 * */
	void getDataForTable();

	/**
	 * untuk memuat select data yang di ambil langsung dari list saja jangan dari database
	 * @return Item yang di pilih
	 */
	E getSinggleSelectData(int rowSelect);
}
