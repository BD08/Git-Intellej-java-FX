package fxtebaexpressnb.DatabaseManajement.TableEntity;

public class TableKodeMaster {
	private int Id;
	private String Name;

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
