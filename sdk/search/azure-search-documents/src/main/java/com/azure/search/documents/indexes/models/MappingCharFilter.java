// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
//
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A character filter that applies mappings defined with the mappings option. Matching is greedy (longest pattern
 * matching at a given point wins). Replacement is allowed to be the empty string. This character filter is implemented
 * using Apache Lucene.
 */
@Immutable
public final class MappingCharFilter extends CharFilter {
    /*
     * Identifies the concrete type of the char filter.
     */
    private static final String ODATA_TYPE = "#Microsoft.Azure.Search.MappingCharFilter";

    /*
     * A list of mappings of the following format: "a=>b" (all occurrences of the character "a" will be replaced with
     * character "b").
     */
    private final List<String> mappings;

    /**
     * Creates an instance of MappingCharFilter class.
     *
     * @param name the name value to set.
     * @param mappings the mappings value to set.
     */
    public MappingCharFilter(String name, List<String> mappings) {
        super(name);
        this.mappings = mappings;
    }

    /**
     * Get the mappings property: A list of mappings of the following format: "a=&gt;b" (all occurrences of the
     * character "a" will be replaced with character "b").
     *
     * @return the mappings value.
     */
    public List<String> getMappings() {
        return this.mappings;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("@odata.type", ODATA_TYPE);
        jsonWriter.writeStringField("name", getName());
        jsonWriter.writeArrayField("mappings", this.mappings, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MappingCharFilter from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MappingCharFilter if the JsonReader was pointing to an instance of it, or null if it was
     *     pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties or the
     *     polymorphic discriminator.
     * @throws IOException If an error occurs while reading the MappingCharFilter.
     */
    public static MappingCharFilter fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
                    boolean nameFound = false;
                    String name = null;
                    boolean mappingsFound = false;
                    List<String> mappings = null;
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        String fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("@odata.type".equals(fieldName)) {
                            String odataType = reader.getString();
                            if (!ODATA_TYPE.equals(odataType)) {
                                throw new IllegalStateException(
                                        "'@odata.type' was expected to be non-null and equal to '"
                                                + ODATA_TYPE
                                                + "'. The found '@odata.type' was '"
                                                + odataType
                                                + "'.");
                            }
                        } else if ("name".equals(fieldName)) {
                            name = reader.getString();
                            nameFound = true;
                        } else if ("mappings".equals(fieldName)) {
                            mappings = reader.readArray(reader1 -> reader1.getString());
                            mappingsFound = true;
                        } else {
                            reader.skipChildren();
                        }
                    }
                    if (nameFound && mappingsFound) {
                        MappingCharFilter deserializedValue = new MappingCharFilter(name, mappings);

                        return deserializedValue;
                    }
                    List<String> missingProperties = new ArrayList<>();
                    if (!nameFound) {
                        missingProperties.add("name");
                    }
                    if (!mappingsFound) {
                        missingProperties.add("mappings");
                    }

                    throw new IllegalStateException(
                            "Missing required property/properties: " + String.join(", ", missingProperties));
                });
    }
}
