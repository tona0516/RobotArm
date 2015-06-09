public class RobotArm {

	public static final double LEN = 50;

	public static void main(String[] args) {
		P init = new P(300, -300, 270);
		P touch = new P(300, -300, 237.150);
		System.out.println("init("+String.format("%.3f", touch.x)+","+String.format("%.3f", touch.y)+")");
		double[] radian = new double[16];
		radian[0] = 0;
		for(int i=1;i<16;i++){
			radian[i] = radian[i-1] + Math.PI/8;
		}
		int j=0;
		for(double theta : radian){
			double y = LEN * Math.cos(theta) + touch.y;
			double x = -LEN * Math.sin(theta) + touch.x;
			System.out.println("d"+j+"("+String.format("%.3f", x)+","+String.format("%.3f", y)+")");
			j++;
		}
	}
	public static class P {
		public double x;
		public double y;
		public double z;

		private P() {
		}

		public P(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
