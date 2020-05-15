package p1;

class Route{
	protected int id;
	String f,t;
	Route(String from,String to)
	{
		f=from;
		t=to;
	}
}

public class Airplane extends Route {
	protected int id,seat_eco,seat_bus;
	protected String company,start_time,end_time,from,to;
	protected float distance,price,price2;
	Airplane(int i,String c,float dis,String f,String t,String start,String end,int e,int b,float p1,float p2){
		super(f,t);
		id=i;
		company=c;
		distance=dis;
		start_time=start;
		end_time=end;
		seat_eco=e;
		seat_bus=b;
		price=p1;
		price2=p2;
	}
}
