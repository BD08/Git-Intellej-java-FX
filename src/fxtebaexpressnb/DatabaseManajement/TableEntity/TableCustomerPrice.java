/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.TableEntity;

/**
 *
 * @author AsusX450J
 */
public class TableCustomerPrice {
    private int CustomerId;
    private int TarifId;
    private TableTarif tarif;
    private TableCustomer customer;

    public TableCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TableCustomer customer) {
        this.customer = customer;
        this.CustomerId=customer.getId();
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public int getTarifId() {
        return TarifId;
    }

    public void setTarifId(int TarifId) {
        this.TarifId = TarifId;
    }

    public TableTarif getTarif() {
        return tarif;
    }

    public void setTarif(TableTarif tarif) {
        this.TarifId=tarif.getId();
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return this.tarif.getHargaPerKoli()+"";
    }
    
}
