package fxtebaexpressnb.Utility;

public enum  FilterParameter {
	LIKE{
		@Override
		public String toString() {
			return " LIKE ";
		}
	},
	SAMA_DENGAN{
		@Override
		public String toString() {
			return " = ";
		}
	}
}
