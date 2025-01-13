package com.mikayelaghasyan.strategyrunner.core;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

public class JsonReferenceDataSource implements ReferenceDataSource {
    private static final String REFERENCE_DATA_FILE = "reference-data.json";
    public JsonReferenceDataSource() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(REFERENCE_DATA_FILE)) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.addMixIn(AssetClass.class, AssetClassMixIn.class);
            JsonNode rootNode = objectMapper.readValue(is, JsonNode.class);
            this.assetClasses = objectMapper.convertValue(
                    rootNode.get("assetClasses"),
                    new TypeReference<ArrayList<AssetClass<?>>>() {}
            );
            this.exchanges = objectMapper.convertValue(
                    rootNode.get("exchanges"),
                    new TypeReference<ArrayList<Exchange>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Collection<AssetClass<?>> assetClasses;
    private Collection<Exchange> exchanges;

    @Override
    public Collection<AssetClass<?>> getAssetClasses() {
        return assetClasses;
    }

    public static void main(String[] args) {
        JsonReferenceDataSource dataSource = new JsonReferenceDataSource();
    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.EXISTING_PROPERTY,
            property = "id",
            visible = true
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Futures.class, name = "futures")
    })
    public abstract static class AssetClassMixIn {
    }
}
