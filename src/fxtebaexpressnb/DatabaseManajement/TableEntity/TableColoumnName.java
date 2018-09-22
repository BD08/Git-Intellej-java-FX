/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtebaexpressnb.DatabaseManajement.TableEntity;

/**
 *
 * @author BD08 BangDolla08
 */
public class TableColoumnName {
    
    public static final class TarifTable{
        //<editor-fold defaultstate="collapsed" desc="Coloumn Name For data">

        /**
         * Id
         */
        public static final String COLOMN_ID="Id";
        public static final String COLOMN_KOTA_FROM_ID="KotaFromId";
        public static final String COLOMN_KECAMATAN_FROM_ID="KecamatanFromId";
        public static final String COLOMN_KOTA_TO_ID="KotaToId";
        public static final String COLOMN_KECAMATAN_TO_ID="KecamatanToId";
        public static final String COLOMN_HARGA_PER_KILO="HargaPerKilo";
        public static final String COLOMN_HARGA_PER_KOLI ="HargaPerKoli";
        public static final String COLOMN_CREATE_DATE="CreateDate";
        public static final String COLOMN_CREATE_BY="CreateBy";
        public static final String COLOMN_MODIFY_DATE="ModifyDate";
        public static final String COLOMN_MODIFY_BY="ModifyBy";
        //</editor-fold>
    }
    
    public static final class UserManagers{
        public static final String ID="Id";
        public static final String FIRST_NAME="FirstName";
        public static final String LAST_NAME="LastName";
        public static final String EMAIL="Email";
        public static final String USERNAME="Username";
        public static final String ALAMAT="Alamat";
        public static final String PHONE_NUMBER="PhoneNumber";
        public static final String CABANG_ID="CabangId";
        public static final String PASSWORD="Password";
    }
    
    public static final class AWBTable{
        public static final String ID="Id";
        public static final String CUSTOMER_ID="CustomerId";
        public static final String AIRWAYBILL="Airwaybill";
        public static final String TO_NAMA="ToNama";
        public static final String TO_ALAMAT="ToAlamat";
        public static final String TO_KECAMATAN_ID="ToKecamatanId";
        public static final String TO_KOTA_ID="ToKotaId";
        public static final String TO_TELP1="ToTelp1";
        public static final String TO_TELP2="ToTelp2";
        public static final String ISKILO="isKilo";
        public static final String TOTAL_KOLI="TotalKoli";
        public static final String TOTAL_KILO="TotalKilo";
        public static final String CREATE_DATE="CreateDate";
        public static final String CREATE_BY="CreateBy";
        public static final String MODIFY_DATE="ModifiDate";
        public static final String MODIFY_BY="ModifiBy";
    }
    
    public static final class KurirTable{
        public static final String ID="Id";
        public static final String USER_MANAGER_ID="UserManagerId";
        public static final String TYPE_KENDARAAN="TypeKendaraan";
        public static final String NOMOR_POLISI="NomorPolisi";
        public static final String CREATE_DATE="CreateDate";
        public static final String CREATE_BY="CreateBy";
        public static final String MODIFY_DATE="ModifiDate";
        public static final String MODIFY_BY="ModifiBy";
        
    }
    
}
