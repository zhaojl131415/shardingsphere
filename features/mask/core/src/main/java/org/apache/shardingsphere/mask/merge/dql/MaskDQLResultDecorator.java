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

package org.apache.shardingsphere.mask.merge.dql;

import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.infra.binder.statement.SQLStatementContext;
import org.apache.shardingsphere.infra.executor.sql.execute.result.query.QueryResult;
import org.apache.shardingsphere.infra.merge.engine.decorator.ResultDecorator;
import org.apache.shardingsphere.infra.merge.result.MergedResult;
import org.apache.shardingsphere.infra.merge.result.impl.transparent.TransparentMergedResult;
import org.apache.shardingsphere.mask.rule.MaskRule;

/**
 * DQL result decorator for mask.
 */
@RequiredArgsConstructor
public final class MaskDQLResultDecorator implements ResultDecorator<MaskRule> {
    
    private final MaskAlgorithmMetaData metaData;
    
    @Override
    public MergedResult decorate(final QueryResult queryResult, final SQLStatementContext<?> sqlStatementContext, final MaskRule rule) {
        return new MaskMergedResult(metaData, new TransparentMergedResult(queryResult));
    }
    
    @Override
    public MergedResult decorate(final MergedResult mergedResult, final SQLStatementContext<?> sqlStatementContext, final MaskRule rule) {
        return new MaskMergedResult(metaData, mergedResult);
    }
}
