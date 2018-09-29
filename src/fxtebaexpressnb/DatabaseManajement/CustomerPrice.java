package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCustomerPrice;

import java.sql.Connection;

public class CustomerPrice extends BD08EntytyFrameWork<TableCustomerPrice>{

    private static String ColomnCUSTOMERId="CustomerId";
    private static String ColomnTarifId="TarifId";
    private Tarif tarifs;
    public CustomerPrice(Connection connection,Tarif t) {
        super("CustomerPrice", connection);
        this.tarifs=t;
    }

    @Override
    protected void setDataList() throws Exception {
        TableCustomerPrice item;
        while(resultSet.next()){
            item=new TableCustomerPrice();
            item.setCustomerId(resultSet.getInt(ColomnCUSTOMERId));
            item.setTarifId(resultSet.getInt(ColomnTarifId));
            item.setTarif(tarifs.getEntityItem(item.getTarifId()));
            this.DataList.add(item);
        }
    }
    //Todo Harus ada Filter 
    @Override
    protected void RowPlot(TableCustomerPrice e) {
        this.dataRow.clear();
        this.dataRow.add(new ColoumnValue(ColomnCUSTOMERId, e.getCustomerId()));
        this.dataRow.add(new ColoumnValue(ColomnTarifId, e.getTarifId()));

    }
    /**
     * Table Harus ada IdCustomer 
     * kota tujuan
     * kota sebelum
     */
    @Override
    protected TableCustomerPrice getEntityItem(Object id) {
        TableCustomerPrice customerPrice=null;
        TableCustomerPrice tcp=(TableCustomerPrice)id;
        for (TableCustomerPrice tableCustomerPrice : getListDataFromDB()) {
            if(
                    tableCustomerPrice.getCustomerId()==tcp.getCustomerId()&&
                    tableCustomerPrice.getTarifId()==tcp.getTarifId()
                    
                    ){
                customerPrice=tableCustomerPrice;
                break;
            }
        }
        return customerPrice;
    }

    @Override
    protected void initializationFilterString(String filterString) {
//        this.addDefaultFilter(new FilterTable(Colo));
    }

    @Override
    protected void newRowsIdPlot(TableCustomerPrice e, Object o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public TableUse addRow(TableCustomerPrice e) throws Exception {
//        tarifs.addRow(e.getTarif());
//        e.setTarifId(e.getTarif().getId());
//        super.addRow(e); //To change body of generated methods, choose Tools | Templates.
//    }
    
//    @Override
//    public Object AddRow(TableCustomerPrice e) {
//        tarifs.AddRow(e.getTarif());
//        super.AddRow(e); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public void EditRow(TableCustomerPrice e) throws Exception {
//        tarifs.EditRow(e.getTarif());
//        super.EditRow(e); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
}
