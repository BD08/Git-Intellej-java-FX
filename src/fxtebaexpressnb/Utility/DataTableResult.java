package fxtebaexpressnb.Utility;

import java.util.List;

public class DataTableResult<E> {

	private List<E> dataResult;
	private int dataRow;
	private int dataTotalPage;
	private int currentPage;

	public List<E> getDataResult() {
		return dataResult;
	}

	public void setDataResult(List<E> dataResult) {
		this.dataResult = dataResult;
	}

	public int getTotalDataRow() {
		return dataRow;
	}

	public void setTotalDataRow(int dataRow) {
		this.dataRow = dataRow;
	}

	public int getDataTotalPage() {
		return dataTotalPage;
	}

	public void setDataTotalPage(int dataTotalPage) {
		this.dataTotalPage = dataTotalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
