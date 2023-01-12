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

package org.apache.shardingsphere.test.e2e.transaction.engine.database.opengauss;

import lombok.SneakyThrows;
import org.apache.shardingsphere.test.e2e.transaction.engine.base.TransactionBaseE2EIT;
import org.apache.shardingsphere.test.e2e.transaction.framework.param.TransactionTestParameter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.sql.SQLException;
import java.util.Collection;

@RunWith(Parameterized.class)
public final class OpenGaussJdbcTransactionE2EIT extends TransactionBaseE2EIT {
    
    private final TransactionTestParameter testParam;
    
    public OpenGaussJdbcTransactionE2EIT(final TransactionTestParameter testParam) {
        super(testParam);
        this.testParam = testParam;
    }
    
    @Parameters(name = "{0}")
    public static Collection<TransactionTestParameter> getTestParameters() {
        return getTransactionTestParameters(OpenGaussJdbcTransactionE2EIT.class);
    }
    
    @After
    @SneakyThrows(SQLException.class)
    public void after() {
        getDataSource().close();
        getContainerComposer().close();
    }
    
    @Test
    public void assertTransaction() throws SQLException {
        callTestCases(testParam);
    }
}
