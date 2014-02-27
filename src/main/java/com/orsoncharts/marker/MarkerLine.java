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

package com.orsoncharts.marker;

import java.awt.geom.Point2D;

/**
 * A data object that represents a line within a {@link MarkerData} structure.
 * 
 * @since 1.2
 */
public class MarkerLine {
    
    /** The relative position along the axis (in the range 0.0 to 1.0). */
    private double pos;

    /** 
     * A flag indicating whether or not the line is pegged at the boundary of
     * the axis.  If the line is pegged, then it is not drawn (since it lies
     * outside the visible range of the chart.
     */
    private boolean pegged;
    
    /** The vertex index for the start of the line. */
    private int v0;
    
    /** The vertex index for the end of the line. */
    private int v1;
    
    /** The projected start point. */
    private Point2D startPoint;
    
    /** The projected end point. */
    private Point2D endPoint;
    
    /**
     * Creates a new marker line.
     * 
     * @param pos  the relative position (in the range 0.0 to 1.0). 
     */
    public MarkerLine(double pos, boolean pegged) {
        this(pos, pegged, -1, -1);
    }
    
    /**
     * Creates a new marker line with vertex indices.
     * 
     * @param pos  the relative position (in the range 0.0 to 1.0). 
     * @param v0  the index of the first vertex.
     * @param v1  the index of the second vertex.
     */
    public MarkerLine(double pos, boolean pegged, int v0, int v1) {
        this.pos = pos;
        this.pegged = pegged;
        this.v0 = v0;
        this.v1 = v1;
        this.startPoint = null;
        this.endPoint = null;
    }
    
    /**
     * Returns the relative position of the line along the axis.
     * 
     * @return The relative position of the line along the axis.
     */
    public double getPos() {
        return this.pos;
    }
    
    /**
     * Returns <code>true</code> if the line is pegged, and <code>false</code>
     * otherwise.  This is used for range markers to indicate that the value
     * represented by the line falls outside the current axis range, so the
     * line has been moved to the nearest axis boundary ("pegged" to the axis
     * range).
     * 
     * @return A boolean.
     */
    public boolean isPegged() {
        return this.pegged;
    }
    
    /**
     * Returns the index of the vertex for the start of the line.
     * 
     * @return The index.
     */
    public int getV0() {
        return this.v0;
    }
    
    /**
     * Sets the index of the vertex for the start of the line.
     * 
     * @param v0  the index. 
     */
    public void setV0(int v0) {
        this.v0 = v0;
    }
    
    /**
     * Returns the index of the vertex for the end of the line.
     * 
     * @return The index.
     */
    public int getV1() {
        return this.v1;
    }
    
    /**
     * Sets the index of the vertex for the end of the line.
     * 
     * @param v1  the index. 
     */
    public void setV1(int v1) {
        this.v1 = v1;
    }
    
    /**
     * Returns the projected starting point for the line.
     * 
     * @return The projected starting point (possibly <code>null</code>). 
     */
    Point2D getStartPoint() {
        return this.startPoint;
    }
    
    /**
     * Sets the projected starting point for the line.
     * 
     * @param pt  the projected point.
     */
    public void setStartPoint(Point2D pt) {
        this.startPoint = pt;
    }
    
    /**
     * Returns the projected ending point for the line.
     * 
     * @return The projected ending point (possibly <code>null</code>). 
     */
    Point2D getEndPoint() {
        return this.endPoint;
    }
    
    /**
     * Sets the projected ending point for the line.
     * 
     * @param pt  the projected point.
     */
    public void setEndPoint(Point2D pt) {
        this.endPoint = pt;
    }
   
}