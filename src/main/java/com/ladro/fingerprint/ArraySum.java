package com.ladro.fingerprint;

import java.util.Random;

import com.amd.aparapi.Kernel;
import com.amd.aparapi.Range;

public class ArraySum {

	public static void main(String[] args) {
		int pos = 0;
		Random r = new Random(Long.parseLong(args[pos++]));
		final float inA[] = randomArray(r, Integer.parseInt(args[pos++]));
		final float inB[] = randomArray(r, inA.length);
		boolean verbose = false;
		if (pos < args.length)
			verbose = Boolean.parseBoolean(args[pos++]);

		final float result[] = new float[inA.length];

		long startTime = System.currentTimeMillis();
		Kernel kernel = new Kernel() {
			@Override
			public void run() {
				int i = getGlobalId();
				result[i] = inA[i] + inB[i];
			}
		};
		Range range = Range.create(result.length);
		kernel.execute(range);
		int deltaMillis = (int) (System.currentTimeMillis() - startTime);
		if (verbose) {
			for (int i = 0; i < inA.length; i++) {
				System.out.println(String.format("%d %f %f = %f .  Diff: %f", i, inA[i], inB[i], inA[i] + inB[i], inA[i] + inB[i] - result[i]));
			}
		}
		System.out.println(String.format("Took %d millis to add arrays of size %d", deltaMillis, inA.length));

	}

	private static float[] randomArray(Random r, int size) {
		float ret[] = new float[size];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = r.nextFloat();
		}
		return ret;
	}
}
