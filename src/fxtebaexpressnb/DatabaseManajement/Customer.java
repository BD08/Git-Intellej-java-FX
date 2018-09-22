package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableCustomer;
import java.sql.Connection;
import java.util.List;


public class Customer extends BD08EntytyFrameWork<TableCustomer>{

    private static final String ColomnId="Id";
    private static String ColomnTypePerusahaan="TypePerusahaan";
    private static String ColomnNama="Nama";
    private static String ColomnAlamat="Alamat";
    private static String ColomnKotaId="KotaId";
    private static String ColomnKecamatanId="KecamatanId";
    private static String ColomnPhoneNumber="PhoneNumber";
    private static String ColomnEmail="Email";
    private static String ColomnContactPersonInvoice="ContactPersonInvoice";
    private static String ColomnInvoiceMail="InvoiceMail";
    private static String ColomnCreateDate="CreateDate";
    private static String ColomnCreateBy="CreateBy";
    private static String ColomnModifyDate="ModifyDate";
    private static String ColomnModifyBy="ModifyBy";
    private Kota listKota;
    private Kecamatan listKecamatan;
    
    public Customer(Connection connection,Kota listKota,Kecamatan listKecamatan) {
        super("Customer", connection);
        this.listKota=listKota;
        this.listKecamatan=listKecamatan;
    }

    @Override
    protected void setDataList() throws Exception {
        TableCustomer item;
        while(resultSet.next()){
            item=new TableCustomer();
            item.setId(resultSet.getInt(ColomnId));
            item.setTypePerusahaan(resultSet.getString(ColomnTypePerusahaan));
            item.setNama(resultSet.getString(ColomnNama));
            item.setAlamat(resultSet.getString(ColomnAlamat));
            item.setKotaId(resultSet.getInt(ColomnKotaId));
            item.setKota(listKota.getEntityItem(item.getKotaId()));
            item.setKecamatanId(resultSet.getInt(ColomnKecamatanId));
            item.setKecamatan(listKecamatan.getEntityItem(item.getKecamatanId()));
            item.setPhoneNumber(resultSet.getString(ColomnPhoneNumber));
            item.setEmail(resultSet.getString(ColomnEmail));
            item.setContactPersonInvoice(resultSet.getString(ColomnContactPersonInvoice));
            item.setInvoiceMail(resultSet.getString(ColomnInvoiceMail));
            item.setCreateBy(resultSet.getInt(ColomnCreateBy));
            item.setCreateDate(resultSet.getString(ColomnCreateDate));
            item.setModifyBy(resultSet.getInt(ColomnModifyBy));
            item.setModifyDate(resultSet.getString(ColomnModifyDate));
            this.DataList.add(item);
        }
    }

    @Override
    protected void RowPlot(TableCustomer e) {
        this.dataRow.clear();
        dataRow.add(new ColoumnValue(ColomnId, e.getId(), true));
        dataRow.add(new ColoumnValue(ColomnTypePerusahaan, e.getTypePerusahaan()));
        dataRow.add(new ColoumnValue(ColomnNama, e.getNama()));
        dataRow.add(new ColoumnValue(ColomnAlamat, e.getAlamat()));
        dataRow.add(new ColoumnValue(ColomnKotaId, e.getKotaId()));
        dataRow.add(new ColoumnValue(ColomnKecamatanId, e.getKecamatanId()));
        dataRow.add(new ColoumnValue(ColomnPhoneNumber, e.getPhoneNumber()));
        dataRow.add(new ColoumnValue(ColomnEmail, e.getEmail()));
        dataRow.add(new ColoumnValue(ColomnContactPersonInvoice, e.getContactPersonInvoice()));
        dataRow.add(new ColoumnValue(ColomnInvoiceMail, e.getInvoiceMail()));
        dataRow.add(new ColoumnValue(ColomnCreateBy, e.getCreateBy()));
        dataRow.add(new ColoumnValue(ColomnCreateDate, e.getCreateDate()));
        dataRow.add(new ColoumnValue(ColomnModifyBy, e.getModifyBy()));
        dataRow.add(new ColoumnValue(ColomnModifyDate, e.getModifyDate()));  
    }

    @Override
    public TableCustomer getEntityItem(Object id) {
        TableCustomer customer=null;
        for (TableCustomer tableCustomer : getListDataFromDB()) {
            if(tableCustomer.getId()==(int)id){
                customer=tableCustomer;
                break;
            }                
        }
        return customer;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void newRowsIdPlot(TableCustomer e, Object o) {
        e.setId(o.hashCode());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
