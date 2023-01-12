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

package org.apache.shardingsphere.agent.core.advisor.config.yaml.swapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.agent.core.advisor.config.AdvisorConfiguration;
import org.apache.shardingsphere.agent.core.advisor.config.MethodAdvisorConfiguration;
import org.apache.shardingsphere.agent.core.advisor.config.yaml.entity.YamlAdvisorConfiguration;
import org.apache.shardingsphere.agent.core.advisor.config.yaml.entity.YamlPointcutConfiguration;

/**
 * YAML advisor configuration swapper.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class YamlAdvisorConfigurationSwapper {
    
    /**
     * Swap from YAML advisor configuration to advisors configuration.
     * 
     * @param yamlConfig YAML advisor configuration
     * @return advisor configuration
     */
    public static AdvisorConfiguration swap(final YamlAdvisorConfiguration yamlConfig) {
        AdvisorConfiguration result = new AdvisorConfiguration(yamlConfig.getTarget());
        for (YamlPointcutConfiguration each : yamlConfig.getPointcuts()) {
            YamlPointcutConfigurationSwapper.swap(each).ifPresent(optional -> result.getAdvisors().add(new MethodAdvisorConfiguration(optional, yamlConfig.getAdvice())));
        }
        return result;
    }
}
