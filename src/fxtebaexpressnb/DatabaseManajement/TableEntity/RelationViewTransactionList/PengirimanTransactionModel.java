package fxtebaexpressnb.DatabaseManajement.TableEntity.RelationViewTransactionList;

import fxtebaexpressnb.DatabaseManajement.TypeCheckPoint;
import fxtebaexpressnb.DatabaseManajement.TypeCheckPointClass;

public class PengirimanTransactionModel {

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

	private int idTransaction;
	private String namaPengirim;
	private String namaPenerima;
	private String alamatPengirim;
	private String alamatPenerima;
	private int idCheckPoint;
	private int typeCheckPointInt;
	private TypeCheckPoint typeCheckPoint;
	private String tanggalKirim;
	private String tanggalCheckIn;

	private String namaPembawa;

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public String getNamaPengirim() {
		return namaPengirim;
	}

	public void setNamaPengirim(String namaPengirim) {
		this.namaPengirim = namaPengirim;
	}


	public String getNamaPenerima() {
		return namaPenerima;
	}

	public void setNamaPenerima(String namaPenerima) {
		this.namaPenerima = namaPenerima;
	}

	public String getAlamatPengirim() {
		return alamatPengirim;
	}

	public void setAlamatPengirim(String alamatPengirim) {
		this.alamatPengirim = alamatPengirim;
	}

	public String getAlamatPenerima() {
		return alamatPenerima;
	}

	public void setAlamatPenerima(String alamatPenerima) {
		this.alamatPenerima = alamatPenerima;
	}

	public int getIdCheckPoint() {
		return idCheckPoint;
	}

	public void setIdCheckPoint(int idCheckPoint) {
		this.idCheckPoint = idCheckPoint;
	}

	public int getTypeCheckPointInt() {
		return typeCheckPointInt;
	}

	public void setTypeCheckPointInt(int typeCheckPointInt) {
		this.typeCheckPoint= TypeCheckPointClass.getCheckPointType(typeCheckPointInt);
		this.typeCheckPointInt = typeCheckPointInt;
	}

	public TypeCheckPoint getTypeCheckPoint() {
		return typeCheckPoint;
	}

	public void setTypeCheckPoint(TypeCheckPoint typeCheckPoint) {
		this.typeCheckPointInt=TypeCheckPointClass.getCheckPointInt(typeCheckPoint);
		this.typeCheckPoint = typeCheckPoint;
	}

	public String gettypeCheckPointString(){
		return this.typeCheckPoint.toString();
	}

	public String getNamaPembawa() {
		return namaPembawa;
	}

	public void setNamaPembawa(String namaPembawa) {
		this.namaPembawa = namaPembawa;
	}
}
