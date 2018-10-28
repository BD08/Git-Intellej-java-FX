package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.RelationViewTransactionList.PengirimanTransactionModel;
import fxtebaexpressnb.Utility.DataTableResult;

import java.sql.Connection;

/**
 * Untuk Class Ini hanya untuk menampilkan saja
 */
public class PengirimanTransactionInfo extends BD08EntytyFrameWork<PengirimanTransactionModel> {

	public PengirimanTransactionInfo(Connection connection) {
		super("", connection);
	}

	@Override
	protected void setDataList() throws Exception {
		PengirimanTransactionModel item;
		while(resultSet.next()){
			item=new PengirimanTransactionModel();
			item.setNamaPembawa(resultSet.getString(PengirimanTransactionModel.CHECKPOINTNAME_CLOUMN));
			item.setNamaPengirim(resultSet.getString(PengirimanTransactionModel.NAMAPENGIRIM_COLOUMN));
			item.setNamaPenerima(resultSet.getString(PengirimanTransactionModel.NAMAPENERIMA_COLOUMN));
			item.setAlamatPengirim(resultSet.getString(PengirimanTransactionModel.ALAMATPENGIRIM_COLOUMN));
			item.setAlamatPenerima(resultSet.getString(PengirimanTransactionModel.ALAMATPENERIMA_COLOUMN));
			item.setIdCheckPoint(resultSet.getInt(PengirimanTransactionModel.IDCHECKPOINT_COLOUMN));
			item.setIdTransaction(resultSet.getInt(PengirimanTransactionModel.IDTRANSACTION_COLOUMN));
		}
	}

	@Override
	protected void newRowsIdPlot(PengirimanTransactionModel pengirimanTransactionModel, Object o) {
		pengirimanTransactionModel.setIdCheckPoint(o.hashCode());
	}

	/**
	 * Plot Untuk Row Yang akan di mappring ke database
	 *
	 * @param pengirimanTransactionModel
	 */
	@Override
	protected void RowPlot(PengirimanTransactionModel pengirimanTransactionModel) {
//		dataRow.add(new ColoumnValue())
//		dataRow.add(new )
	}

	/**
	 * Pencarian dengan Primary Key
	 *
	 * @param id
	 * @return item yang dipilih
	 */
	@Override
	public PengirimanTransactionModel getEntityItem(Object id) {
		PengirimanTransactionModel res=null;
		if(DataList!=null){
			if(DataList.size()>0)
				res= DataList.stream().filter(pengirimanTransactionModel -> pengirimanTransactionModel.getIdCheckPoint()==(int)id).findFirst().get();
		}
		if(res==null)
			try {
				String sqlString="SELECT * FROM Checkpoint WHERE ";
				DataTableResult data=this.getDataSQLAll(sqlString);
				if(data.getTotalDataRow()>0)
					res= (PengirimanTransactionModel) data.getDataResult().get(0);
			}catch (Exception ex){
				System.err.println("Pengiriman data Error Get EntityItem "+ ex);
			}
		return res;
	}

	@Override
	protected void initializationFilterString(String filterString) {

	}
}
