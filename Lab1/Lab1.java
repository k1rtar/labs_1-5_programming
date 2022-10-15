public class Lab1
{
	
	public static double generateRandomNumber(double start,double end)
	{
		double res =  Math.random()*(end-start+1)+start;
		if (res>end) return end;
		else return res;
	}
	
	public static double calculateElementValue(int di, double x)
	{
		if (di==9) 
		{
			double a = Math.pow((x/(x-1)),x);
			double b = 0.5-Math.tan(Math.sin(x));
			double c = Math.cos(Math.pow(x, 1.0/3));
			return Math.pow(Math.tan(a),b/c);
		}
		if (di==5 || di==7 || di==13 || di==17)
		{
			double p = (Math.pow(Math.E,x)-3)/2;
			return Math.pow(Math.E,p);
		}
		double p = Math.pow(-Math.sin(x)*Math.sin(x),1.0/3);
		double a = Math.pow(Math.E,p);

		return Math.pow((Math.atan(a)+0.25)/4,3);
	}

	public static void main(String[] args)
	{
		short d1[] = {19,17,15,13,11,9,7,5,3};
		double x[] = new double[20];
		
		for (int i = 0;i<20;i++)
		{
			x[i] = generateRandomNumber(-7.0,12.0);
		}
		
		double[][] d2 = new double[9][20];
		
		for (int i = 0;i<9;i++)
		{
			for (int j = 0;j<20;j++)
			{
				d2[i][j] = calculateElementValue(d1[i],x[j]);
				System.out.printf("%10.5f",d2[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
}
