package fxtebaexpressnb.DatabaseManajement.TableEntity.RelationViewTransactionList;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import fxtebaexpressnb.DatabaseManajement.TableEntity.TableTarif;
import fxtebaexpressnb.DatabaseManajement.TypeCheckPoint;
import fxtebaexpressnb.DatabaseManajement.TypeCheckPointClass;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PengirimanTransactionModel extends RecursiveTreeObject<TableTarif> {

	public static String IDTRANSACTION_COLOUMN="idTransaction";
	public static String NAMAPENGIRIM_COLOUMN="namaPengirim";
	public static String NAMAPENERIMA_COLOUMN="namaPenerima";
	public static String ALAMATPENGIRIM_COLOUMN="alamatPengirim";
	public static String ALAMATPENERIMA_COLOUMN="alamatPenerima";
	public static String IDCHECKPOINT_COLOUMN="idCheckPoint";
	public static String TYPECHECKPOINT_COLOUMN="typeCheckPointInt";
	public static String TANGGALKIRIM_COLOUMN="CreateDate";
	public static String TANGGALCHECKIN_COLOUMN="CreateDate";
	public static String CHECKPOINTNAME_CLOUMN="FirstName";

	public int idTransaction;
	public String namaPengirim;
	public String namaPenerima;
	public String alamatPengirim;
	public String alamatPenerima;
	public int idCheckPoint;
	public int typeCheckPointInt;
	public TypeCheckPoint typeCheckPoint;
	public String tanggalKirim;
	public String tanggalCheckIn;

	public String namaPembawa;
	public String NOAWB;

	public SimpleIntegerProperty getSimpleStringIdTransaction(){
		return new SimpleIntegerProperty(idTransaction);
	}

	public SimpleStringProperty getSimpleStringPropertyNamaPengirim(){
		return new SimpleStringProperty(namaPengirim);
	}

	public SimpleStringProperty getSimpleStringPropertyNamaPenerima(){
		return new SimpleStringProperty(namaPenerima);
	}

	public SimpleStringProperty getSimpleStringPropertyAlamatPengirim(){
		return new SimpleStringProperty(alamatPengirim);
	}

	public SimpleStringProperty getSimpleStringPropertyAlamatPenerima(){
		return new SimpleStringProperty(alamatPenerima);
	}

	public SimpleIntegerProperty getSimpleIntegerPropertyIdCheckPoint(){
		return new SimpleIntegerProperty(idCheckPoint);
	}

	public SimpleStringProperty getSimpleStringPropertyTypeCheckPoint(){
		return new SimpleStringProperty(TypeCheckPointClass.getCheckPointType(typeCheckPointInt).toString());
	}

	public  SimpleStringProperty getSimpleStringPropertyTanggalKirim(){
		return new SimpleStringProperty(tanggalKirim);
	}
	public SimpleStringProperty getSimpleStringPropertyTanggalCheckIn(){
		return new SimpleStringProperty(tanggalCheckIn);
	}

	public SimpleStringProperty getSimpleStringPropertyAWB(){
		return new SimpleStringProperty(NOAWB);
	}

	public SimpleStringProperty getSimpleStringPropertyPembawa(){
		return new SimpleStringProperty(namaPembawa);
	}

	//
//	public int getIdTransaction() {
//		return idTransaction;
//	}
//
//	public void setIdTransaction(int idTransaction) {
//		this.idTransaction = idTransaction;
//	}
//
//	public String getNamaPengirim() {
//		return namaPengirim;
//	}
//
//	public void setNamaPengirim(String namaPengirim) {
//		this.namaPengirim = namaPengirim;
//	}
//
//
//	public String getNamaPenerima() {
//		return namaPenerima;
//	}
//
//	public void setNamaPenerima(String namaPenerima) {
//		this.namaPenerima = namaPenerima;
//	}
//
//	public String getAlamatPengirim() {
//		return alamatPengirim;
//	}
//
//	public void setAlamatPengirim(String alamatPengirim) {
//		this.alamatPengirim = alamatPengirim;
//	}
//
//	public String getAlamatPenerima() {
//		return alamatPenerima;
//	}
//
//	public void setAlamatPenerima(String alamatPenerima) {
//		this.alamatPenerima = alamatPenerima;
//	}
//
//	public int getIdCheckPoint() {
//		return idCheckPoint;
//	}
//
//	public void setIdCheckPoint(int idCheckPoint) {
//		this.idCheckPoint = idCheckPoint;
//	}
//
//	public int getTypeCheckPointInt() {
//		return typeCheckPointInt;
//	}
//
//	public void setTypeCheckPointInt(int typeCheckPointInt) {
//		this.typeCheckPoint= TypeCheckPointClass.getCheckPointType(typeCheckPointInt);
//		this.typeCheckPointInt = typeCheckPointInt;
//	}
//
//	public TypeCheckPoint getTypeCheckPoint() {
//		return typeCheckPoint;
//	}
//
//	public void setTypeCheckPoint(TypeCheckPoint typeCheckPoint) {
//		this.typeCheckPointInt=TypeCheckPointClass.getCheckPointInt(typeCheckPoint);
//		this.typeCheckPoint = typeCheckPoint;
//	}
//
//	public String gettypeCheckPointString(){
//		return this.typeCheckPoint.toString();
//	}
//
//	public String getNamaPembawa() {
//		return namaPembawa;
//	}
//
//	public void setNamaPembawa(String namaPembawa) {
//		this.namaPembawa = namaPembawa;
//	}
}
