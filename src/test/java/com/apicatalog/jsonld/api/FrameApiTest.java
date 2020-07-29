/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apicatalog.jsonld.api;

import java.io.ByteArrayInputStream;
import java.net.URI;

import javax.json.Json;
import javax.json.JsonObject;

import org.junit.Assert;
import org.junit.Test;

import com.apicatalog.jsonld.JsonLd;
import com.apicatalog.jsonld.document.JsonDocument;
import com.apicatalog.jsonld.http.media.MediaType;
import com.apicatalog.jsonld.lang.Keywords;
import com.apicatalog.jsonld.lang.Version;

public class FrameApiTest {

    public static final MockLoader MOCK_LOADER = new MockLoader(Json.createObjectBuilder().build());
    
    @Test    
    public void test1() throws JsonLdError {
        JsonObject framed = JsonLd.frame(JsonDocument.of(Json.createObjectBuilder().build()), JsonDocument.of(Json.createObjectBuilder().build())).get();
        Assert.assertNotNull(framed);
        Assert.assertEquals(Json.createObjectBuilder().build(), framed);
    }
    
    @Test    
    public void test2() throws JsonLdError {
        JsonObject framed = JsonLd.frame(JsonDocument.of(MediaType.JSON, new ByteArrayInputStream(Json.createObjectBuilder().build().toString().getBytes())),
                JsonDocument.of(Json.createObjectBuilder().build()))
                .context(JsonDocument.of(Json.createObjectBuilder().build()))
                .get();
        Assert.assertNotNull(framed);
        Assert.assertEquals(Json.createObjectBuilder().build(), framed);
    }
    
    @Test    
    public void test3() throws JsonLdError {
        JsonObject framed = JsonLd.frame("https://example.com", "https://example.com/frame").loader(MOCK_LOADER).base("").get();
        Assert.assertNotNull(framed);
        Assert.assertEquals(Json.createObjectBuilder().build(), framed);
    }

    @Test    
    public void test4() throws JsonLdError {
        JsonObject framed = JsonLd.frame(URI.create("https://example.com"), URI.create("https://example.com/frame")).loader(MOCK_LOADER).mode(Version.V1_0).get();
        Assert.assertNotNull(framed);
        Assert.assertEquals(Json.createObjectBuilder().add(Keywords.GRAPH, Json.createArrayBuilder()).build(), framed);
    }
}
