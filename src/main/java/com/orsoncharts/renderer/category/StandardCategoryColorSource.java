/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, 2014, by Object Refinery Limited.
 * 
 * http://www.object-refinery.com/orsoncharts/index.html
 * 
 * Redistribution of this source file is prohibited.
 * 
 */

package com.orsoncharts.renderer.category;

import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;

import com.orsoncharts.Colors;
import com.orsoncharts.util.ArgChecks;

/**
 * A standard implementation of the {@link CategoryColorSource} interface.
 * <br><br>
 * NOTE: This class is serializable, but the serialization format is subject 
 * to change in future releases and should not be relied upon for persisting 
 * instances of this class.
 */
@SuppressWarnings("serial")
public class StandardCategoryColorSource implements CategoryColorSource, 
        Serializable {

    /** The sequence of color objects to use for each series. */
    private Color[] colors;
    
    /**
     * Creates a new instance with default colors.
     */
    public StandardCategoryColorSource() {
        this(Colors.getDefaultColors());
    }
    
    /**
     * Creates a new instance with the supplied sequence of colors.  The
     * supplied array must have at least one entry, and all entries must be
     * non-<code>null</code>.
     * 
     * @param colors  the colors (<code>null</code> not permitted). 
     */
    public StandardCategoryColorSource(Color... colors) {
        ArgChecks.nullNotPermitted(colors, "colors");
        if (colors.length == 0) {
            throw new IllegalArgumentException(
                    "Zero length array not permitted.");
        }
        for (Color c: colors) {
            if (c == null) { 
                throw new IllegalArgumentException(
                        "Null array entries not permitted.");
            }
        }
        this.colors = colors.clone();
    }
    
    /**
     * Returns the color to use for the specified item.
     * 
     * @param series  the series index.
     * @param row  the row index.
     * @param column  the column index.
     * 
     * @return The color (never <code>null</code>). 
     */
    @Override
    public Color getColor(int series, int row, int column) {
        return this.colors[series % this.colors.length];
    }

    /**
     * Returns the color to use in the legend for the specified series.
     * 
     * @param series  the series index.
     * 
     * @return The color (never <code>null</code>).
     */
    @Override
    public Color getLegendColor(int series) {
        return this.colors[series % this.colors.length];
    }
    
    /**
     * Restyles the source using the specified colors.  Refer to the 
     * implementing class to confirm the precise behaviour (typically all 
     * existing color settings are cleared and the specified colors are 
     * installed as the new defaults).
     * 
     * @param colors  the colors.
     * 
     * @since 1.2
     */
    @Override
    public void style(Color... colors) {
        ArgChecks.nullNotPermitted(colors, "colors");
        if (colors.length == 0) {
            throw new IllegalArgumentException(
                    "Zero length array not permitted.");
        }
        for (Color c: colors) {
            if (c == null) { 
                throw new IllegalArgumentException(
                        "Null array entries not permitted.");
            }
        }
        this.colors = colors.clone();
    }
    
    /**
     * Tests this color source for equality with an arbitrary object.
     * 
     * @param obj  the object (<code>null</code> permitted).
     * 
     * @return A boolean. 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardCategoryColorSource)) {
            return false;
        }
        StandardCategoryColorSource that 
                = (StandardCategoryColorSource) obj;
        if (!Arrays.equals(this.colors, that.colors)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Arrays.deepHashCode(this.colors);
        return hash;
    }

}