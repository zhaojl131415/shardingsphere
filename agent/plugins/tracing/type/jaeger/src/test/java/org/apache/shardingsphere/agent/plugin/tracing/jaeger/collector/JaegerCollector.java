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

package org.apache.shardingsphere.agent.plugin.tracing.jaeger.collector;

import io.opentracing.mock.MockSpan;
import io.opentracing.mock.MockTracer;
import io.opentracing.util.GlobalTracer;
import lombok.SneakyThrows;
import org.apache.shardingsphere.agent.plugin.tracing.rule.CollectorRule;
import org.junit.rules.ExternalResource;
import org.mockito.internal.configuration.plugins.Plugins;

import java.util.List;

public final class JaegerCollector extends ExternalResource implements CollectorRule {
    
    private MockTracer tracer;
    
    @Override
    @SneakyThrows(ReflectiveOperationException.class)
    protected void before() {
        if (!GlobalTracer.isRegistered()) {
            GlobalTracer.register(new MockTracer());
        }
        tracer = (MockTracer) Plugins.getMemberAccessor().get(GlobalTracer.class.getDeclaredField("tracer"), GlobalTracer.get());
    }
    
    /**
     * Get all spans.
     * @return all spans.
     */
    public List<MockSpan> finishedSpans() {
        return tracer.finishedSpans();
    }
    
    @Override
    public void cleanup() {
        tracer.reset();
    }
}
