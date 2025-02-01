package com.myapp.p20.Custom;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.locationtech.jts.geom.Geometry;
import org.ugeojson.model.GeoJSONObjectDto;
import org.ugeojson.model.geometry.GeometryDto;
import org.ugeojson.parser.UltimateGeoJSONParser;
import org.ugeojson.parser.util.JtsUGeojsonConversionUtil;

import java.io.IOException;

public class CustomUGeojsonDeserializer<T extends Geometry> extends JsonDeserializer<T> {
    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String geojson = node.toString();
        GeoJSONObjectDto geoJSONObjectDto= UltimateGeoJSONParser.getInstance().parse(geojson);
        JtsUGeojsonConversionUtil jtsUGeojsonConversionUtil=new JtsUGeojsonConversionUtil();
        Geometry geometry=jtsUGeojsonConversionUtil.toJtsGeometry((GeometryDto) geoJSONObjectDto);

        return (T) geometry;
    }
}
