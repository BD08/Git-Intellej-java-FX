package fxtebaexpressnb.DatabaseManajement;

public class TypeCheckPointClass{
	public static TypeCheckPoint getCheckPointType(int type){
		switch (type){
			case 1:
				return TypeCheckPoint.CHECK_POINT_KANTOR;
			case 2:
				return TypeCheckPoint.CHECK_POINT_KURIR;
			case 3:
				return TypeCheckPoint.CHECK_POINT_DITERIMA;
		}
		return TypeCheckPoint.CHECK_POINT_DEFAULT;
	}
	public static int getCheckPointInt(TypeCheckPoint typeCheckPoint){
		switch (typeCheckPoint){
			case CHECK_POINT_KANTOR:
				return 1;
			case CHECK_POINT_KURIR:
				return 2;
			case CHECK_POINT_DITERIMA:
				return 3;
		}
		return 0;
	}
}