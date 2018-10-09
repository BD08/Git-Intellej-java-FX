/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement;

import fxtebaexpressnb.DatabaseManajement.TableEntity.TableColoumnName;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTarif;
import java.sql.Connection;

/**
 *
 * @author AsusX450J
 */
public class Tarif extends BD08EntytyFrameWork<TableTarif>{
    
    //<editor-fold defaultstate="collapsed" desc="Colomn Inilisiation Cara Lama">
    /**
     * seharusnya Di taruh di class nya jadi satu tidak usah di inialisasi lagi
     */
    private final static String ColomnId=TableColoumnName.TarifTable.COLOMN_ID;
    private final static String ColomnKotaFromId=TableColoumnName.TarifTable.COLOMN_KOTA_FROM_ID;
    private final static String ColomnKecamatanFromId=TableColoumnName.TarifTable.COLOMN_KECAMATAN_FROM_ID;
    private final static String ColomnKotaToId=TableColoumnName.TarifTable.COLOMN_KOTA_TO_ID;
    private final static String ColomnKecamatanToId=TableColoumnName.TarifTable.COLOMN_KECAMATAN_TO_ID;
    private final static String ColomnHargaPerKilo=TableColoumnName.TarifTable.COLOMN_HARGA_PER_KILO;
    private final static String ColomnHargaPerKoli = TableColoumnName.TarifTable.COLOMN_HARGA_PER_KOLI;
    private final static String ColomnCreateDate=TableColoumnName.TarifTable.COLOMN_CREATE_DATE;
    private final static String ColomnCreateBy=TableColoumnName.TarifTable.COLOMN_CREATE_BY;
    private final static String ColomnModifyDate = TableColoumnName.TarifTable.COLOMN_MODIFY_DATE;
    private final static String ColomnModifyBy=TableColoumnName.TarifTable.COLOMN_MODIFY_BY;
//</editor-fold>
    
    
    private Kecamatan kecamatans;
    private Kota kotas;
    
    public Tarif(Connection connection,Kecamatan kecamatan,Kota kota) {
        super("Tarif", connection);
        this.kecamatans=kecamatan;
        this.kotas=kota;
    }

    public Tarif(Connection connection){
        super("Tarif",connection);
    }
    
    public Tarif(Kecamatan kecamatan,Connection connection,Kota kota) {
        super("Tarif", connection);
        this.kecamatans=kecamatan;
        this.kotas=kota;
    }
    
    @Override
    protected void setDataList() throws Exception {
        TableTarif tableTarif;
        while(resultSet.next()){
            tableTarif=new TableTarif();
            tableTarif.setId(resultSet.getInt(ColomnId));
            tableTarif.setKotaFromId(resultSet.getInt(ColomnKotaFromId));
            tableTarif.setKecamatanFromId(resultSet.getInt(ColomnKecamatanFromId));
            tableTarif.setKotaToId(resultSet.getInt(ColomnKotaToId));
            tableTarif.setKecamatanToId(resultSet.getInt(ColomnKecamatanToId));
            tableTarif.setHargaPerKilo(resultSet.getInt(ColomnHargaPerKilo));
            tableTarif.setHargaPerKoli(resultSet.getInt(ColomnHargaPerKoli));
            tableTarif.setCreateBy(resultSet.getInt(ColomnCreateBy));
            tableTarif.setCreateDate(resultSet.getString(ColomnCreateDate));
            tableTarif.setModifiedBy(resultSet.getInt(ColomnModifyBy));
            tableTarif.setModifiedDate(resultSet.getString(ColomnModifyDate));
            tableTarif.setKotaFrom(kotas.getEntityItem(tableTarif.getKotaFromId()));
            tableTarif.setKecamatanFrom(kecamatans.getEntityItem(tableTarif.getKecamatanFromId()));
            tableTarif.setKotaTo(kotas.getEntityItem(tableTarif.getKotaToId()));
            tableTarif.setKecamatanTo(kecamatans.getEntityItem(tableTarif.getKecamatanToId()));
            this.DataList.add(tableTarif);
        }
        
    }

    @Override
    protected void newRowsIdPlot(TableTarif e, Object o) {
        e.setId(o.hashCode());
    }

    @Override
    protected void RowPlot(TableTarif e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //if(e==null){
        dataRow.clear();
        dataRow.add(new ColoumnValue(ColomnId, e.getId(), true));
        dataRow.add(new ColoumnValue(ColomnKotaFromId, e.getKotaFromId()));
        dataRow.add(new ColoumnValue(ColomnKecamatanFromId, e.getKecamatanFromId()));
        dataRow.add(new ColoumnValue(ColomnKotaToId, e.getKotaToId()));
        dataRow.add(new ColoumnValue(ColomnKecamatanToId, e.getKecamatanToId()));
        dataRow.add(new ColoumnValue(ColomnHargaPerKilo, e.getHargaPerKilo()));
        dataRow.add(new ColoumnValue(ColomnHargaPerKoli, e.getHargaPerKoli()));
        dataRow.add(new ColoumnValue(ColomnCreateBy, e.getCreateBy()));
        dataRow.add(new ColoumnValue(ColomnCreateDate, e.getCreateDate()));
        dataRow.add(new ColoumnValue(ColomnModifyBy, e.getModifiedBy()));
        dataRow.add(new ColoumnValue(ColomnModifyDate, e.getModifiedDate()));  
       // }
    }

    @Override
    public TableTarif getEntityItem(Object id) {
        return this.getAllData().stream().filter(t->t.getId()==id.hashCode()).findFirst().get();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void initializationFilterString(String filterString) {

    }

}
