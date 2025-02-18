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

/** Clears the identity property of a datasource. */
@Immutable
public final class SearchIndexerDataNoneIdentity extends SearchIndexerDataIdentity {
    /*
     * Identifies the concrete type of the identity.
     */
    private static final String ODATA_TYPE = "#Microsoft.Azure.Search.DataNoneIdentity";

    /** Creates an instance of SearchIndexerDataNoneIdentity class. */
    public SearchIndexerDataNoneIdentity() {}

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("@odata.type", ODATA_TYPE);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SearchIndexerDataNoneIdentity from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of SearchIndexerDataNoneIdentity if the JsonReader was pointing to an instance of it, or null
     *     if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing the polymorphic discriminator.
     * @throws IOException If an error occurs while reading the SearchIndexerDataNoneIdentity.
     */
    public static SearchIndexerDataNoneIdentity fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(
                reader -> {
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
                        } else {
                            reader.skipChildren();
                        }
                    }
                    SearchIndexerDataNoneIdentity deserializedValue = new SearchIndexerDataNoneIdentity();

                    return deserializedValue;
                });
    }
}
