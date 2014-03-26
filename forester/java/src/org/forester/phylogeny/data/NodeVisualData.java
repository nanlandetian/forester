package org.forester.phylogeny.data;

import java.awt.Color;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


import org.forester.phylogeny.data.Property.AppliesTo;
import org.forester.util.ForesterUtil;


public final class NodeVisualData implements PhylogenyData {
    
    private static final int DEFAULT_SIZE = -1;
    private static final int DEFAULT_TRANSPARANCY = -1;
    private static final byte DEFAULT_FONT_SIZE = -1;
    private NodeShape _shape;
    private NodeFill  _fill_type;
    private Color     _border_color;
    private Color     _fill_color;
    
    private String    _font;
    private FontType    _font_type;
    private byte    _font_size;
    private Color    _font_color;
    
    private float    _size;
    private float    _transparancy;

    public NodeVisualData() {
        init();
    }

    public NodeVisualData(    final String font,
                              final FontType    font_type,
                              byte    font_size,
                              Color    font_color,
                              final NodeShape shape,
                              final NodeFill fill_type,
                              final Color border_color,
                              final Color fill_color,
                              final float size,
                              final float transparancy ) {
        setFont( font );
        setFontType(font_type );
        setFontSize( font_size );
        setFontColor( font_color );
        setShape( shape );
        setFillType( fill_type );
        setBorderColor( border_color );
        setFillColor( fill_color );
        setSize( size );
        setTransparancy( transparancy );
    }

    @Override
    public final StringBuffer asSimpleText() {
        return asText();
    }

    @Override
    public final StringBuffer asText() {
        final StringBuffer sb = new StringBuffer();
        return sb;
    }

    @Override
    public final  PhylogenyData copy() {
        return new NodeVisualData(  ForesterUtil.isEmpty( getFont() ) ? new String( getFont()) : null  ,
                                   getFontType(),
                                   getFontSize(),
                                   getFontColor() != null ? new Color( getFontColor().getRed(), getFontColor()
                                      .getGreen(), getFontColor().getBlue() ) : null,     
                                   getShape(),
                                      getFillType(),
                                      getBorderColor() != null ? new Color( getBorderColor().getRed(), getBorderColor()
                                              .getGreen(), getBorderColor().getBlue() ) : null,
                                      getFillColor() != null ? new Color( getFillColor().getRed(), getFillColor()
                                              .getGreen(), getFillColor().getBlue() ) : null,
                                      getSize(),
                                      getTransparancy() );
    }

    public final Color getBorderColor() {
        return _border_color;
    }

    public final Color getFillColor() {
        return _fill_color;
    }

    public final NodeFill getFillType() {
        return _fill_type;
    }

    public final NodeShape getShape() {
        return _shape;
    }

    public final float getSize() {
        return _size;
    }

    public final float getTransparancy() {
        return _transparancy;
    }

    private final  void init() {
        setFont( null );
        setFontType( FontType.NORMAL );
        setFontSize( DEFAULT_FONT_SIZE );
        setFontColor( null );
        setShape( NodeShape.DEFAULT );
        setFillType( NodeFill.DEFAULT );
        setBorderColor( null );
        setFillColor( null );
        setSize( DEFAULT_SIZE );
        setTransparancy( DEFAULT_TRANSPARANCY );
    }

    @Override
    public final boolean isEqual( final PhylogenyData data ) {
        throw new UnsupportedOperationException();
    }

    public final void setBorderColor( final Color border_color ) {
        _border_color = border_color;
    }

    public final void setFillColor( final Color fill_color ) {
        _fill_color = fill_color;
    }

    public final void setFillType( final NodeFill fill_type ) {
        _fill_type = fill_type;
    }

    public final void setShape( final NodeShape shape ) {
        _shape = shape;
    }

    public final void setSize( final float size ) {
        _size = size;
    }

    public final void setTransparancy( final float transparancy ) {
        _transparancy = transparancy;
    }

    @Override
    public final StringBuffer toNHX() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void toPhyloXML( final Writer writer, final int level, final String indentation ) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public final String toString() {
        return asText().toString();
    }

    public enum NodeFill {
        NONE, GRADIENT, SOLID, DEFAULT
    }

    public enum NodeShape {
        CIRCLE, RECTANGLE, DEFAULT
    }
    
    public enum FontType {
        NORMAL, BOLD, ITALIC, BOLD_ITALIC
    }

    private final List<Property> toProperties() {
        final List<Property> properties = new ArrayList<Property>();
        properties.add( new Property( SIZE_REF, String.valueOf( getSize() ), "", SIZE_TYPE, AppliesTo.NODE ) );
        properties.add( new Property( SIZE_REF, String.valueOf( getShape() ), "", SIZE_TYPE, AppliesTo.NODE ) );
        properties.add( new Property( SIZE_REF, String.valueOf( getFillType() ), "", SIZE_TYPE, AppliesTo.NODE ) );
        properties.add( new Property( SIZE_REF, String.valueOf( getTransparancy() ), "", SIZE_TYPE, AppliesTo.NODE ) );
        properties.add( new Property( SIZE_REF, String.valueOf( getFillColor() ), "", SIZE_TYPE, AppliesTo.NODE ) );
        properties.add( new Property( SIZE_REF, String.valueOf( getBorderColor() ), "", SIZE_TYPE, AppliesTo.NODE ) );
        return properties;
    }
    public static final String SIZE_REF  = "aptx_visualiation:node_sise";
    public static final String SIZE_TYPE = "xsd:decimal";

    public final boolean isEmpty() {
        return ( ForesterUtil.isEmpty( getFont() ) &&
                getFontType() == FontType.NORMAL && 
                getFontSize() == DEFAULT_FONT_SIZE &&
                getFontColor() == null &&
                getShape() == NodeShape.DEFAULT &&
        getFillType() == NodeFill.DEFAULT &&
        getBorderColor() == null &&
        getFillColor() == null &&
        getSize() == DEFAULT_SIZE &&
        getTransparancy() == DEFAULT_TRANSPARANCY );
    }

    public final String getFont() {
        return _font;
    }

    public final void setFont( final String font ) {
        if ( !ForesterUtil.isEmpty( font ) ) {
            _font = font;
        }
        else {
            _font = null;
        }
    }

    public final FontType getFontType() {
        return _font_type;
    }

    public final void setFontType( FontType font_type ) {
        _font_type = font_type;
    }

    public final byte getFontSize() {
        return _font_size;
    }

    public final void setFontSize( byte font_size ) {
        _font_size = font_size;
    }

    public final Color getFontColor() {
        return _font_color;
    }

    public final void setFontColor( Color font_color ) {
        _font_color = font_color;
    }
}