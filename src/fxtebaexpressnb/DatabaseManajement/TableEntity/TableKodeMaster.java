package fxtebaexpressnb.DatabaseManajement.TableEntity;

public class TableKodeMaster {
	private int Id;
	private String Name;

	/**
	 * Default Untuk Combobox
	 * @return Return DefaultCodemaster
	 */
	public static TableKodeMaster defaultTableKodeMaster(){
		TableKodeMaster tableKodeMaster=new TableKodeMaster();
		tableKodeMaster.setName("--Select--");
		tableKodeMaster.setId(-8008);
		return tableKodeMaster;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
