package fxtebaexpressnb.Utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

/**
 * BD08MappingDatabase Class yang di mana di peruntukkan untuk membuat sellect DB lebih Mudah dalam sesuatunya
 * Syarat dan ketentuan Connection harus sudah ada
 * Dalam Kondisi ini kita harus mapping data table dengan menjadi sebuah class yang dimana
 * class tersebut memiliki varibale yang namanya sama dengan nama yang sudah ada di database
 * karena barang tersebut membutuhkan data yang di inginkan
 * @author Bang Dolla 08 BD08 ^__^v 2018
 * @implNote Untuk Type A
 */
public class BD08MappingDatabase {

	private Connection connection;
	private Statement statement;
	/**
	 * Parrameter BD08MappingDatabase Untuk load membutuhkan connection
	 * @param connection
	 */
	public BD08MappingDatabase(Connection connection) throws Exception{
		this.connection=connection;
		this.statement=this.connection.createStatement();
		this.errorMapping=new ArrayList<>();
	}

	public BD08MappingDatabase(){
		this.errorMapping=new ArrayList<>();
	}
	public int getRowCount(String SQLParamet)throws Exception{
		if(SQLParamet.isEmpty())
			return 0;
		SQLParamet="SELECT COUNT(*) FROM ("+SQLParamet+") A";
		ResultSet resultSet=this.statement.executeQuery(SQLParamet);
		if(resultSet.next())
			return resultSet.getInt(0);
		return 0;
	}



	/**
	 * Return adalah list Dari class tersebut cobtoh List<Cars>
	 * @param SQLParameter Sql Parameter yang ingin di select Bisa * Bisa percolomn
 	 * @param classTable Class Table yang ingin ditampilkan sementara tidak bisa null harus ada isi semua
	 * @param <T> Class Table
	 * @return List dari SQL Parameter
	 * @throws Exception Error yang di dapatkan
	 */
	public <T> List<T> excuteSQLSelect(String SQLParameter,Class<T> classTable) throws Exception{
		List<T> res=new ArrayList<>();
		Field[] fileds=classTable.getFields();
		ResultSet resultSet=connection.createStatement().executeQuery(SQLParameter);
		while (resultSet.next()){
			T rowItem=classTable.getConstructor().newInstance();
			for (Field coloumnField:fileds) {
				Object data=objectConvert(resultSet,coloumnField.getName());//resultSet.getObject(coloumnField.getName());
				coloumnField.set(rowItem,data);
			}
			res.add(rowItem);
		}
		return res;
	}

	public <T> DataTableResult<T> getDataTableResult(String SQLParameter,Class<T> tClass,int Page,int itemPage)throws Exception{
		DataTableResult<T> result=new DataTableResult<T>();
		result.setCurrentPage(Page);
		result.setTotalDataRow(getRowCount(SQLParameter));
		int size=result.getTotalDataRow();
		int hasilModulus=size% StaticValue.bucketSize;
		int hasilBagi=size/StaticValue.bucketSize;
		result.setDataTotalPage(hasilBagi);

		// TODO: 10/28/2018 Untuk menambahkan Page Di SINI Di String SQL nya
		result.setDataResult(this.excuteSQLSelect(SQLParameter,tClass));
		return result;

	}


	private List<String> errorMapping;

	public List<String> getErrorMapping(){
		if(errorMapping==null)
			this.errorMapping=new ArrayList<>();
		return errorMapping;
	}

	private Object objectConvert(ResultSet resultSet, String coloumnField){
		Object res=null;
		try {
			res=resultSet.getObject(coloumnField);
		}catch (Exception ex){
			System.err.println(coloumnField+"Null");
			errorMapping.add("Mapping Coloumn Name error "+coloumnField);
		}
		return res;
	}

	public <T> boolean updateSQL(String tableName,Class<T> classTable, T tableValue ) throws Exception{
		boolean res=false;
		return res;
	}


}
