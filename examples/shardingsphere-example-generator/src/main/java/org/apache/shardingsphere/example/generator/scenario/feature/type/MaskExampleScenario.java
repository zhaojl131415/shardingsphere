/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.example.generator.scenario.feature.type;

import org.apache.shardingsphere.example.generator.scenario.feature.FeatureExampleScenario;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * Mask example scenario.
 */
public final class MaskExampleScenario implements FeatureExampleScenario {
    
    @Override
    public Map<String, String> getJavaClassTemplateMap() {
        return Collections.emptyMap();
    }
    
    @Override
    public Map<String, String> getResourceTemplateMap() {
        return Collections.emptyMap();
    }
    
    @Override
    public Collection<String> getJavaClassPaths() {
        return Collections.emptySet();
    }
    
    @Override
    public Collection<String> getResourcePaths() {
        return Collections.emptySet();
    }
    
    @Override
    public String getType() {
        return "mask";
    }
}
