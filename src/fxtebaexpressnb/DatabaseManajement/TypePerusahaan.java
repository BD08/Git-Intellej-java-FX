package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableKodeMaster;
import fxtebaexpressnb.Utility.CODE_MASTER;
import fxtebaexpressnb.Utility.FilterParameter;

import java.sql.Connection;

public class TypePerusahaan extends BD08EntytyFrameWork<TableKodeMaster> {
	private static String Id="Id";
	private static String Type="Type";
	private static String Code="Code";
	private static String Name="Name";

	public TypePerusahaan(Connection connection) {
		super("KodeMaster", connection);
		addDefaultFilter(new FilterTable(this.Type, FilterParameter.SAMA_DENGAN, CODE_MASTER.TYPE_PERUSAHAAN.toString()));
	}

	@Override
	protected void setDataList() throws Exception {
		TableKodeMaster item;
		while (resultSet.next()){
			item=new TableKodeMaster();
			item.setId(resultSet.getInt(this.Id));
			item.setName(resultSet.getString(this.Name));
		}
	}

	@Override
	protected void newRowsIdPlot(TableKodeMaster tableKodeMaster, Object o) {

	}

	/**
	 * Plot Untuk Row Yang akan di mappring ke database
	 *
	 * @param tableKodeMaster
	 */
	@Override
	protected void RowPlot(TableKodeMaster tableKodeMaster) {
		this.dataRow.clear();
		this.dataRow.add(new ColoumnValue(this.Id,tableKodeMaster.getId(),true));
		this.dataRow.add(new ColoumnValue(this.Name,tableKodeMaster.getName()));
		this.dataRow.add(new ColoumnValue(this.Type,CODE_MASTER.TYPE_PERUSAHAAN.toString()));
	}

	/**
	 * Pencarian dengan Primary Key
	 *
	 * @param id
	 * @return item yang dipilih
	 */
	@Override
	public TableKodeMaster getEntityItem(Object id) {
		TableKodeMaster tableKodeMaster=null;
		for (TableKodeMaster item: this.getListDataFromDB()) {
			if(item.getId()==id.hashCode()) {
				tableKodeMaster = item;
				break;
			}
		}
		return tableKodeMaster;
	}

	/**
	 * hanya Untuk Code Master ada Semua
	 * @param Name
	 * @return
	 */
	public TableKodeMaster getEntityItem(String Name){
		TableKodeMaster tableKodeMaster=null;
		for (TableKodeMaster item: this.getListDataFromDB()) {
			if(item.getName().equals(Name)) {
				tableKodeMaster = item;
				break;
			}
		}
		return tableKodeMaster;
	}



	@Override
	protected void initializationFilterString(String filterString) {

	}
}
