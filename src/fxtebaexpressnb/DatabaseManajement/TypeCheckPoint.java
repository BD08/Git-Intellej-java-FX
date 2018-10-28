package fxtebaexpressnb.DatabaseManajement;

public enum TypeCheckPoint {
	CHECK_POINT_KANTOR{
		@Override
		public String toString() {
			return "Kantor";
		}
	},
	CHECK_POINT_KURIR{
		@Override
		public String toString() {
			return "Di Bawa Kurir";
		}
	},
	CHECK_POINT_DITERIMA{
		@Override
		public String toString() {
			return "Barang Sudah diterima";
		}
	},
	CHECK_POINT_DEFAULT{
		@Override
		public String toString() {
			return "Belom Ada";
		}
	}

}



