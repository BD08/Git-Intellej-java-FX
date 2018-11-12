package fxtebaexpressnb.Utility;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.*;

public class DataTableResult<E> {

	public DataTableResult(){
		this.sizePage=StaticValue.bucketSize;
	}
	private List<E> dataResult;

	private int dataRow;
	private int dataTotalPage;
	private int currentPage;
	private int sizePage;

	/***
	 * get Data Row Berbentuk List
	 * @return list
	 */
	public List<E> getDataResult() {
		return dataResult;
	}

	/***
	 * Membuat data Result nya
	 * @param dataResult result yang ingin di setting
	 */
	public void setDataResult(List<E> dataResult) {
		if(this.dataResult==null)
			this.dataResult=new ArrayList<>();
		this.dataResult = dataResult;
	}

	/***
	 * Untuk total row nya yang tersedia
	 * @return total row yang tersedia di dalam getdataResult
	 */
	public int getTotalDataRow() {
		return dataRow;
	}

	/**
	 * untuk mengatur data total setelah di select degnan BD08MappingDAtabase
	 * @param dataRow data total row nya
	 */
	public void setTotalDataRow(int dataRow) {
		int calculateTotalPage=dataRow%this.getSizePage();
		this.setDataTotalPage(calculateTotalPage);
		this.setCurrentPage(0);
		this.dataRow = dataRow;
	}

	/**
	 * dmendapatkan data total page yang tersedia dari sql tersebut
	 * @return banyak page
	 */
	public int getDataTotalPage() {
		return dataTotalPage;
	}

	/**
	 * mengatur total page nya
	 * @param dataTotalPage Total Page
	 */
	public void setDataTotalPage(int dataTotalPage) {
		this.dataTotalPage = dataTotalPage;
	}

	/**
	 * get cureent page
	 * @return Page sekarang
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * setting page sekarang
	 * @param currentPage page sekarang
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * untuk atur page nambah satu
	 */
	public void nextPage(){
		this.currentPage++;
	}

	/**
	 * untuk kembali ke page sebelumnya
	 */
	public void previousPage(){
		this.currentPage--;
	}

	/**
	 * untuk kembali ke halaman pertama
	 */
	public void firstPage(){
		this.currentPage=0;
	}

	/**
	 * untuk ke halaman terakhir
	 */
	public void lastPage(){
		this.currentPage=dataTotalPage;
	}

	/**
	 * mendapatkan total row yang tersedia
	 * @return ROW yang tersedia
	 */
	public int getDataRow() {
		return dataRow;
	}

	/**
	 * setting total row yang tersedia
	 * @param dataRow total row yang tersedia
	 */
	public void setDataRow(int dataRow) {
		this.dataRow = dataRow;
	}

	/**
	 * untuk mendapatkan berapa row yang tersedia dalam satu page
	 * @return page size yang tersedia
	 */
	public int getSizePage() {
		return sizePage;
	}

	/**
	 * mengatur banyak data yang tersedia dalam 1 halaman
	 * @param sizePage page size yang
	 */
	public void setSizePage(int sizePage) {
		this.sizePage = sizePage;
	}

	/**
	 * untuk mendapatkan limit min
	 * @return
	 */
	public int getLimitMIN(){
		return this.currentPage*this.sizePage;
	}

	/**
	 * untuk mendapatkan limit max
	 * @return
	 */
	public int getLimitMAX(){
		if(this.currentPage+1<=this.dataTotalPage)
			return this.currentPage+1*this.sizePage;
		else
			return this.dataRow;
	}

	/**
	 * untuk mendapatkan Observable List
	 * @return
	 */
	public ObservableList<E> getObservableList(){
		ObservableList<E> dummyData = FXCollections.observableArrayList();
		if(dataResult!=null){
			dataResult.forEach(e -> dummyData.add(e));
		}
		return dummyData;
	}
}
