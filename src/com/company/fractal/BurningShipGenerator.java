package com.company.fractal;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * This class represents a generator of
 * Burning Ship fractal
 *
 * @author Stoyalov Arseny BVT1803
 */
public class BurningShipGenerator extends FractalGenerator {

    private static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.width = range.height = 4;
    }

    /**
     * Slightly changes method of the superclass.
     * Given a coordinate <em>x</em> + <em>iy</em> in the complex plane,
     * computes the number of iterations before the fractal
     * function escapes the bounding area for that point.  A point that
     * doesn't escape before the iteration limit is reached is indicated
     * with a result of 0. A point that does is indicated with the
     * color value that the pixel of the the same coordinates
     * should be set to as a result
     */
    @Override
    public int numIterations(double x, double y) {

        double cx = x;
        double cy = y;

        for (int i = 0; i < MAX_ITERATIONS; i++) {
            double nx = x * x - y * y + cx;
            double ny = Math.abs(2 * x * y) + cy;
            x = nx;
            y = ny;
            if (x * x + y * y > 4)
                return Color.HSBtoRGB(0.7f + (float) i / MAX_ITERATIONS * 7, 1f, 3f);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Burning ship";
    }

}
