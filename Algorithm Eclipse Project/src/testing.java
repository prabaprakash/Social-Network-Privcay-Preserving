import java.util.ArrayList;

import java.io.*;
public class testing {
	public static void main(String[] args) throws IOException {
		if(0.3381213332874822>=0.0)
			System.out.print("woe");
		ArrayList<Double> list = new ArrayList<Double>();
	
				list.add(0.15330844834180368);
				list.add(1.1054369240681936);
				list.add(1.1705568526374464);
				list.add(2.497823274215321);
				list.add(3.672104370716063);
				list.add(0.3184602767859843);
		Double max = MaxInList(list);
		MetricsXAxisProcessing(list,5.874219974462832);
	}
	private static void MetricsXAxisProcessing(ArrayList<Double> list,Double max) {
		
		Double val = (max * 20) / 100;
		Double inc = val;
		// System.out.println(val);
		Double limit = 0.0;
		ArrayList<metricsA> m = new ArrayList<metricsA>();
		while (val <= max) {
			Double count = 0.0;
			for (Double i : list) {
				// System.out.println(i);
				if (i >= limit + 1 && i <= val) {
					count++;

					// list.remove(i);
				}
			}
			// System.out.println(val+" "+count);
			Double double1 = count / list.size();
			m.add(new metricsA(val, double1));
			limit = val;
			val = val + inc;

		}
		for (metricsA metricsA : m) {
			System.out.println(metricsA.x + "  " + metricsA.y);

		}
	}
	private static Double MaxInList(ArrayList<Double> list) {
		Double min = list.get(0);
		Double max = list.get(0);

		for (Double i : list) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;
		}
		return max;
	}




}
